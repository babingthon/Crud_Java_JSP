# CRUD de Produtos

Projeto simples de um sistema de **Cadastro de Produtos** (CRUD) utilizando:

- Java
- JSP (Java Server Pages)
- Servlets
- PostgreSQL

## Funcionalidades

- **Cadastrar Produto**
- **Consultar Produtos**
- **Alterar Produto**
- **Excluir Produto**

## Tecnologias Utilizadas

- Java (JDK 8+)
- JSP
- Servlets
- Banco de Dados PostgreSQL
- JDBC (Java Database Connectivity)

## Banco de Dados

Exemplo de tabela `produto`:

```sql
CREATE TABLE produto (
    idproduto SERIAL PRIMARY KEY,
    descricao VARCHAR(100),
    quantidade INT,
    preco NUMERIC(10,2),
    online BOOLEAN
);
