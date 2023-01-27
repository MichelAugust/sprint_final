# Projeto em microserviço


Projeto com Java e Spring Boot para enviar pedidos utilizando mensageria com kafka.




## Pré Requisitos

- Maven 4.0
- Java 17
- Ide(Intellij)
- Docker



## Criando o jar

    mvn clean package

- Utilizando o maven
```        
    mvn spring-boot:run
```

# Pedido *(Order)*

## Entidades:

-  **Pedido:** Id, Cpf, Itens, Total, Endereço.   

- **Item:** Id, Nome, Data de Criação, Data de Validade, Valor, Descricao.  

- **Endereco:** id, rua, numero, bairro, cidade, estado, cep.


## Endpoints:

- getAll-/api/pedido/

- Campo “sort” para asc ou desc  

- Campo “cpf” para filter.

- getById-/api/pedido/{id}

- patch-api/item/{id}

- post-/api/pedido/

- delete-/api/pedido/{id}

## Validações

- O id é gerado automaticamente.

- O CPF deve ser digitado sem ponto ou traço, e a quantidade de números do CPF é validada.

- A data de criação do pedido não pode ser posterior a data de validade do pedido.

- Os tratamentos de resposta ou exceção são proporcionais a resposta ou exceção.

- A API utiliza handler.

- Quando um elemento requerido faltar, a mensagem diz qual falta.

## Testes

- O teste possui cobertura de 70% das regras de negócio (services).

## *Observações*

- Nome do Banco de Dados: “order_db”.

- As datas possuem o formato: *Dia/Mes/Ano Hora:Minuto:Segundo*.

- É utilizado o MySql com a porta: 3306.

- O código é organizado com base na arquitetura hexagonal.

##

# History *(historico de pedidos)*

Recebe o id do pedido e o seu total, por meio de uma fila gerada quando um novo pedido é salvo na API Pedido. Os dados recebidos são salvos em uma tabela do BD mongo, com um código único gerado automaticamente e a data do momento do evento. Foi utilizado o Kafka. Ele se comunica com o order_db.

~~~
curl --location --request GET 'http://localhost:8082/api/history'

~~~

Efetua o pedido, monta as informações e envia a requisição para o serviço de pedidos (/api/pedido) e retorna as informações do pedido:

~~~
curl --location --request POST 'http://localhost:8080/api/pedidos' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": 0,
  "cpf": "00022233312",
  "items": [
    {      
      "nome": "test",      
      "data_de_validade": "",
      "valor": 100.00,
      "descricao": "test"
    }
  ],
  "total": 1,
  "address": {
      "cep": "81320000",
      "number": "608"            
  }
}
~~~


