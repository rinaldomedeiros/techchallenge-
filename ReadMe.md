# 1. Introduction

## 💡 1.1 Objective
This project aims to manage all orders of a snack bar. From the beginning, user registration, item selection, and payment. Until the tracking/updating of status by the kitchen and notification for customer pickup.

## 📲 1.2 Scope
List the main functionalities of the system, creation, reading, updating, and deletion `(CRUD)` of the main entities.

## 🌟 1.3 How tp Run the Project Locally`
To run the system locally, you will need:

- A compatible IDE to download and open the repository such as IntelliJ IDEA, Eclipse, VS Code, etc.
- Docker installed for container execution.

Running the system:

- Open the terminal and run the command `docker compose up`

# Architecture

## 2.1 Overview
The system was created using Java and Spring. The image used is built via Docker using the Dockerfile, which performs the artifact build process. The environment is orchestrated through docker-compose.yml, and it creates the database (Postgres) and its respective tables.

## 2.2 Architecture Diagram
Incluir um diagrama?

# 📚 3. Domains and Entities

## 3.1 Customer

- Attributes:
- Relationships:
- Functionalities:

## 3.2 Product

- Attributes:
- Relationships:
- Functionalities:

## 3.3 Order

- Attributes:
- Relationships:
- Functionalities:

## 3.4 Order Item

- Attributes:
- Relationships:
- Functionalities:

## 3.5 Chef

- Attributes:
- Relationships:
- Functionalities:

# 4 API

# 4.1 Customer

- Create Customer: POST /customers
- List Customers: GET /customers
- Get Customer by ID: GET /customers/{id}
- Get Customer by CPF: GET /customers/cpf/{cpf}
- Update Customer: PUT /customers/{id}
- Delete Customer: DELETE /customers/{id}

# 4.2 Product

- Create Product: POST /products
- List Products: GET /products
- List Products by Category: GET /products/category/{category}
- Get Product by ID: GET /products/{id}
- Update Product: PUT /products/{id}
- Delete Product: DELETE /products/{id}

# 4.3 Order

- Start New Order: POST /orders
- List Orders: GET /orders
- Get Order by ID: GET /orders/{id}
- Complete Order: PUT /orders/{id}/complete

# 4.4 Order Item

- Add New Product to Order: POST /orders/{id}/items
- Update Product in Order: PUT /orders/{id}/items/{item_id}
- elete Product from Order: DELETE /orders/{id}/items/{item_id}

# 4.5 Chef

- Create Chef: POST /chefs
- List Chefs: GET /chefs
- Get Chef by ID: GET /chefs/{id}
- Update Chef: PUT /chefs/{id}
- Delete Chef: DELETE /chefs/{id}