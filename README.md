# Projeto de Automação de Testes de API com RestAssured

## Descrição
Este projeto tem como objetivo realizar testes automatizados de backend na API pública [Dog.Ceo- Dog API](https://dog.ceo/dog-api/), utilizando uma stack robusta em Java e ferramentas populares do ecossistema de QA.

## Tecnologias Utilizadas
- Java: Linguagem principal do projeto.
- RestAssured: Framework para testes de APIs RESTful.
- TestNG: Framework de execução e organização dos testes.
- Lombok: Reduz o código "boilerplate" (repetitivo e monótono) como getters, setters, construtores.
- Allure Report: Geração de relatórios.

## Estrutura do Projeto
- src/
- ├── main/
- │ ├── java/
- │ │ ├── client/ # Requisições para a API
- │ │ ├── dto/ # Objetos para transferir dados entre diferentes camadas
- │ │ ├── spec/ # Especificações e configurações do RestAssured
- │ │ └── utils/ # Classe base e utilitários
- │ └── resources/
- ├── test/
- │ ├── java/
- │ │ ├── contrato/ # Testes de contrato (validação de schema)
- │ │ ├── funcional/ # Testes funcionais da API
- │ └── resources/
- │ └── json_schemas/ # Schemas JSON para validação de testes de contrato


## Execução de todos os cenários de testes:
```
gradle test --info
```

## Exemplo para execução de uma classe de testes específica de um pacote:
```
gradle test --tests "funcional.NOME_DA_CLASSE"
```

## Para rodar e gerar o relatório:
```
gradle clean test allureReport
```

## E para visualizar:
```
gradle allureServe
```