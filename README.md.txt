# 💻 CRUD Clientes com Spring Boot e Integração ViaCEP

Este projeto é uma aplicação web completa, desenvolvida com **Spring Boot**, que implementa as operações básicas de CRUD (Criação, Leitura, Atualização e Exclusão) para a entidade `Cliente`. O diferencial é a integração com o serviço **ViaCEP** para preenchimento automático de endereços.

A aplicação segue o padrão arquitetural **MVC** (Model-View-Controller) com a separação clara em camadas (Repository, Service, Controller).

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Framework:** Spring Boot 3
* **Acesso a Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** H2 Database (Embutido e em memória, ideal para desenvolvimento)
* **Template Engine:** Thymeleaf
* **Validação:** Jakarta Bean Validation
* **Integração Externa:** `RestTemplate` para consumo da API ViaCEP
* **Frontend:** HTML5, CSS (Bootstrap 5), JavaScript (jQuery para busca de CEP)

## 🏗️ Arquitetura do Projeto (Camadas)

| Camada | Componente(s) | Responsabilidade |
| :--- | :--- | :--- |
| **Model/Entity** | `Cliente`, `Endereco` | Estrutura de dados e mapeamento para o banco (JPA). O `Endereco` é um objeto embutível. |
| **Repository** | `ClienteRepository` | Interface que herda `JpaRepository`, fornecendo métodos CRUD prontos para a tabela de clientes. |
| **Service (Lógica de Negócio)**| `ClienteService` | Contém a lógica de negócio do CRUD de clientes. |
| **Service (Integração)**| `CepService` | Lógica para comunicação e consumo da API ViaCEP via `RestTemplate`. |
| **Controller (Web MVC)**| `ClienteController` | Gerencia requisições HTTP e devolve Views (páginas Thymeleaf) ao usuário. |
| **Controller (REST API)**| `CepConsultaController` | Expõe um endpoint REST `/api/cep/{cep}` para consulta de endereços (retorna JSON). |

## 🛠️ Como Rodar o Projeto

### Pré-requisitos

Certifique-se de ter o seguinte instalado em sua máquina:

* Java Development Kit (JDK) 17 ou superior.
* Maven ou Gradle (Se estiver usando um IDE como IntelliJ ou Eclipse, geralmente já está configurado).

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [LINK DO SEU REPOSITÓRIO]
    cd crud-clientes-service
    ```

2.  **Execute a aplicação:**

    Se estiver usando Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

3.  **Acesse a Aplicação:**

    Após a inicialização (o Spring Boot geralmente inicia na porta 8080), acesse o link:
    
    🌐 **http://localhost:8080/clientes**

---

## 🔑 Funcionalidades Principais

1.  **Listagem de Clientes:** Exibe todos os clientes cadastrados em uma tabela.
2.  **Cadastro/Edição:**
    * Formulário único para criação e atualização de clientes.
    * Validações de campos obrigatórios e formato (`@NotBlank`, `@Email`, `@Size`).
3.  **Integração com ViaCEP:**
    * Ao digitar o CEP no formulário de cadastro, os campos de endereço (Logradouro, Bairro, Cidade, UF) são preenchidos automaticamente via requisição AJAX (jQuery) para a API ViaCEP.
4.  **Exclusão:** Permite a remoção de clientes com confirmação.
5.  **API de Consulta:** Um endpoint `/api/cep/{cep}` está disponível para consulta programática de endereços (via JSON).

---

## 👥 Autoria (Desenvolvedores)

| RA | Nome Completo |
| :--- | :--- |
| 04723001 | Alexandre Braga Gonçalves |
| 04723111 | Vinícius Damin Kamada |