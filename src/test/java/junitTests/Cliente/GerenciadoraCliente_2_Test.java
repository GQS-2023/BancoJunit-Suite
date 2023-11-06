package junitTests.Cliente;


import banco.Cliente;
import banco.GerenciadoraClientes;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
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
 * 
 */
@Tag("dev")
public class GerenciadoraCliente_2_Test {

    List<Cliente> clientes;
    GerenciadoraClientes gc;

    @BeforeEach
    public void iniciar() {
        clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente(1, "Maria Lopes", 31, "marialopes@gmail.com");
        Cliente cliente2 = new Cliente(2, "Marlon Silva", 28, "marlonsilva@gmail.com");
        clientes.add(cliente1);
        clientes.add(cliente2);

        gc = new GerenciadoraClientes(clientes);
    }

    @AfterEach
    public void finalizar() {
        gc.limpar();
    }

    @Test
    public void testPesquisaCliente() {
        Cliente cliente = gc.pesquisaCliente(1);
        assertEquals(cliente.getId(), 1);
        assertEquals(cliente.getEmail(), "marialopes@gmail.com");
    }

    @Test
    public void testPesquisaClienteInexistente() {
        Cliente cliente = gc.pesquisaCliente(5);
        assertNull(cliente);
    }

    @Test
    public void testClienteIdadePermitida_01() {
        Cliente cliente = new Cliente(1, "Ana Oliveira", 60, "anaoliveira@gmail.com");
        boolean idadeValida = gc.validaIdade(cliente.getIdade());
        assertTrue(idadeValida);
    }

    @Test
    
    public void testClienteIdadePermitida_02() {
        Cliente cliente = new Cliente(1, "Ana Oliveira", 70, "anaoliveira@gmail.com");
        boolean idadeValida = gc.validaIdade(cliente.getIdade());
        if (idadeValida == false) {
            fail("A idade do cliente precisa estar entre 18 e 65 anos.");
        }
    }


}
