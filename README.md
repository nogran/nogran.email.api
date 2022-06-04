# nogran-site-backend

## Configuracoes iniciais

| Item             | Descrição                                                    |
| ---------------- | ------------------------------------------------------------ |
| **Name**         | Nome do Projeto (Geralmente em letras minúsculas)            |
| **Type**         | Define o Gerenciador de Dependências (Maven)                 |
| **Packaging**    | Define como a aplicação será empacotada (JAR)                |
| **Java Version** | Versão do Java                                               |
| **Language**     | Linguagem (Java)                                             |
| **Group**        | O domínio reverso de sua empresa ou organização. **Exemplo:** *generation.com* -> ***com.generation*** |
| **Artifact**     | O artefato a ser gerado, ou seja, o nome da aplicação que será criada (Mesmo nome do projeto) |
| **Version**      | Versão da API (não alterar)                                  |
| **Description**  | Descrição do projeto                                         |
| **Package**      | Estrutura do pacote inicial da aplicação (Group + Artifact). Exemplo: ***<u>com.generation.blogpessoal</u>*** |

## Instalacao de Dependecias

| Dependência               | Descrição                                                    |
| ------------------------- | ------------------------------------------------------------ |
| **Spring Web**            | Fornece todas as Bibliotecas necessárias para trabalhar com o protocolo http. |
| **Spring Boot Dev Tools** | Permite a atualização do projeto em tempo real durante o processo de Desenvolvimento da aplicação. |
| **Validation**            | Fornece um conjunto de anotações que permite validar os atributos das Classes da Camada Model. |
| **Spring Data JPA**       | Java Persistence API é uma biblioteca que armazena e recupera objetos que são armazenados em bancos de dados. |
| **MySQL Driver**          | Responsável pela conexão entre nossa API e o Banco de Dados MySQL. |

## Configuração do Banco de Dados

Inserir as linhas abaixo no arquivo **application.properties**, localizado em **src/main/resources**.

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database=mysql
spring.datasource.url=jdbc:mysql://localhost/db_digitalnogran?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo&useSSl=false
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect

spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=Brazil/East
```

| Item                                        | Descrição                                                    |
| ------------------------------------------- | ------------------------------------------------------------ |
| **spring.jpa.hibernate.ddl-auto**           | Define como o JPA irá gerenciar o Banco de dados: **Update** ⇨ atualiza a estrutura do banco de dados, exceto remover atributos ou tabelas, e mantém os dados persistidos. |
| **spring.jpa.database**                     | Define o Banco de dados que será utilizado (MySQL)           |
| **spring.datasource.url**                   | Define o nome do Banco (db_blogpessoal), a criação automática do banco de dados no MySQL (caso não exista), o fuso horario do servidor MySQL e desabilita a camada de segurança da conexão com o MySQL (SSl) |
| **spring.datasource.username**              | Define o usuário do MySQL                                    |
| **spring.datasource.password**              | Define a senha do usuário do MySQL                           |
| **spring.jpa.show-sql**                     | Exibe todas as Queries SQL no Console do STS                 |
| **spring.jpa.properties.hibernate.dialect** | Configura a versão do MySQL, em nosso projeto versão 8.      |
| **spring.jackson.date-format**              | Configura o formato da Data e da Hora da aplicação           |
| **spring.jackson.time-zone**                | Configura o fuso horario da aplicação                        |