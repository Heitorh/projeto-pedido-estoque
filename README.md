# Pedido & Estoque API

Sistema de gerenciamento de pedidos e estoque desenvolvido com **Spring Boot**, **Java 21**, **Spring Data JPA (Hibernate)**, **PostgreSQL** e documentação via **Swagger/OpenAPI**.

---

## 🛠️ Tecnologias Utilizadas
* **Java 21**
* **Spring Boot (v3.3.5)**
    * Spring Web
    * Spring Data JPA
    * Spring Boot Validation
* **PostgreSQL (via Docker)**
* **SpringDoc OpenAPI (Swagger UI)**

---

## 🐳 Configuração e Execução do Ambiente

### 1. Banco de Dados (Docker)
O projeto utiliza um container PostgreSQL rodando no Docker.

> ⚠️ **Atenção (Conflito de Portas):** Se você tiver uma instância nativa do PostgreSQL instalada no Windows (ex: serviço `postgresql-x64-18`), ela pode roubar a porta `5432` e impedir o Docker de funcionar. Caso tenha problemas de conexão, certifique-se de desativar o serviço do Windows via PowerShell:
> ```powershell
> Stop-Service postgresql-x64-18
> Set-Service postgresql-x64-18 -StartupType Disabled
> ```

Para subir o banco de dados, certifique-se de ter um arquivo `docker-compose.yml` configurado ou suba o container manualmente pelo Docker Desktop com a base `pedidoestoque`.

### 2. Executando a Aplicação
Você pode rodar a aplicação diretamente pelo **IntelliJ IDEA** (executando a classe principal `PedidoestoqueApplication.java`) ou via terminal usando o Maven:

```bash
mvn clean spring-boot:run
```

### 3. 🔗 Documentação da API (Swagger)
Com a aplicação rodando na porta 8080, acesse o Swagger UI para testar os endpoints interativamente:

URL: http://localhost:8080/swagger-ui/index.html

### 4.📦 Arquitetura do Projeto (Camadas)
O código está organizado em camadas bem definidas para facilitar a manutenção e escalabilidade:

controller: Camada de entrada que expõe os endpoints REST (/api/...).

service: Concentra as regras de negócio da aplicação.

repository: Interfaces que estendem JpaRepository para comunicação com o banco de dados.

model: Entidades JPA que representam as tabelas do banco (ex: Product).

dto: Objetos de transferência de dados para entrada e saída de requisições.

exception: Tratamento global de erros e exceções customizadas.

### 5. 🚀 Próximos Passos / Funcionalidades
[x] CRUD completo de Produtos (GET, POST, PUT, DELETE)

[ ] Implementação de DTOs para validação desacoplada de Entidades

[ ] Módulo de Pedidos e Controle de Estoque

[ ] Tratamento global de exceções customizadas