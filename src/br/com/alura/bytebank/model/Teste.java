package br.com.alura.bytebank.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

        Conta c1 = new Conta(01, false, 100.00,     "William");
        Conta c2 = new Conta(02, true,  250.00,     "Bianca");
        Conta c3 = new Conta(03, true,  50.00,      "Ed");
        Conta c4 = new Conta(04, false, 20.00,      "Cris");
        Conta c5 = new Conta(05, true,  2150.00,    "Mari");

        List<Conta> contas = new ArrayList<>();
        contas.add(c1);
        contas.add(c2);
        contas.add(c3);
        contas.add(c4);
        contas.add(c5);

        //Imprime lista não ordenada
        for (Conta conta : contas) {
            System.out.println(conta);
        }

        comparaContasBySaldo comparaContasBySaldo = new comparaContasBySaldo();
        comparaContasByNome comparaContasByNome = new comparaContasByNome();

        //Ordena a Lista pelo saldo
        contas.sort(comparaContasBySaldo);
        System.out.println("_____________");

        //Imprime lista ordenada
        for (Conta conta : contas) {
            System.out.println(conta);
        }

        //Ordena a Lista pelo nome
        contas.sort(comparaContasByNome);
        System.out.println("_____________");

        for (Conta conta : contas) {
            System.out.println(conta);
        }

        //reverte a ordenação da lista
        Collections.reverse(contas);

        System.out.println("_____________");
        for (Conta conta : contas) {
            System.out.println(conta);
        }

        //embaralha a ordenação da lista
        Collections.shuffle(contas);

        System.out.println("_____________");
        for (Conta conta : contas) {
            System.out.println(conta);
        }


    }

    /**
     * Ordena listas com base no saldo
     */
    public static class comparaContasBySaldo implements Comparator<Conta> {

        @Override
        public int compare(Conta conta1, Conta conta2) {

            return conta1.valor > conta2.valor ? 1 : -1;
        }
    }

    /**
     * Ordena listas com base na ordem alfabética do nome do correntista
     */
    public static class comparaContasByNome implements Comparator<Conta> {

        @Override
        public int compare(Conta conta1, Conta conta2) {
            String c1Nome = conta1.nomeCorrentista;
            String c2Nome = conta2.nomeCorrentista;

            return c1Nome.compareTo(c2Nome);
        }
    }

}
