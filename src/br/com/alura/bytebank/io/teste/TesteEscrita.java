package br.com.alura.bytebank.io.teste;

import java.io.*;

public class TesteEscrita {
    public static void main(String[] args) throws IOException {


        OutputStream fileOutputStream = new FileOutputStream("wbm.txt");

        Writer outputStreamWriter = new OutputStreamWriter(fileOutputStream);

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        //Escrevendo um texto
        bufferedWriter.write("O rato roeu a roupa do rei de roma");
        /**
         * Cria uma nova linha, pode ser usada para quebrar linha mas ai temos que colocar duas vezes esse comando.
         * Como usamos só uma vez apenas indica que o próximo writer já começa na linha de baixo (nova linha)
         */
        bufferedWriter.newLine();
        bufferedWriter.write("Escrito por wbm");

        bufferedWriter.close();
    }
}
