# 🎮 Sistema de pontuação de jogos

Uma API Rest desenvolvida em **Spring Boot** para gerenciamento de **jogos, players e scores**.  
Sistema originalmente adaptado de uma aplicação **desktop Swing com JFrame** para uma **arquitetura web moderna**.

---

## ✨ Funcionalidades

- ✅ **CRUD Completo** – Create, Read, Update, Delete para todas as entidades   
- 🌐 **API REST** – Endpoints HTTP padrão REST  
- 🗄️ **Persistência MySQL** – Armazenamento robusto com **Spring Data JPA**

---

## 🏗️ Estrutura do Projeto

game-score-api/
<br>
├── src/main/java/com/gamescore/
<br>
│ ├── controller/ # Controladores REST
<br>
│ ├── model/ # Entidades JPA
<br>
│ ├── repository/ # Repositórios Spring Data
<br>
│ ├── service/ # Lógica de negócio
<br>
│ └── GameScoreApiApplication.java
<br>
├── src/main/resources/
<br>
│ ├── application.properties
<br>
│ └── static/
<br>
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

