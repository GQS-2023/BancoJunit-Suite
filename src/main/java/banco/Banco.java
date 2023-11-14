/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rafaelamoreira
 */
public class Banco {

    public static void iniciar() {
        List<ContaCorrente> contas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        GerenciadoraClientes gc = new GerenciadoraClientes(clientes);
        GerenciadoraContas gcc = new GerenciadoraContas(contas);
        Scanner input = new Scanner(System.in);
        int opcao;

        while (true) {
            exibeMenu();
            opcao = input.nextInt();

            switch (opcao) {
                case 1: // cadastrar cliente
                    Cliente c = inputDataCliente(input, gc, clientes);
                    if (c != null) {
                        gc.adicionaCliente(c);
                        System.out.println("Cliente cadastrado com sucesso!");
                    }
                    break;
                case 2: // listar clientes
                    if (!clientes.isEmpty()) {
                        gc.listarClientes(clientes);
                    } else {
                        System.out.println("Nenhum cliente inserido!");
                    }
                    break;
                case 3: // Consultar cliente
                    System.out.print("Digite o ID do cliente: ");
                    int idCliente = input.nextInt();
                    Cliente cliente = gc.pesquisaCliente(idCliente);
                    if (cliente != null) {
                        System.out.println(cliente.toString());

                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;
                case 4: // Criar conta
                    ContaCorrente ct = inputDataConta(input, gc, contas);
                    if (ct != null) {
                        gcc.adicionaConta(ct);
                        System.out.println("Conta cadastrada com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;
                case 5: // Consultar conta
                    System.out.print("Digite o ID da conta: ");
                    int idConta = input.nextInt();
                    ContaCorrente conta = gcc.pesquisaConta(idConta);
                    if (conta != null) {
                        System.out.println(conta.toString());

                        System.out.println("Conta desativada com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 6: // Ativar conta
                    System.out.print("Digite o ID da conta: ");
                    idConta = input.nextInt();
                    conta = gcc.pesquisaConta(idConta);

                    if (conta != null) {
                        conta.setAtiva(true);
                        System.out.println("Conta ativada com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada!");
                    }

                    break;
                case 7: // Desativar conta
                    System.out.print("Digite o ID da conta: ");
                    idConta = input.nextInt();
                    conta = gcc.pesquisaConta(idConta);

                    if (conta != null) {
                        conta.setAtiva(false);
                        System.out.println("Conta desativada com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada!");
                    }

                    break;
                case 8: // depositar
                    System.out.print("Digite o ID da conta: ");
                    idConta = input.nextInt();
                    conta = gcc.pesquisaConta(idConta);
                    System.out.print("Quanto deseja depositar? ");
                    double valor = input.nextDouble();
                    if (conta != null) {
                        conta.depositar(valor);
                        System.out.println("Novo saldo: R$ " + conta.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 9: // sacar
                    System.out.print("Digite o ID da conta: ");
                    idConta = input.nextInt();
                    conta = gcc.pesquisaConta(idConta);
                    System.out.print("Quanto deseja sacar? ");
                    valor = input.nextDouble();
                    if (conta != null) {
                        conta.sacar(valor);
                        System.out.println("Novo saldo: R$ " + conta.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 10:// transferir valor
                    System.out.print("Digite o ID da conta origem: ");
                    int idConta1 = input.nextInt();
                    ContaCorrente conta1 = gcc.pesquisaConta(idConta1);
                    System.out.print("Digite o ID da conta destino: ");
                    int idConta2 = input.nextInt();
                    ContaCorrente conta2 = gcc.pesquisaConta(idConta2);
                    System.out.print("Quanto deseja transferir? ");
                    valor = input.nextDouble();
                    if (conta1 != null && conta2 != null) {
                        gcc.transfereValor(idConta1, valor, idConta2);
                    }
                    System.out.println("Novo saldo: R$ " + conta1.getSaldo());
                    break;
                case 11: // sair
                    System.out.println("ATÉ LOGO!!!!");
                    System.exit(0);
                default:
                    System.out.println("OPCAO INVALIDA!!!!");
            }
        }
    }

    private static void exibeMenu() {
        System.out.println("\n ============================ \n");
        System.out.println("O que você deseja fazer? \n");
        System.out.println("1) Cadastrar cliente");
        System.out.println("2) Listar clientes");
        System.out.println("3) Consultar por um cliente");
        System.out.println("4) Criar conta");
        System.out.println("5) Consultar por uma conta corrente");
        System.out.println("6) Ativar conta");
        System.out.println("7) Desativar conta");
        System.out.println("8) Depositar");
        System.out.println("9) Sacar");
        System.out.println("10) Transferir");
        System.out.println("11) Sair");
        System.out.println();
    }

    private static Cliente inputDataCliente(Scanner scan, GerenciadoraClientes gc, List clientes) {
        int id = clientes.size() + 1;
        Cliente c = null;
        System.out.println("Informe o nome do cliente: ");
        String nome = scan.nextLine();
        limparBuffer(scan);
        System.out.println("Informe a idade do cliente: ");
        int idade = scan.nextInt();
        if (gc.validaIdade(idade)) {
            System.out.println("Informe o email do cliente: ");
            String email = scan.nextLine();
            c = new Cliente(id, nome, idade, email);

        } else {
            System.out.println("A idade do cliente precisa estar entre 18 e 65 anos.");
        }

        return c;
    }

    private static ContaCorrente inputDataConta(Scanner scan, GerenciadoraClientes gc, List contas) {
        int id = contas.size() + 1;
        ContaCorrente c = null;
        System.out.println("Informe o ID do cliente: ");
        int idCliente = scan.nextInt();
        Cliente cliente = gc.pesquisaCliente(idCliente);
        if (cliente != null) {
            c = new ContaCorrente(id, idCliente);
        }
        return c;
    }

    private static void limparBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
