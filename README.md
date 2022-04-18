<h1 align="center">To Do Board - PRODAM</h1>
Projeto cujo o usuário pode criar e manipular uma "To Do List". o usuário terá um login para o acesso da área de sua lista. Cada usuário utiliza apenas um login, ou seja, caso tiverem logins equivalentes (nome), o próprio programa recusaria a entrada dos dados informados e requisitaria informações de login diferentes.

##
<!--ts-->
O nosso To Do Board tem uma lista básica de funções, algumas delas são:
   * Cadastro de logins (usuário e senha);
   * Criar e visualizar registros de tarefas;
   * Incluir novos registros de tarefas;
   * Atualizar e excluir tarefas da lista;
<!--te-->
##
<h2>Linguagens & Softwares utilizados:</h2>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

##
<h2>Pré-requisitos</h2>
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
Docker, Java 11 (ou posterior)

<h2>Como executar</h2>

Após clonar o projeto e com o Docker em funcionamento, inicializaremos o terminal na pasta do projeto e executamos o comando para inicializar o banco de dados `docker-compose up -d`


Com a iniciação do Docker sucedida, executamos o comando `./mvnw spring-boot:run` para enfim, rodar a aplicação.
