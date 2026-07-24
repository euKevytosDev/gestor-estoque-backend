# Gestor de Estoque — Backend

API REST em Java + Spring Boot pra cadastrar, listar e excluir produtos. Projeto de estudo: CRUD enxuto pra praticar Spring, JPA e PostgreSQL, e plugar num front React.

Front: [gestor-estoque-frontend](https://github.com/euKevytosDev/gestor-estoque-frontend)

## Por que existe

Eu queria um back pequeno, mas “de verdade”: entidade, repository, controller REST e banco. Sem overengineering — o ponto é entender o caminho produto → JSON → Postgres.

Cada produto tem nome, preço e quantidade.

## Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Endpoints

| Método | Rota | Body |
|--------|------|------|
| GET | `/produtos` | — |
| POST | `/produtos` | `{ "nome", "preco", "quantidade" }` |
| DELETE | `/produtos/{id}` | — |

Exemplo:

```bash
curl -X POST http://localhost:8080/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Arroz 5kg","preco":25.90,"quantidade":50}'
```

## Estrutura

```text
src/main/java/com/gestor/estoque/
├── EstoqueApplication.java
├── controller/ProdutoController.java
├── model/Produto.java
└── repository/ProdutoRepository.java
```

## Modelo

```text
Produto
├── id          Long (gerado)
├── nome        String
├── preco       Double
└── quantidade  Integer
```

## Rodar local

Precisa de Java 17+, PostgreSQL e Maven (`./mvnw` serve).

No `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/estoque
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

```bash
git clone https://github.com/euKevytosDev/gestor-estoque-backend.git
cd gestor-estoque-backend
./mvnw spring-boot:run
```

API em `http://localhost:8080`. O React consome `/produtos` nessa base — sobe o back antes do front.

## O que pratiquei aqui

- `@RestController` + mapeamentos HTTP
- Entidade JPA (`@Entity`, `@Id`, `@GeneratedValue`)
- `JpaRepository` sem SQL na mão
- Contrato JSON simples pro front

## Autor

Raian Kevin — [@euKevytosDev](https://github.com/euKevytosDev)
