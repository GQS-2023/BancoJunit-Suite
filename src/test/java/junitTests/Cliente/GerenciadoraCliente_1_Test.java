package junitTests.Cliente;


import banco.Cliente;
import banco.GerenciadoraClientes;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class GerenciadoraCliente_1_Test {

    @Test
    public void testPesquisaCliente() {

        // criando cliente
        Cliente cliente = new Cliente(1, "Maria Lopes", 31, "marialopes@gmail.com");

        // inserindo o cliente criado na lista de clientes do banco
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);

        GerenciadoraClientes gc = new GerenciadoraClientes(clientes);

        Cliente cliente1 = gc.pesquisaCliente(1);

        assertEquals(cliente.getId(), cliente1.getId());
        assertEquals(cliente.getEmail(), cliente1.getEmail());

    }

}
