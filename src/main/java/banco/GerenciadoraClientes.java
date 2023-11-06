/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.List;

/**
 *
 * @author rafaelamoreira
 */
public class GerenciadoraClientes {

    private List<Cliente> clientes;

    public GerenciadoraClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente pesquisaCliente(int idCliente) {
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                return c;
            }

        }
        return null;
    }

    public void adicionaCliente(Cliente novoCliente) {
        clientes.add(novoCliente);
    }

    public boolean ativaCliente(int idCliente) {
        boolean clienteAtivo = false;
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                if (c.isAtivo()) {
                    clienteAtivo = true;
                    break;
                }
            }
        }
        return clienteAtivo;
    }

    public boolean validaIdade(int idade) {
        boolean validado = true;
        if (idade < 18 || idade > 65) {
            validado = false;
        }

        return validado;
    }

    public void listarClientes(List cliente) {
        System.out.println("---------------------------");
        System.out.println("Clientes:");
        System.out.println("---------------------------");

        for (Cliente c : clientes) {
            System.out.println(c.toString());
            System.out.println("---------------------------");
        }
    }

    public void limpar() {
        clientes.clear();
    }

}
