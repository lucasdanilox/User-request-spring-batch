# Ler dados da API remota e salvar dados no banco de dados usando Spring Batch
>  Estudo de caso para implementar um job para ler dados de uma API remota e salvar no banco de dados usando Spring Batch

#### Before starting

- [Using Docker Compose with MySQL and phpMyAdmin]
```
version: "3.7"
services:
  # ===============================================================================
  # MYSQL SERVER
  # ===============================================================================
  mysql-docker:
    image: mysql:8.0
    container_name: dev-mysql
    environment:
      MYSQL_DATABASE: mydatabase
      MYSQL_USER: user
      MYSQL_PASSWORD: 1234567
      MYSQL_ROOT_PASSWORD: 1234567
    ports:
      - 3307:3306
    volumes:
      - ./.data/mysql/data:/var/lib/mysql
    networks:
      - dev-network
  # ===============================================================================
  # PHPMYADMIN
  # ===============================================================================
  phpmyadmin-docker:
    image: phpmyadmin/phpmyadmin
    container_name: dev-phpmyadmin
    links:
      - mysql-docker
    environment:
      PMA_HOST: mysql-docker
      PMA_PORT: 3306
      PMA_ARBITRARY: 1
    restart: always
    ports:
      - 5050:80
    depends_on:
      - mysql-docker
    networks:
      - dev-network
# ===============================================================================
# REDE
# ===============================================================================
networks:
  dev-network:
    driver: bridge

```
#### Script 

```sql
CREATE DATABASE app;
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user(login VARCHAR(30), name VARCHAR(60), avatar_url VARCHAR(100), PRIMARY KEY(login));
```
