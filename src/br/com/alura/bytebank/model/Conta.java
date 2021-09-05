package br.com.alura.bytebank.model;

public class Conta {

    int id;
    boolean status;
    double valor;
    String nomeCorrentista;

    public Conta(int id, boolean status, double valor, String nomeCorrentista) {
        this.id = id;
        this.status = status;
        this.valor = valor;
        this.nomeCorrentista=nomeCorrentista;
    }

    public void deposita (Conta conta, double valor){
        conta.valor+=valor;
    }

    public void saca (Conta conta, double valor){
        conta.valor-=valor;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", status=" + status +
                ", valor=" + valor +
                ", nomeCorrentista='" + nomeCorrentista + '\'' +
                '}';
    }
}
