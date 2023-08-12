#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER mcabrera WITH PASSWORD 'mcabrera';
    CREATE DATABASE db_desarrollo;
    GRANT ALL PRIVILEGES ON DATABASE mcabrera TO db_desarrollo;
EOSQL