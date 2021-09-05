package br.com.alura.bytebank.io.teste;

import java.io.*;

public class TesteLeitura {
    public static void main(String[] args) throws IOException {

        /**
         * Classe para ler um arquivo e gerar um stream dele.
         * Não é boa para fazer a leitura dos caracteres da classe,
         * pois só tem métodos para retornar binário
         */
        FileInputStream fileInputStream = new FileInputStream("entrada.txt");

        /**
         * Essa classe transforma os binários em Arrays de caracteres, agora temos arrays legíveis.
         * Mas trabalhar com arrays não é algo fácil e não temos aqui uma forma dinámica de ler os dados.
         * Dessa forma é necessário um BUffer para poder operar melhor a leitura
         */
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        /**
         * Criamos uma bufferização que espera os arrays serem preenchidos com a leitura e faz esse processo de forma
         * mais amigável para que possamos ler um arquivo.
         */
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String resultado = bufferedReader.readLine();

        while(resultado!=null) {
            System.out.println(resultado);
            resultado = bufferedReader.readLine();
        }
        //Por se tratar de um stream e buffer é bom encerrarmos o fluxo.
        bufferedReader.close();
    }
}
