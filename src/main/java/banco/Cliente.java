/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author rafaelamoreira
 */
public class Cliente {
    private final int id;
    private String nome;
    private int idade;
    private String email;
    private boolean ativo;

    public Cliente(int id, String nome, int idade, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.ativo = true;
    }

    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "=========================\n" 
                +"Id: " + this.id + "\n"
                + "Nome: " + this.nome + "\n"
                + "Email: " + this.email + "\n"
                + "Idade: " + this.idade + "\n"
                + "Status: " + (ativo?"Ativo":"Inativo") + "\n"
                + "=========================";
    }
    
}
