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

![UntitledDiagram](https://raw.githubusercontent.com/Henrique194/DevJava/main/SpringProject/imgs/Untitled%20Diagram.png)

## Papel Das Classes
Além da classe de execução **SpringProjectApplication.java**, criou-se uma série de pacotes para cuidar da inclusão de dados no banco, das requisições HTTP e das exceções. Primeiramente, no **pacote _repositories_**, encontram-se duas classes que iram das operações CRUD: 
- **AlunoRepository** que irá cuidar da inserção do objeto **Aluno**;
- **PessoaRepository** que irá cuidar da inserção do Objeto **Pessoa**.

A classe _Aluno_ representa um aluno que irá se cadastrar. Esta classe foi codificada da seguinte maneira:

![Aluno](https://raw.githubusercontent.com/Henrique194/DevJava/main/SpringProject/imgs/Aluno.png)

Como se pode observar, a classe é formada por um **atributo "id"** (como **Primary Key** no banco de dados) e um **atributo "nível"**. Além disso, percebe-se que a classe _Aluno_ também possui um atributo pessoa, de modo que um aluno contém informações pessoais, tais como: nome, nacionalidade, cpf, etc. Observa-se uma **"Foreign Key"**, de modo que a "tab_aluno" fique conectada a outra tabela que contêm as **informações pessoais deste aluno**. A "Foreign Key" está associada ao "id" do aluno, assim o aluno tem um mesmo "id" tanto na "tab_aluno" quanto na tabela com as informações pessoais. Por fim, este aluno possui dois contatos de emergência, que são representados pelos objetos "contato1" e "contato2". Diferentemente do "contato1", não é necessário registrar um "contato2" no banco de dados.

                                    Classe _Pessoa_ com as infromações pessoais do aluno:
                                                  
![Pessoa](https://raw.githubusercontent.com/Henrique194/DevJava/main/SpringProject/imgs/Pessoa.png)

No **pacote "_mjv.controllers_"** se encontra as classes responsáveis por gerenciar as requisições HTTP. Elas permitem que tanto um aluno quanto uma pessoa possam ser registrados no banco de dados, além atualizar ou deletar qualquer registro já existente. Estes são os métodos da classe **_AlunoController_**:

![AlunoController](https://raw.githubusercontent.com/Henrique194/DevJava/main/SpringProject/imgs/AlunoController1.png)

Como se pode observar, esta classe possui os **métodos CRUD**. Ademais, os métodos contam com uma **exceção** para alertar o usuário de uma ação incompatível, como por exemplo, deletar um cadastro que não se encontra no banco de dados. A exceções são tratadas pelo **_GlobalHandler.java_**, que retorna a exceção mais legível para o usuário. A classe _PessoaController.java_ possui métodos análogos aos da classe _AlunoController.java_ e ainda alguns outros, como 'findByName" e "findByNomeContaining" que realizam uma busca especializada no banco de dados.

## GlobalHandler E Exceções

Para que as exceções do banco de dados se tornem mais apropriadas ao usuário, foi criado o **pacote "mjv.exceptions"**. Este pacote contém duas classes: "_NotFoundExcpetion.java_" e "_PostExcpetion.java_". A primeira **exceção** é lançada se o usuário tentar realizar uma ação sobre um **cadastro que não existe** no banco de dados, como deletar ou atualizar ("PUT"/"PATCH"). Já a **segunda exceção** ocorre se o usuário tentar adicionar um cadastro ("POST") com um "id" **já registrado** no banco.

                                                   Exemplo De Erro Tratado:

![Error](https://raw.githubusercontent.com/Henrique194/DevJava/main/SpringProject/imgs/Error.png)

Para tratar essas exceções foi criado a classe _GlobalHandler_.

                                                   Classe GlobalHandler:

![GlobalHandler](https://raw.githubusercontent.com/Henrique194/DevJava/main/SpringProject/imgs/GlobalHandler.png)

Como se pode observar, esta classe captura as exceções específicas e as trata de maneira adequada.
