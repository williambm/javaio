package br.com.alura.bytebank.io.teste;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Realiza a leitura de um relatório e extrai dele apenas o título e o valor de cada coisa
 * <p>
 * Padrão do arquivo:
 * Título: xxx
 * Valor: R$11,11
 */
public class IOArquivo {
    public static void main(String[] args) throws IOException {

        //Leitura de um arquivo
        InputStream fileInputStream = new FileInputStream("entrada.txt");
        Reader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bReader = new BufferedReader(inputStreamReader);

        //Escrita de um arquivo
        FileOutputStream fileOutputStream = new FileOutputStream("saida.txt");
        Writer outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bWriter = new BufferedWriter(outputStreamWriter);

        /**
         * Implementação da lógica, lemos o arquivo e se achar título guardamos a informação.
         * Se achar o valor concatena com o título.
         */
        String leitorLinha = bReader.readLine();

        //Jogo em um string builder para depois formatar apenas o que desejo.
        StringBuilder enriqueceString = new StringBuilder();

        /**
         * Leio o arquivo e pego apenas o que colocamos na lógica que é Título e Valor
         */
        while (leitorLinha != null) {
            if (leitorLinha.contains("Título") || leitorLinha.contains("Valor")) {
                enriqueceString.append(leitorLinha);
                enriqueceString.append(" ");
            }
            leitorLinha = bReader.readLine();
        }

        //Se não for nulo enriqueço a informação
        if (enriqueceString != null) {
            System.out.println(enriqueceString.toString());
            bWriter.write("Relatório de gastos");
            bWriter.newLine();
            bWriter.write("________________________");
            bWriter.newLine();

            String posLeituraArquivo = enriqueceString.toString();

            /* Aqui fiz o split com apenas o espaço em branco, mas se eu soubesse regex seria ótimo
            para ja pegar duas palavras de uma vez */
            String[] splitString = posLeituraArquivo.split(" ");

            /**
             * Pattern
             * ^ = começo de linha
             * $ = fim de linha
             * \w = word
             * \d = númerico
             * [0-9] = conjunto de caracteres
             * [A-Z] = conjunto de alfanumérico maiusc ou minusc
             * [A-Z0-9] = conjunto de alfanumérico maiusc ou minusc e numéricos
             *  . = qualquer caractere
             *  .* = qualquer caractere de 0 a n vezes (contador)
             *  .+ = qualquer caracter de 1 a n vezes (contador)
             *  :? = é o caractere ":" presente ou não de 0 a 1 vez (contador)
             *
             *  \d{4} = quatro vezes um dígito
             *  \d{2,4} = quatro vezes um dígito de 2 a 4 vezes um digito
             *
             *  agrupamentos
             *  (título):? (.*) = título é o grupo 1 e qualquer grupo de caracterer apresentado n vezes até o fim da linha é o grupo 2
             *  ^(título):? (.*)$ = título é o grupo 1 e qualquer grupo de caracterer apresentado n vezes até o fim da linha é o grupo 2
             *
             *
             */
            Pattern pattern = Pattern.compile("^(título):? (.*)$");
            Matcher matcher = pattern.matcher("título: abóbora ");

            matcher.groupCount();


            //Tive que fazer um for clássico por causa da falta do regex
            for (int i = 0; i < splitString.length; i++) {
                bWriter.write(splitString[i]+" "+splitString[i+1]);
                i++;
                bWriter.newLine();
            }

            //Encerra o fluxo de escrita, é bom colocar para garantir que teremos o EOF (End Of File)
            bWriter.close();


        }

    }
}
