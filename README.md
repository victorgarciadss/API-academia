# API-Academia

## Descrição:

Esse projeto é uma API de uma academia, onde está todo o back-end do sistema, essa API  permite fazer as quatro operações de CRUD nos alunos da academia, em suas matriculas e suas avaliações físicas.

O projeto contém suas responsabilidades dividas em pacotes de <b>controller</b>, <b>service</b>, e <b>repository</b>.

Também foi feito os tratamentos de exceções devidos para garantir que o sistema não aborte sua execução.

O Sistema foi conectado com o SGBD PostgreSQL para armazenagem de dados.

## Tecnologias utilizadas:

- Java
- Spring Boot
- Spring JPA
- Maven
- PostgreSQL

## Pré-requisitos:

- Java 11
- Maven
- PostgreSQL (recomendado)
- Git

## Como executar: 

Siga os passos abaixo:

### - Clonando o repositório:
Escolha uma pasta do seu computador e abra o terminal do Git Bash dentro dela, após isso execute esse comando:

```bash
git clone https://github.com/victorgarciadss/API-academia.git
```

Após isso, abra a pasta na IDE de sua preferência.

### - Criando a base de dados

Você também deve criar a sua base de dados no PostgreSQL, para isso execute o código abaixo:

```sql
CREATE DATABASE <meu_banco>;
```

### - Configurando o arquivo.properties

Dentro da pasta main do projeto deve ser criado um <b>arquivo.properties</b>, o nome desse arquivo é de sua escolha. Dentro desse arquivo devem ser configuradas algumas coisas para que a aplicação se comunique com o banco de dados, nesse caso o PostgreSQL!

Insira esse código dentro do seu arquivo.properties:

Obs: O código dentro do símbolo <> deve ser substítuido pelas informações do seu banco de dados

```properties
spring.datasource.url=jdbc:postgresql://<nome_da_rede(localhost)>/<nome_do_banco_de_dados>
spring.datasource.username=<seu_usuario>
spring.datasource.password=<sua_senha>
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
```

Após essas configurações vá no arquivo principal da aplicação, que é "AcademiaDigitalApplication.java" e execute o projeto com o botão de executar da sua IDE.

Por último, vá no seu navegador e digite: <b>localhost:8080</b> e pronto, a API estará funcionando. Para fazer a manipulação de dados, recomendo utilizar o postman para fazer as requisições.