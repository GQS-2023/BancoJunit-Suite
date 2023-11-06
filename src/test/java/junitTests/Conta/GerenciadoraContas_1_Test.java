package junitTests.Conta;


import banco.ContaCorrente;
import banco.GerenciadoraContas;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rafaelamoreira
 */
@Tag("dev")
public class GerenciadoraContas_1_Test {

    List<ContaCorrente> contas;
    GerenciadoraContas gcc;

    @BeforeEach
    public void iniciar() {
        contas = new ArrayList<>();
        ContaCorrente c1 = new ContaCorrente(1, 1);
        ContaCorrente c2 = new ContaCorrente(2, 1);
        contas.add(c1);
        contas.add(c2);

        gcc = new GerenciadoraContas(contas);
    }

    @AfterEach
    public void finalizar() {
        gcc.limpar();
    }

    @Test
    public void testTransfereValor_01() {
        ContaCorrente c1 = contas.get(0);
        c1.depositar(200);
        ContaCorrente c2 = contas.get(1);

        boolean sucesso = gcc.transfereValor(c1.getId(), 100, c2.getId());

        assertTrue(sucesso);
        assertThat(c1.getSaldo(), is(100.0));
        assertThat(c2.getSaldo(), is(100.0));
    }
    
    @Test
    public void testTransfereValor_02() {
        ContaCorrente c1 = contas.get(0);
        c1.depositar(100);
        ContaCorrente c2 = contas.get(1);

        boolean sucesso = gcc.transfereValor(c1.getId(), 100, c2.getId());

        assertTrue(sucesso);
        assertThat(c1.getSaldo(), is(0.0));
        assertThat(c2.getSaldo(), is(100.0));
    }
    
}
