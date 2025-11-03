package src.entity;

import java.time.LocalDateTime;

public class Transaction {
    private String tipo;
    private double valor;
    private LocalDateTime data;

    public Transaction() {}

    public Transaction(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
