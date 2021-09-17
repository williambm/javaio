package br.com.alura.bytebank.stream.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

        objA a1 = new objA("das-dsa-das", "PERCENTAGE", new BigDecimal(250.23));
        objA a2 = new objA("cxz-cxz-cxz", "PERCENTAGE", new BigDecimal(150.23));

        List<objA> objAS = new ArrayList<>();
        objAS.add(a1);
        objAS.add(a2);

        objAS.stream().forEach(item -> System.out.println(item));

        List<cashoutJSON> cashoutJSONS = objAS.stream().map(item -> new cashoutJSON(item.codigo
                , item.regraDeDivisao
                , item.valorTotal)).collect(Collectors.toList());

        cashoutJSONS.stream().forEach(item -> System.out.println(item));

    }

    static class cashoutJSON {
        private String code;

        private String divisionRule;

        private BigDecimal appliedAmount;

        public cashoutJSON(String code, String divisionRule, BigDecimal appliedAmount) {
            this.code = code;
            this.divisionRule = divisionRule;
            this.appliedAmount = appliedAmount;
        }

        @Override
        public String toString() {
            return "cashoutJSON{" +
                    "code='" + code + '\'' +
                    ", divisionRule='" + divisionRule + '\'' +
                    ", appliedAmount=" + appliedAmount +
                    '}';
        }
    }

    static class objA {
        String codigo;

        String regraDeDivisao;

        BigDecimal valorTotal;

        public objA(String codigo, String regraDeDivisao, BigDecimal valorTotal) {
            this.codigo = codigo;
            this.regraDeDivisao = regraDeDivisao;
            this.valorTotal = valorTotal;
        }

        @Override
        public String toString() {
            return "objA{" +
                    "code='" + codigo + '\'' +
                    ", divisionRule='" + regraDeDivisao + '\'' +
                    ", appliedAmount=" + valorTotal +
                    '}';
        }
    }
}
