# Projeto de página de administradores, usando Spring Boot com Java 17 e MySQL

*Disclaimer*:
Um template bootstrap foi usado como base para o html da página.

Este projeto utiliza **Spring Boot** e depende de **Java 17**, além de pacotes como **Spring Data JPA** e **MySQL**. 

O Objetivo desse projeto é criar uma página onde pode-se **Criar**, **Visualizar**, **Editar** e **Deletar** Administradores após fazer login com credenciais válidas.

Abaixo estão os passos necessários para configurar e rodar a aplicação.

---

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados:
- **Java JDK 17**
- **Apache Maven**
- **MySQL Community Server**

---

## Passos para configurar o ambiente e rodar o projeto

### Passo 1: Clonar o repositório
1. Clone o repositório do projeto e navegue até o diretório do projeto:
    ```bash
    git clone <URL_DO_REPOSITORIO>
    cd <PASTA_DO_REPOSITORIO>
    ```

### Passo 2: Compile o projeto com o Maven
1. Configure o arquivo **application.properties** com as informações de seu Banco de Dados.
2. Baixe as dependências e compile o projeto com o Maven:
    ```bash
    mvn clean install
    ```

### Passo 3: Testar a aplicação (Obrigatório para acessar a página de administradores manualmente)
1. Execute os testes configurados no projeto com o seguinte comando:
    ```bash
    mvn test
    ```
   Isso irá criar um usuário pré-definido para fazer login e acessar a página de administradores atráves do localhost.
   
   Para ver o e-mail e senha verifique **limpaCriaUsuario()** em **SpringWebApplicationTests.java**

### Passo 4: Rodar a aplicação
1. Execute a aplicação com o comando:
    ```bash
    .\mvnw.cmd spring-boot:run
    ```

### Passo 5: Acessar e testar a aplicação manualmente (Opcional)
1. Após iniciar, a aplicação estará disponível em:  
   **http://localhost:8080**
2. Endpoints disponíveis e suas funcionalidades:

| Endpoint                   | Função                            |
|----------------------------|-----------------------------------|
| `/`                        | Home / Página inicial             |
| `/login`                   | Página de Login                   |
| `/administradores`         | Lista de todos administradores    |
| `/administradores/novo`    | Criação de novos administradores  |
| `/administradores/{id}`    | Atualizar administradores pelo ID |


3. Os demais endpoints podem ser acessados por seus respectivos botões, assim não sendo necessário digitar o caminho. É possível ver os endpoints na pasta de controllers.
---

