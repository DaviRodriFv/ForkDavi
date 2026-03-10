# API REST – Veículos (Spring Boot)

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de veículos.
O sistema permite realizar operações CRUD de **Carros, Motos e Caminhões**.

A API possui **autenticação via API Key**, onde requisições para rotas protegidas devem enviar uma chave válida no header.

---

# Autenticação via API Key — Java + Spring Boot

## Sobre

Este projeto implementa autenticação via **API Key** em uma API REST utilizando **Java + Spring Boot**.

Toda requisição para rotas protegidas deve incluir o header:

```
X-API-KEY: sua-chave
```

Caso a chave esteja **ausente ou inválida**, a API retorna:

```
401 Unauthorized
```

---

# Como rodar o projeto

## Pré-requisitos

* Java 17 ou superior
* Maven
* IDE

## Passos

Clone o repositório:

```
git clone https://github.com/unilopers/trabalhoFinalFelipeAPIREST.git
```

Entre na pasta do projeto:

```
cd trabalhoFinalFelipeAPIREST
```

Execute a aplicação:

```
./mvnw spring-boot:run
```

Ou no Windows:

```
mvnw.cmd spring-boot:run
```

A API será iniciada em:

```
http://localhost:8080
```

---

# Como usar a autenticação

Para acessar rotas protegidas, adicione o header **X-API-KEY** na requisição.

### Exemplo com curl

```
curl http://localhost:8080/api/carro \
  -H "X-API-KEY: minha-chave-secreta"
```

### Exemplo sem chave (retorna erro)

```
curl http://localhost:8080/api/carro
```

Resposta:

```
401 Unauthorized
```

---

# Rotas disponíveis

Abaixo está um exemplo de endpoints utilizando o recurso **Carro**.  
Os recursos **Moto** e **Caminhão** seguem a mesma estrutura de rotas e operações CRUD.

## Carros

| Método | Rota            | Descrição             |
| ------ | --------------- | --------------------- |
| GET    | /api/carro      | Lista todos os carros |
| GET    | /api/carro/{id} | Busca carro por ID    |
| POST   | /api/carro      | Cria um novo carro    |
| PUT    | /api/carro/{id} | Atualiza um carro     |
| DELETE | /api/carro/{id} | Remove um carro       |

---

# Estrutura do projeto

```
src
 └── main
     └── java
         └── controller
             ├── CarroController
             ├── MotoController
             └── CaminhaoController
         └── model
         └── repository
         └── security
```

---

# Tecnologias utilizadas

* Java
* Spring Boot
* Spring Security

---

# Referências

https://www.baeldung.com/spring-security-api-key-authentication

https://docs.spring.io/spring-security/reference/index.html

https://aws.amazon.com/pt/what-is/api-key/

---

# Equipe

| Membro    | Responsabilidade                    |
| --------- | ----------------------------------- |
| Cauã      | Implementação do ApiKeyFilter       |
| Davi      | Configuração do SecurityFilterChain |
| Gustavo   | Criação dos endpoints               |
| João      | Testes                              |
| Guilherme | Documentação (README)               |

---
