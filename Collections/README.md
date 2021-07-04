# Estudo Sobre Framework Collections - MAP
## Definição Da Framework Collections  
Coleções são estruturas da qual um objeto é capaz de agrupar outros objetos. Partindo desse princípio, a Framework Collections pode ser definida como:
> "uma arquitetura unificada que para representação e manipulação de coleções."<sup>[[1]]</sup>

A Java Collections Framework também é muito útil, pois ajuda a minimizar o esforço de programação, reduz o esforço de aprender API e ajuda na reutilização de software.<sup>[[1]]</sup>.

Diagrama Do Framework Collections:

 <p align="center">
  <img align="center" src="Imagens/Framework.png" width=750>  
</p>

[1]: <https://docs.oracle.com/javase/tutorial/collections/intro/index.html>

Como se pode observar, ela é composta pelas interfaces e suas respectivas implementações. Ainda, pode surgir uma confusão associadas a palavra "_Collections_":<sup>[[2]]</sup>
- Ela pode se referir a qualquer coleção, como List, Set, Map e Queue;
- Quando escrita com "_C_" maiúsculo e "_s_" no final, ela se refere a classe Collections;
- Quando escrita somente com "_C_" maiúsculo e **sem** "_s_" no final, ela se refere a a interface Collection;

As coleções ainda podem ser ordenadas e/ou classificadas<sup>[[2]]</sup>:
* Para ser ordenada, os elementos da coleção devem poder ser iterados numa ordem específica. Esta ordem específica pode ser relacionada aos índices dos elementos ou atém mesmo o momentos em que foi inserido os elementos.
* Para ser classificada, os elementos da coleção devem respeitar uma ordem estabelecida por regras. Dessa maneira, toda coleção classifica é também uma coleção ordenada. Entretando, esta "ordem estabelecida por regras" (ordem de classificação) não esta relacionada aos indices ou momentos de inserção dos elementos, mas sim as propriedades dos elementos.

Para este estudo, iremos focar na Coleção "_Map_".

## MAP - Definição E Características
MAP é um tipo de coleção estruturada em volta do conceito de key/value (chave/valor). Assim, com um MAP é possível obter um valor através de uma chave, onde tanto a chave quanto o valor são objetos. Como evidenciado no diagrama UML acima, a interface Map possui quatro principais implementações: Hashtable, HashMap, LinkedHashMap e TreeMap.
- HashTable é uma classe similar a Vector, no sentido que ela é thread-safe (sincronizada). Ademais, Hashtable não permite o uso de null para o mapeamento.
- HashMap é uma classe não ordenada e não classificada. Diferentemente do Hashtable, o HashMap permite uma chave"_null_" e diversoes valores "_null_".
- LinkedHashMap é similar ao HashMap, mas possui ordem de inserção. Apesar de ser mais lento para inserção e remoção de elementos, o LinkedHashMap é melhor para iteração.
- TreeMap é uma classe ordenada que permite customização através das interdaces _Comparable_ e _Comparator_.

## Principais Métodos
- isEmpty(): returna "_true_" se o mapa não contém elementos;
- put(K k, V v): associa a chave k com o valor v;
- get(Object k): retorna o objeto mapeado a chave k, ou "_null_" se não houver nenhum objeto mapeado;
- size(): retornar a quantidade de mapeamentos num mapa;
- values(): retorna um objeto "_Collection_" com os valores contidos no mapa (alterações no mapa são refletidas no objeto Collection e vice-versa);
- replace(K k, V v): susbstitui o valor associado a chave k pelo novo valor  v;
- clear(): remove todos os mapeamentos do mapa;
- keySet(): retorna um objeto "_Set_" com as chaves do mapa (alterações no mapa são refletidas no objeto Set e vice-versa);
- forEach(BiConsumer<? super K,​? super V> ação): realiza a dada ação para cada elemento do mapa;

## Exemplo De Programa

Programa De Cadastro Simples Com HashMap:

![Main](https://raw.githubusercontent.com/Henrique194/DevJava/main/Collections/Imagens/Main.png)

![Action](https://raw.githubusercontent.com/Henrique194/DevJava/main/Collections/Imagens/Action.png)

![Cadastro](https://raw.githubusercontent.com/Henrique194/DevJava/main/Collections/Imagens/Cadastro.png)

## Comparable E Comparator
A Interface Comparable defini a "ordem natural" que os objetos de uma classe devem ser organizados. Se fosse necessário ordenar os objetos de uma classe de outra maneira, poderia ser criado uma classe que implementa a interface Comparator e implementar o método compare(); As classes Integer e String já implementam Comparable, por isso um objeto TreeMap ordena um Inetegar por ordem ascentende e String por ordem alfabética.

No exemplo acima, foi usado o HashMap por ser a implementação mais rápida de um Map no quesito de inserção e remoção. Entretanto, se fosse necessário uma grande quantidade de iteração dos elementos do mapa, é recomendado usar outra implementação, como o LinkeHashMap, que mantêm os elementos oeganizados de acordo com a ordem de inserção. Já se o critério for organização, poderia se usar um TreeMap. A implementação do código ficaria assim:

![Cadastro](https://raw.githubusercontent.com/Henrique194/DevJava/main/Collections/Imagens/CompMain.png)
![Cadastro](https://raw.githubusercontent.com/Henrique194/DevJava/main/Collections/Imagens/Clientes.png)
![Cadastro](https://raw.githubusercontent.com/Henrique194/DevJava/main/Collections/Imagens/QuantidadeComparator.png)

[1]: <https://docs.oracle.com/javase/tutorial/collections/intro/index.html>
[2]: <https://www.amazon.com.br/Certifica%C3%A7%C3%A3o-Para-Programador-Java-Estudos/dp/8576083035>
[3]: <https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/HashMap.html>
[4]: <https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/Comparable.html>
[5]: <https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Comparator.html>
