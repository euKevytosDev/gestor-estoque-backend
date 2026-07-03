# Gestor de Estoque — Backend (API REST)

API REST em **Java + Spring Boot** para gerenciamento de produtos em estoque. Projeto de estudo/prática com CRUD completo, persistência em PostgreSQL e integração com front-end React.

## Repositório relacionado

- Front-end: [gestor-estoque-frontend](https://github.com/euKevytosDev/gestor-estoque-frontend)

## Sobre o projeto

Sistema simples de controle de estoque com operações básicas: cadastrar, listar e excluir produtos. Cada produto possui nome, preço e quantidade.

Foi desenvolvido para praticar **Spring Boot**, **JPA**, **PostgreSQL** e consumo de API REST pelo front-end.

## Stack

| Tecnologia | Uso |
|---|---|
| Java 17 | Linguagem |
| Spring Boot 4 | Framework |
| Spring Data JPA | ORM / persistência |
| PostgreSQL | Banco de dados |
| Maven | Dependências e build |

## Funcionalidades

- Listar todos os produtos (`GET`)
- Cadastrar produto (`POST`)
- Excluir produto por ID (`DELETE`)

## Estrutura do projeto

```text
gestor-estoque-backend/
├── src/main/java/com/gestor/estoque/
│   ├── EstoqueApplication.java    # Classe principal
│   ├── controller/
│   │   └── ProdutoController.java # Endpoints REST
│   ├── model/
│   │   └── Produto.java           # Entidade JPA
│   └── repository/
│       └── ProdutoRepository.java # Acesso ao banco
└── pom.xml
```

## Endpoints

| Método | Rota | Descrição | Body (JSON) |
|---|---|---|---|
| GET | `/produtos` | Lista todos os produtos | — |
| POST | `/produtos` | Cadastra produto | `{ "nome", "preco", "quantidade" }` |
| DELETE | `/produtos/{id}` | Remove por ID | — |

### Exemplo — cadastrar produto

```bash
curl -X POST http://localhost:8080/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Arroz 5kg","preco":25.90,"quantidade":50}'
```

## Modelo de dados

```text
Produto
├── id          (Long, auto-gerado)
├── nome        (String)
├── preco       (Double)
└── quantidade  (Integer)
```

## Como rodar localmente

### Pré-requisitos
- Java 17+
- PostgreSQL rodando (local ou Neon)
- Maven (ou `./mvnw`)

### Configuração do banco

Crie `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/estoque
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Executar

```bash
git clone https://github.com/euKevytosDev/gestor-estoque-backend.git
cd gestor-estoque-backend
./mvnw spring-boot:run
```

API em: `http://localhost:8080`

## Integração com o front-end

O React consome a API em `http://localhost:8080/produtos`. Certifique-se de que o back-end está rodando antes de abrir o front.

## Conceitos praticados

- Anotações Spring: `@RestController`, `@GetMapping`, `@PostMapping`, `@DeleteMapping`
- JPA: `@Entity`, `@Id`, `@GeneratedValue`
- Repository pattern com `JpaRepository`
- API REST e JSON

## Autor

**Raian Kevin** — Desenvolvedor Full Stack

- GitHub: [@euKevytosDev](https://github.com/euKevytosDev)
- Portfólio: [portfolio-raian](https://github.com/euKevytosDev/portfolio-raian)
