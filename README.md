# 🎮 Game Score API

Uma API RESTful desenvolvida em **Spring Boot** para gerenciamento de **jogos, players e scores**.  
Sistema originalmente adaptado de uma aplicação **desktop Swing** para uma **arquitetura web moderna**.

---

## ✨ Funcionalidades

- ✅ **CRUD Completo** – Create, Read, Update, Delete para todas as entidades  
- 📄 **Relatórios PDF** – Geração de relatórios com **iText 5**  
- 📅 **Filtros por Data** – Consultas personalizadas por período  
- 🌐 **API RESTful** – Endpoints HTTP padrão REST  
- 🗄️ **Persistência MySQL** – Armazenamento robusto com **Spring Data JPA**

---

## 🏗️ Estrutura do Projeto

game-score-api/
├── src/main/java/com/gamescore/
│ ├── controller/ # Controladores REST
│ ├── model/ # Entidades JPA
│ ├── repository/ # Repositórios Spring Data
│ ├── service/ # Lógica de negócio
│ └── GameScoreApiApplication.java
├── src/main/resources/
│ ├── application.properties
│ └── static/
└── pom.xml

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java 23**
- 🍃 **Spring Boot 3.5.5**
- 🗄️ **Spring Data JPA**
- 🐬 **MySQL 5.5.5**
- 📦 **Maven**
- 🖥️ **Tomcat Embedded**

---

## 🔌 Configuração

### Pré-requisitos
- ☕ Java 23+  
- 🐬 MySQL (via **XAMPP** ou servidor dedicado)  
- 📦 Maven 3.6+  

### Passos para rodar o projeto
1. Clone este repositório:  git clone https://github.com/seu-usuario/game-score-api.git
2. Requisição do postman: http://localhost:8081

