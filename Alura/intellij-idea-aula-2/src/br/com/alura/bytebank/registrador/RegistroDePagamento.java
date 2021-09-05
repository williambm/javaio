package br.com.alura.bytebank.registrador;

import br.com.alura.bytebank.model.Pagamento;
import br.com.alura.bytebank.model.Tipo;

import java.util.ArrayList;
import java.util.List;

public class RegistroDePagamento {

    private final static List<Pagamento> PAGAMENTOS = new ArrayList<>();

    public void registra(List<Pagamento> pagamentos) {
        for (int i = 0; i < pagamentos.size(); i++) {
            Pagamento pagamento = pagamentos.get(i);

            if (verificaTipo(pagamento)) {
                salva(pagamento);

            } else {
                System.out.println("Erro: tipo não reconhecido registro não foi salvo.");


            }
        }
        exibeEfetuados();
    }

    private void exibeEfetuados() {
        if (!PAGAMENTOS.isEmpty()) {
            System.out.println("Todos os pagamentos");
            for (int i = 0; i < PAGAMENTOS.size(); i++) {
                System.out.println(PAGAMENTOS.get(i));
            }
        } else {
            System.out.println("Não temos pagamentos");
        }
    }

    private boolean verificaTipo(Pagamento pagamento) {
        if (pagamento.getTipo().equals(Tipo.CREDITO)) {
            pagamento.setValor(pagamento.getValor() * 1.02);
            return true;
        }
        if (pagamento.getTipo().equals(Tipo.DEBITO)) {
            pagamento.setValor(pagamento.getValor() * 1.001);
            return true;
        }
        if (pagamento.getTipo().equals(Tipo.DINHEIRO)) {
            return true;
        }
        return false;
    }

    private void salva(Pagamento pagamento) {
        PAGAMENTOS.add(pagamento);
        System.out.println("Pagamento realizado " + pagamento);
    }

}
