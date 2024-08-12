# 💡 1. Introdução

## 1.1 Objetivo
Este projeto tem como objetivo gerenciar todos os pedidos de uma lanchonete. Desde o início, com o cadastro de usuários, seleção de itens e pagamento, até o acompanhamento/atualização do status pela cozinha e notificação para retirada pelo cliente.

## 1.2 Escopo
Listar as principais funcionalidades do sistema, criação, leitura, atualização e exclusão (CRUD) das principais entidades.

## 1.3 Como executar o Projeto Localmente`
Para rodar o sistema localmente, você precisará de:

- Uma IDE compatível para baixar e abrir o repositório, como IntelliJ IDEA, Eclipse, VS Code e etc.
- Docker instalado para a execução dos containers.

*Executando o sistema:*

- Abra o terminal e execute o comando `docker compose up --build`.

# 🌟 2. Arquitetura

## 2.1 Visão Geral
O sistema foi criado usando Java e Spring. A imagem usada é construída via Docker usando o Dockerfile, que realiza o processo de build do artefato. O ambiente é orquestrado através do arquivo `docker-compose.yml`, que cria o banco de dados (Postgres) e suas respectivas tabelas.

## 2.2 Diagrama de Arquitetura`
![Arquitetura Hexagonal](techchallenge-/assets/Arquitetura.gif)

# 📚 3. Domínios e Entidades

## 3.1 Cliente

### Atributos:
- *id (Long):* Identificador único do cliente.
- *email (String):* Endereço de e-mail do cliente.
- *nome (String):* Nome do cliente.Funcionalidades.
- *cpf (String):* CPF do cliente.

### Relacionamentos:
- *Pedidos:* Um cliente pode ter vários pedidos. Este é um relacionamento um-para-muitos com a entidade Pedido.

### 🛠️ Funcionalidades:
- Criar, atualizar e deletar informações de clientes.
- Validar informações do cliente antes do armazenamento.
- Buscar informações detalhadas do cliente.

## 3.2 Produto 

### Atributos:
- *id (Long):* Identificador único do produto.
- *nome (String):* Nome do produto.
- *descricao (String):* Descrição detalhada do produto.
- *valor (Double):* Preço do produto.
- *categoriaProduto:* Categoria do produto, como Lanche, Bebida, etc.

### Relacionamentos:
- *Itens de Pedido:* Um produto pode estar associado a vários itens de pedido. Relacionamento muitos-para-muitos através da entidade Item de Pedido.

### Funcionalidades:
- Criar, atualizar e deletar produtos.
- Buscar produtos por categoria.
- Validar as informações do produto antes de salvar.

## 3.3 Pedido

### Atributos:
- *id (Long):* Identificador único do pedido.
- *numero (String):* Número de referência do pedido.
- *valorTotal (Double):* Valor total do pedido.
- *statusPedido (StatusPedido):* Estado atual do pedido, como Recebido, Em Preparação e etc.

### Relacionamentos:
- *Cliente:* Cada pedido é feito por um cliente. Relacionamento muitos-para-um.
- *Itens de Pedido:* Um pedido contém vários itens. Relacionamento um-para-muitos.

### Funcionalidades:
- Processar novos pedidos.
- Atualizar o status do pedido.
- Calcular o valor total do pedido com base nos itens incluídos.

## 3.4 Item

### Atributos:
- *id (Long):* Identificador único do item de pedido.
- *quantidade (Integer):* Quantidade do produto pedido.
- *valorItem (Double):* Preço do item baseado no produto e na quantidade.

### Relacionamentos:
- *Produto:* Cada item de pedido está associado a um produto específico. Relacionamento muitos-para-um.
- *Pedido:* Cada item de pedido está associado a um pedido. Relacionamento muitos-para-um.

### Funcionalidades:
- Calcular o custo total do item com base na quantidade e no preço do produto.
- Validar a quantidade do produto (não deve ser zero ou negativa).

# 🧰 4 API

⚠️ Antes de realizar as chamadas de API, execute a infraestrutura local conforme passo *1.3*

### 4.1 Cliente
`
- *Criar Cliente:* POST `http://localhost:9090/api/clientes`
- *Listar Clientes:* GET `http://localhost:9090/api/clientes`
- *Obter Cliente por CPF:* GET `http://localhost:9090/api/clientes/{cpf}`
- *Deletar Cliente:* DELETE `http://localhost:9090/api/clientes/{id}`

# 4.2 Produto

- *Criar Produto:* POST `http://localhost:9090/api/produtos`
- *Listar Produtos:* GET `http://localhost:9090/api/produtos`
- *Obter Produto por ID:* GET `http://localhost:9090/api/produtos/{id}`
- *Listar Produtos por Categoria:* GET `http://localhost:9090/api/produtos/categoria/{categoriaProduto}`
- *Atualizar Produto:* PUT `http://localhost:9090/api/produtos/{id}`
- *Deletar Produto:* DELETE `http://localhost:9090/api/produtos/{id}`

# 4.3 Pedido

- *Iniciar Novo Pedido:* POST `http://localhost:9090/api/pedidos`
- *Listar Pedidos:* GET `http://localhost:9090/api/pedidos`