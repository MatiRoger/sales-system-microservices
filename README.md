# Microservices Project - Online Appliance Store

## Project Description

This project involves developing an application for an online appliance store using a microservices architecture with Spring Cloud. Three main microservices will be developed: Products, Shopping Cart, and Sales, which will communicate with each other to provide a seamless shopping experience for users.

## Microservices

### 1. Products Microservice
This service manages the information of appliances available on the platform. Main functionalities:
- List products
- Provide details of each product (code, name, brand, price)

### 2. Shopping Cart Microservice
This service handles the users' shopping carts. Main functionalities:
- Add and remove items from the cart
- Manage the total price of the cart

### 3. Sales Microservice
This service records each sale and associates it with a shopping cart. Main functionalities:
- Record sales with an identification number and date
- Associate a sale with a cart and retrieve the total amount and the list of products

## Requirements Caracteristics

### 2. Development of Microservices

Each microservice will be developed individually, including the necessary CRUD operations and appropriate configuration in the `application.properties` file.

### 3. Configuration of Eureka Server

A Eureka server will be configured to register the microservices. Representative names will be assigned to each service:
- products-service
- shopcarts-service
- sales-service

### 4. Implementation of Load Balancing

Spring Cloud Load Balancer used to implement load balancing:
- Create 2 or more instances of the Products microservice on different ports.
- Simulate constant requests using Postman to verify the load balancer functionality.

### 6. Implementation of API Gateway

Spring Cloud API Gateway implemented to act as an entry point for external clients.

### 7. Docker

Docker will be used for the deployment and execution of the microservices:
- Created Dockerfiles for each service.
- Created a `docker-compose.yml` file.

## Deployment Instructions

### Prerequisites
- Java 21
- Docker
- Docker Compose
- Postman

### Deployment Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/MatiRoger/sales-system-microservices.git
   cd sales-system-microservices
2. **Build and Deploy w/Docker**
   ```bash
   docker-compose build
   docker-compose up

## Contributions
To contribute to this project, please fork the repository and create a pull request with your changes.

