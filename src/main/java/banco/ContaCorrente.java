/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author rafaelamoreira
 */
public class ContaCorrente {

    private final int id;
    private double saldo;
    private boolean ativa;
    private final int idCliente;

    public ContaCorrente(int id, int idCliente) {
        this.id = id;
        this.saldo = 0;
        this.ativa = true;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        boolean sacado = false;
        if (valor <= saldo) {
            this.saldo -= valor;
            sacado = true;
        }
        return sacado;
    }

    @Override
    public String toString() {
        return "=========================\n"
                + "Id: " + this.id + "\n"
                + "Saldo: " + this.saldo + "\n"
                + "Status: " + (ativa ? "Ativa" : "Inativa") + "\n"
                + "Cliente: " + this.idCliente + "\n"
                + "=========================";
    }

}
