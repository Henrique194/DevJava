# Projeto Programação De Um Cadastro Em Java

## Objetivos
- [x] Projetar **Classes** Com Métodos De **Inserção De Dados** Num Objeto
- [x] Projetar Métodos CRUD com **SpringBoot**
- [X] Tratar Exceções Com Handler

## Estrutura Do Projeto
```
📦src
 ┗ 📂main
   ┣ 📂java
   ┃ ┗ 📂mjv
   ┃   ┗ 📜SpringProjectApplication.java
   ┃   ┃
   ┃   ┃
   ┃   ┣  📂config
   ┃   ┃  ┗ 📜SwaggerConfig.java
   ┃   ┃
   ┃   ┃
   ┃   ┣  📂controllers
   ┃   ┃  ┣ 📜AlunoController.java
   ┃   ┃  ┃
   ┃   ┃  ┗ 📜PessoaController.java
   ┃   ┃
   ┃   ┃
   ┃   ┣  📂entity
   ┃   ┃  ┣ 📜Aluno.java
   ┃   ┃  ┃
   ┃   ┃  ┣ 📜ContatoEmergencia.java
   ┃   ┃  ┃
   ┃   ┃  ┣ 📜Pessoa.java
   ┃   ┃  ┃
   ┃   ┃  ┗ 📂enums
   ┃   ┃    ┣ 📜NivelAluno.java
   ┃   ┃    ┃
   ┃   ┃    ┣ 📜Parentesco.java
   ┃   ┃    ┃
   ┃   ┃    ┗ 📜Sexo.java
   ┃   ┃
   ┃   ┃
   ┃   ┣  📂exceptions
   ┃   ┃  ┣ 📜NotFoundException.java
   ┃   ┃  ┃
   ┃   ┃  ┗ 📜PostException.java
   ┃   ┃
   ┃   ┃
   ┃   ┣  📂handler
   ┃   ┃  ┣ 📜GlobalHandler.java
   ┃   ┃  ┃
   ┃   ┃  ┗ 📜ResponseError.java
   ┃   ┃
   ┃   ┃
   ┃   ┗  📂repositories
   ┃      ┣ 📜AlunoRepository.java
   ┃      ┃
   ┃      ┗ 📜PessoaRepository.java
   ┃
   ┃
   ┗ 📂resources
     ┗ 📜application.properties
```
## Papel Das Classes
Além da classe de execução **Main.java**, criou-se inicialmente um *pacote pedido, sistema e transmissao*. O pacote pedido possui a classe **Pedido.java**, esta que é responsável por representar um pedido associado a um cliente e uma empresa. O *pacote pedido* ainda guarda um pacote "auxiliar", que tem o papel de executar métodos importantes para o cadastro e associação do cliente com a classe **Pedido.java**. Ademais, também criou-se um *pacote sistema* com classes relativas à materialização de entidades, tais como: cliente, Empresa, CD, etc.

Atualmente, o projeto é focado em salvar os dados do cliente num banco de dados. Para este fim, escolheu-se o *PostgreSQL* e o *Dbeaver*. A abordagem inicial faz uso do *JDBC*, mas o projeto também pretende fazer uso de *JPA*.
