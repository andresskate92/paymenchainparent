package com.macl.customer.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.macl.customer.entity.CustomerEntity;
import com.macl.customer.service.ICustomerEntityService;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 11:46
 * * @project paymenchainparent
 * * @version 1.0
 **/
@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    ICustomerEntityService iCustomerEntityService;

    private final WebClient.Builder builder;

    public CustomerRestController(WebClient.Builder builder) {
        this.builder = builder;
    }

    HttpClient httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .option(ChannelOption.SO_KEEPALIVE, true)
            .option(EpollChannelOption.TCP_KEEPIDLE, 300)
            .option(EpollChannelOption.TCP_KEEPINTVL, 60)
            .responseTimeout(Duration.ofSeconds(1))
            .doOnConnected(connection -> {
                connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
            });

    @GetMapping
    public List<CustomerEntity> findAll() {
        return iCustomerEntityService.findAll();
    }

    @GetMapping("/find-by-id")
    public CustomerEntity findById(@RequestParam("id") Long id) {
        return iCustomerEntityService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdate(@RequestBody CustomerEntity customerEntity) {
        customerEntity.getProducts().stream().forEach(product -> product.setCustomerEntity(customerEntity));
        return ResponseEntity.ok(iCustomerEntityService.saveOrUpdate(customerEntity));
    }

    @GetMapping("/full")
    public CustomerEntity findByCode(@RequestParam("code") String code) {

        CustomerEntity customer = iCustomerEntityService.findByCode(code);
        customer.getProducts().stream().forEach(product -> {
            String productName = getProductName(product.getProductId());
            product.setProductName(productName);
        });

        List<?> genericTransaction = getTransactions(customer.getIban());
        customer.setTransanctions(genericTransaction);
        return customer;
    }


    private String getProductName(long id) {

        WebClient webClient = builder.clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl("http://businnessdomain-product/product")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://businnessdomain-product/product"))
                .build();

        JsonNode jsonNode = webClient.method(HttpMethod.GET).uri("/find-by-id?id=" + id).retrieve().bodyToMono(JsonNode.class).block();
        return jsonNode.get("name").asText();
    }


    private List<?> getTransactions(String accountIban) {

        WebClient webClient = builder.clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl("http://businessdomain-transactions/transactions")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://businessdomain-transactions/transactions"))
                .build();

        List<?> genericTransactions = webClient.method(HttpMethod.GET).uri(uriBuilder -> uriBuilder
                .path("/customer").queryParam("accountIban", accountIban).build()).retrieve().bodyToFlux(Object.class).collectList().block();
        return genericTransactions;
    }

}
