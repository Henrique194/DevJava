# Projeto Programação De Um Cadastro Em Java

## Objetivos
-[x] Projetar **Classes** Com Métodos De **Inserção De Dados** Num Objeto
-[x] **Salvar** Os Dados Do Objeto Num Banco De Dados Através De **JDBC**
-[ ] **Salvar** Os Dados Do Objeto Num Banco De Dados Através De **JDBC**

## Estrutura Do Projeto
```
📦src
 ┗ 📂main
   ┣ 📂java
   ┃ ┗ 📂main
   ┃   ┗ 📜main.java
   ┃
   ┃
   ┣ 📂mjv.dao
   ┃ ┗ 📜CadastroDao.java
   ┃
   ┃
   ┣ 📂mjv.jdbc.connection
   ┃ ┗ 📜Conexao.java
   ┃
   ┃
   ┣ 📂pedido
   ┃ ┣ 📜Conexao.java  
   ┃ ┗ 📂auxiliar
   ┃   ┣ 📜Check.java
   ┃   ┣ 📜FormatTime.java
   ┃   ┣ 📜PedidoAux.java
   ┃   ┣ 📜PedidoItem.java
   ┃   ┣ 📜Print.java
   ┃   ┣ 📜Register.java
   ┃   ┗ 📜Request.java
   ┃
   ┃
   ┣ 📂sistema
   ┃ ┣ 📜Cadastro.java
   ┃ ┣ 📜CD.java
   ┃ ┣ 📜Empresa.java
   ┃ ┣ 📜Entidade.java
   ┃ ┣ 📜Livro.java
   ┃ ┗ 📜Produto.java
   ┃
   ┃
   ┣ 📂transmissao
   ┃ ┣ 📜TransmissorEmail.java
   ┃ ┣ 📜TransmissorMensagem.java
   ┃ ┗ 📜TransmissorSms.java
   ┃
   ┃
   ┗ 📂resources
     ┗ 📂META-INF
       ┗ 📜persistence.xml
```
## Papel Das Classes
Além da classe de execução **Main.java**, criou-se inicialmente um pacote *pedido, sistema e transmissao*. O pacote pedido possui a classe **Pedido.java**, esta que é responsável por representar um pedido associado a um cliente e uma empresa. O pacote pedido ainda guarda um pacote "auxiliar", que tem o papel de executar métodos importantes para o cadastro e associação do cliente com a classe **Pedido.java**. Ademais, também criou-se um pacote sistema com classes relativas à materialização de entidades, tais como: cliente, Empresa, CD, etc.
Atualmente, o projeto é focado em salvar os dados do cliente num banco de dados. Para este fim, escolheu-se o PostgreSQL e o Dbeaver. A abordagem inicial faz uso do JDBC.
