package org.example;

public class ArCondicionado {

    private String ambiente;
    private String estado;

    public ArCondicionado(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getEstado() {
        return estado;
    }

    public void ligar() {
        this.estado = "Ar condicionado ligado";
    }

    public void desligar() {
        this.estado = "Ar condicionado desligado";
    }
}