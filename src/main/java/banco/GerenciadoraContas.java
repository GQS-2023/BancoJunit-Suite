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
public class GerenciadoraContas {

    private List<ContaCorrente> contas;

    public GerenciadoraContas(List<ContaCorrente> contas) {
        this.contas = contas;
    }

    public List<ContaCorrente> getContas() {
        return contas;
    }

    public ContaCorrente pesquisaConta(int idConta) {
        for (ContaCorrente contaCorrente : contas) {
            if (contaCorrente.getId() == idConta) {
                return contaCorrente;
            }
        }
        return null;
    }

    public void adicionaConta(ContaCorrente novaConta) {
        this.contas.add(novaConta);
    }

    public boolean removeConta(int idConta) {

        boolean contaRemovida = false;

        for (ContaCorrente conta : contas) {
            if (conta.getId() == idConta) {
                contas.remove(conta);
                break;
            }
        }
        return contaRemovida;
    }

    public boolean ativaConta(int idConta) {

        boolean contaAtiva = false;

        for (ContaCorrente conta : contas) {
            if (conta.getId() == idConta) {
                if (conta.isAtiva()) {
                    contaAtiva = true;
                    break;
                }
            }
        }
        return contaAtiva;
    }

    public boolean transfereValor(int idContaOrigem, double valor, int idContaDestino) {

        boolean sucesso = false;

        ContaCorrente contaOrigem = pesquisaConta(idContaOrigem);
        ContaCorrente contaDestino = pesquisaConta(idContaDestino);

        if (contaOrigem.getSaldo() >= valor) {
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);    
            sucesso = true;
        }
        return sucesso;
    }
    public void limpar() {
        contas.clear();
    }
}
