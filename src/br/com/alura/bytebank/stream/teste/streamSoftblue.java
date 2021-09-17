package br.com.alura.bytebank.stream.teste;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamSoftblue {

    public static void main(String[] args) {

        Integer[] numeros = {10, 2, 3, 20, 8, 6};

        //queremos apenas números de 2 a 8 e queremos que sejam elevados ao quadrado
       /* List<Integer> filtrados = Stream.of(numeros)
                .sorted()                           // ordenamos
                .filter(num -> num >= 2 & num <= 8) // filtro de 2 a 8
                .map(num -> num * num)              // mapeio cada elemento e o faço ao quadrado
                .collect(Collectors.toList());      // retorno a saída como uma lista
        */
        /**
         * A partir do Java 8 as collections de list e set já possuem o método stream aplicado
         * só o array que não, mas há um método statico que podemos usar tal como o Arrays.stream() ou o Stream.of()
         */

        List<Integer> filtrados = Arrays.stream(numeros)
                .parallel()
                .sorted()
                .filter(num -> num >= 2 & num <= 8) // filtro de 2 a 8
                .map(num -> num * num)              // mapeio cada elemento e o faço ao quadrado
                .collect(Collectors.toList());      // retorno a saída como uma lista

        filtrados.stream().forEach(result -> System.out.println(result));

    }
}
