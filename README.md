# Projeto Estudo - Arquitetura Hexagonal
Esse projeto foi desenvolvido no intuito de estudar e me familiarizar com a arquitetura hexagonal

#### Passo a Passo para Docker:
1. Navegue até o diretório raiz do projeto.
2. Execute o seguinte comando para subir a aplicação e o banco de dados:
```bash
docker-compose up -d
```
3. Execute os comandos abaixo para criar os topicos no kafka 
```bash
docker exec -it docker-local-kafka-1 bash
```
```bash
kafka-topics --create --topic tp-cpf-validated --bootstrap-server kafka:9096 --partitions 1 --replication-factor 1 &&
kafka-topics --create --topic tp-cpf-validation --bootstrap-server kafka:9096 --partitions 1 --replication-factor 1
```
Esse comando irá criar os containers necessários para a aplicação e o banco de dados.
- O banco de dados será exposto na porta **5432**.
- A aplicação será exposta na porta **8080**.
- Caso as portas não estejam disponíveis, você pode alterar as configurações no arquivo `docker-compose.yaml`.


Caso queira adicionar mais mocks de endereço é só adicionar um novo json na pasta mappings com o padrão do json abaixo

```json
{
  "request": {
    "method": "GET",
    "url": "/addresses/24240705"
  },
  "response": {
    "status": 200,
    "headers": {
      "Content-Type": "application/json"
    },
    "jsonBody": {
      "street": "Rua Hexagonal",
      "city": "Uberlândia",
      "state": "Minas Gerais"
    }
  }
}
```

Para enviar uma produzir uma mensagem a ser consumida pela aplicação basta acessar 
o Kafdrop no endereço http://localhost:9000/ 

Url Local para conexão com o kafka: http://localhost:9097/

Acesso a collection do Mongo:

1. Acessando a base de dados
```bash
docker exec -it docker-local-mongo bash
```
```bash
mongosh -u root -p 
```
```bash
example
```
2. Aecssando a Collection
```bash
use hexagonal
```
```bash
show collections
```
```bash
db.customers.find()
```

### JSONs :

#### POST Coustomers - http://localhost:8081/api/v1/customers

```json
{
  "name": "Teste1",
  "zipCode": "24240710",
  "cpf": "00000000001"
}
```

#### GET Coustomers- http://localhost:8081/api/v1/customers/{id}

#### PUT Coustomers - http://localhost:8081/api/v1/customers/{id}

```json
{
  "name": "Teste2",
  "zipCode": "24110000",
  "cpf": "11111111112"
}
```

#### GET Address - http://localhost:8082/addresses/{zipCode}

### Json Producer 

```json
{
  "id": "675ce19a0e1172745539abe9",
  "name": "Evandro",
  "zipCode": "24110566",
  "cpf": "11111111112",
  "isValidCpf": true
}
```






