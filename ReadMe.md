# 💡 1. Introdução

### 1.1 Objetivo
Este projeto tem como objetivo gerenciar todos os pedidos de uma lanchonete. Desde o início, com o cadastro de usuários, seleção de itens e pagamento, até o acompanhamento/atualização do status pela cozinha e notificação para retirada pelo cliente.

### 1.2 Event Storming
Modelagem de processos e sistemas utilizada para mapeamento da dinâmica dos eventos relacionados a lanchonete. Utilizamos o fluxo do **DDD(Domain Driven Design)** para descrevemos como funciona a interação dos componentes entre sí. 

**Link para o Board --> https://miro.com/app/board/uXjVK3CWCPY=/**

### 1.3 Como executar o Projeto Localmente?

⚠ Para rodar o sistema localmente, você precisará de:

- Uma IDE compatível para baixar e abrir o repositório, como IntelliJ IDEA, Eclipse, VS Code e etc.
- Docker instalado para a execução dos containers.

**Executando o sistema:**

- Abra o terminal e execute o comando `docker compose up --build` na raiz do projeto.


# 🌟 2. Arquitetura

### 2.1 Visão Geral:
O sistema foi criado usando Java e Spring. A imagem usada é construída via Docker usando o Dockerfile, que realiza o processo de build do artefato. O ambiente é orquestrado através do arquivo `docker-compose.yml`, que cria o banco de dados (Postgres) e suas respectivas tabelas.

### 2.2 Diagrama de Arquitetura:
![Arquitetura Hexagonal](./assets/Arquitetura.gif)


# 📦 3. Domínios e Entidades

## 3.1 Cliente

### Atributos:
- **id (Long):** Identificador único do cliente.
- **email (String):** Endereço de e-mail do cliente.
- **nome (String):** Nome do cliente.Funcionalidades.
- **cpf (String):** CPF do cliente.

### Relacionamentos:
- **Pedidos:** Um cliente pode ter vários pedidos. Este é um relacionamento um-para-muitos com a entidade Pedido.

### Funcionalidades:
- Criar, atualizar e deletar informações de clientes.
- Validar informações do cliente antes do armazenamento.
- Buscar informações detalhadas do cliente.

## 3.2 Produto 

### Atributos:
- **id (Long):** Identificador único do produto.
- **nome (String):** Nome do produto.
- **descricao (String):** Descrição detalhada do produto.
- **valor (Double):** Preço do produto.
- **categoriaProduto:** Categoria do produto, como Lanche, Bebida, etc.

### Relacionamentos:
- **Itens de Pedido:** Um produto pode estar associado a vários pedidos. Relacionamento muitos-para-muitos através da entidade Pedido.

### Funcionalidades:
- Criar, atualizar e deletar produtos.
- Buscar produtos por categoria.
- Validar as informações do produto antes de salvar.

## 3.3 Pedido

### Atributos:
- **id (Long):** Identificador único do pedido.
- **numero (String):** Número de referência do pedido.
- **valorTotal (Double):** Valor total do pedido.
- **statusPedido (StatusPedido):** Estado atual do pedido, como Recebido, Em Preparação e etc.

### Relacionamentos:
- **Cliente:** Cada pedido é feito por um cliente. Relacionamento muitos-para-um.
- **Itens de Pedido:** Um pedido contém vários itens.

### Funcionalidades:
- Processar novos pedidos.
- Atualizar o status do pedido.
- Calcular o valor total do pedido com base nos itens incluídos.

## 3.4 Item

### Atributos:
- **id (Long):** Identificador único do item de pedido.
- **quantidade (Integer):** Quantidade do produto pedido.
- **valorItem (Double):** Preço do item baseado no produto e na quantidade.

### Relacionamentos:
- **Produto:** Cada item de pedido está associado a um produto específico. Relacionamento muitos-para-um.
- **Pedido:** Cada item está associado a um pedido. Relacionamento muitos-para-um.

### Funcionalidades:
- Calcular o custo total do item com base na quantidade e no preço do produto.
- Validar a quantidade do produto (não deve ser zero ou negativa).


# 📚 4 Documentação da API 

Este documento descreve os endpoints disponíveis na API, suas funcionalidades e como utilizá-los.

⚠️ Antes de realizar as chamadas de API, execute a infraestrutura local conforme passo **1.3 "Como executar o Projeto Localmente?"**

**🌐 Swagger**
Você pode acessar a documentação interativa da API via Swagger pelo seguinte link: [Swagger UI](http://localhost:9090/swagger-ui/index.html).

## Endpoints

### 4.1 Cliente

- **Criar Cliente**
  - **Descrição:** Cria um novo cliente no sistema.
  - **Endpoint:** `POST /api/clientes`
  - **Corpo da Requisição:**
  
    ```json
    {
      "email": "string",
      "nome": "string",
      "cpf": "string"
    }
    ```
  - **Resposta de Sucesso:** `201 Created`

    ```json
    {
      "id": "number",
      "email": "string",
      "nome": "string",
      "cpf": "string"
    }
    ```

- **Listar Clientes**
  - **Descrição:** Retorna uma lista de todos os clientes cadastrados.
  - **Endpoint:** `GET /api/clientes`
  - **Resposta de Sucesso:** `200 OK`

    ```json
    [
      {
        "id": "number",
        "email": "string",
        "nome": "string",
        "cpf": "string"
      }
    ]
    ```

- **Obter Cliente por CPF**
  - **Descrição:** Retorna os dados de um cliente específico pelo CPF.
  - **Endpoint:** `GET /api/clientes/{cpf}`
  - **Parâmetro de Caminho:** `{cpf}` - CPF do cliente a ser buscado.
  - **Resposta de Sucesso:** `200 OK`

    ```json
    {
      "id": "number",
      "email": "string",
      "nome": "string",
      "cpf": "string"
    }
    ```

- **Deletar Cliente**
  - **Descrição:** Exclui um cliente do sistema.
  - **Endpoint:** `DELETE /api/clientes/{id}`
  - **Parâmetro de Caminho:** `{id}` - ID do cliente a ser deletado.
  - **Resposta de Sucesso:** `204 No Content`

### 4.2 Produto

**CATEGORIA**
* LANCHE
* ACOMPANHAMENTO
* BEBIDA
* SOBREMESA

- **Criar Produto**
  - **Descrição:** Adiciona um novo produto ao sistema.
  - **Endpoint:** `POST /api/produtos`
  - **Corpo da Requisição:**

    ```json
    {
      "nome": "string",
      "descricao": "string",
      "valor": "number",
      "categoriaProduto": "string"
    }
    ```
  - **Resposta de Sucesso:** `201 Created`

    ```json
    {
      "id": "number",
      "nome": "string",
      "descricao": "string",
      "valor": "number",
      "categoriaProduto": "string"
    }
    ```

- **Listar Produtos**
  - **Descrição:** Retorna uma lista de todos os produtos cadastrados.
  - **Endpoint:** `GET /api/produtos`
  - **Resposta de Sucesso:** `200 OK`

    ```json
    [
      {
        "id": "number",
        "nome": "string",
        "descricao": "string",
        "valor": "number",
        "categoriaProduto": "string"
      }
    ]
    ```

- **Obter Produto por ID**
  - **Descrição:** Retorna os dados de um produto específico pelo ID.
  - **Endpoint:** `GET /api/produtos/{id}`
  - **Parâmetro de Caminho:** `{id}` - ID do produto a ser buscado.
  - **Resposta de Sucesso:** `200 OK`
  
    ```json
    {
      "id": "number",
      "nome": "string",
      "descricao": "string",
      "valor": "number",
      "categoriaProduto": "string"
    }
    ```

- **Listar Produtos por Categoria**
  - **Descrição:** Retorna os produtos que pertencem a uma determinada categoria.
  - **Endpoint:** `GET /api/produtos/categoria/{categoriaProduto}`
  - **Parâmetro de Caminho:** `{categoriaProduto}` - Categoria dos produtos a serem buscados.
  - **Resposta de Sucesso:** `200 OK`

    ```json
    [
      {
        "id": "number",
        "nome": "string",
        "descricao": "string",
        "valor": "number",
        "categoriaProduto": "string"
      }
    ]
    ```

- **Atualizar Produto**
  - **Descrição:** Atualiza as informações de um produto existente.
  - **Endpoint:** `PUT /api/produtos/{id}`
  - **Parâmetro de Caminho:** `{id}` - ID do produto a ser atualizado.
  - **Corpo da Requisição:**

    ```json
    {
      "nome": "string",
      "descricao": "string",
      "valor": "number",
      "categoriaProduto": "string"
    }
    ```
  - **Resposta de Sucesso:** `200 OK`
  
    ```json
    {
      "id": "number",
      "nome": "string",
      "descricao": "string",
      "valor": "number",
      "categoriaProduto": "string"
    }
    ```

- **Deletar Produto**
  - **Descrição:** Remove um produto do sistema.
  - **Endpoint:** `DELETE /api/produtos/{id}`
  - **Parâmetro de Caminho:** `{id}` - ID do produto a ser deletado.
  - **Resposta de Sucesso:** `204 No Content`

### 4.3 Pedido

- **Iniciar Novo Pedido**
  - **Descrição:** Cria um novo pedido no sistema.
  - **Endpoint:** `POST /api/pedidos`
  - **Corpo da Requisição:**
  
    ```json
    {
      "clienteId": "number",
      "itens": [
        {
          "quantidade": "number",
          "produto": {
            "id": "number"
          }
        }
      ]
    }
    ```
  - **Resposta de Sucesso:** `201 Created`
  
    ```json
    {
      "id": "number",
      "numero": "number",
      "dataPedido": "string",
      "valorTotal": "number",
      "statusPedido": "string",
      "cliente": {
        "id": "number",
        "email": "string",
        "nome": "string",
        "cpf": "string"
      },
      "itens": [
        {
          "id": "number",
          "quantidade": "number",
          "valorItem": "number",
          "produto": {
            "id": "number",
            "nome": "string",
            "descricao": "string",
            "valor": "number",
            "categoriaProduto": "string"
          }
        }
      ]
    }
    ```

- **Listar Pedidos**
  - **Descrição:** Retorna uma lista de todos os pedidos realizados.
  - **Endpoint:** `GET /api/pedidos`
  - **Resposta de Sucesso:** `200 OK`

    ```json
    [
      {
        "id": "number",
        "numero": "number",
        "dataPedido": "string",
        "valorTotal": "number",
        "statusPedido": "string",
        "cliente": {
          "id": "number",
          "email": "string",
          "nome": "string",
          "cpf": "string"
        },
        "itens": [
          {
            "id": "number",
            "quantidade": "number",
            "valorItem": "number",
            "produto": {
              "id": "number",
              "nome": "string",
              "descricao": "string",
              "valor": "number",
              "categoriaProduto": "string"
            }
          }
        ]
      }
    ]
    ```