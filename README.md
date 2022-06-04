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