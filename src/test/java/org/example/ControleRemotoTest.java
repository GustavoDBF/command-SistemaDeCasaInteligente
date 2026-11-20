package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControleRemotoTest {

    ControleRemoto controle;
    ArCondicionado arCondicionado;

    @BeforeEach
    void setUp() {
        controle = new ControleRemoto();
        arCondicionado = new ArCondicionado("Sala de Estar");
    }

    @Test
    void deveLigarArCondicionado() {
        Comando ligarAr = new LigarArCondicionadoComando(arCondicionado);
        controle.executarComando(ligarAr);

        assertEquals("Ar condicionado ligado", arCondicionado.getEstado());
    }

    @Test
    void deveDesligarArCondicionado() {
        Comando desligarAr = new DesligarArCondicionadoComando(arCondicionado);
        controle.executarComando(desligarAr);

        assertEquals("Ar condicionado desligado", arCondicionado.getEstado());
    }

    @Test
    void deveCancelarDesligamentoDoArCondicionado() {
        Comando ligarAr = new LigarArCondicionadoComando(arCondicionado);
        Comando desligarAr = new DesligarArCondicionadoComando(arCondicionado);

        controle.executarComando(ligarAr);
        controle.executarComando(desligarAr);

        controle.cancelarUltimoComando();

        assertEquals("Ar condicionado ligado", arCondicionado.getEstado());
    }
}