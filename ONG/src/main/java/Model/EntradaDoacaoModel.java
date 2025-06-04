/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class EntradaDoacaoModel {
    private int idEntradaDoacao;
    private String fornecedor;
    private String tipo;
    private int quantidade;
    private String duracao;

    public EntradaDoacaoModel() {
    }

    public EntradaDoacaoModel(int idEntradaDoacao, String fornecedor, String tipo, int quantidade, String duracao) {
        this.idEntradaDoacao = idEntradaDoacao;
        this.fornecedor = fornecedor;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.duracao = duracao;
    }

    public int getIdEntradaDoacao() {
        return idEntradaDoacao;
    }

    public void setIdEntradaDoacao(int idEntradaDoacao) {
        this.idEntradaDoacao = idEntradaDoacao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
