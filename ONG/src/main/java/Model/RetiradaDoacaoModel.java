/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ALUNO
 */
public class RetiradaDoacaoModel {
    private int idRetiradaDoacaoArrecadacao;
    private String destinatario;
    private String tipo;
    private int quantidade;
    private String duracao;
    private int chamado;

    public RetiradaDoacaoModel() {
    }

    public RetiradaDoacaoModel(int idRetiradaDoacaoArrecadacao, String destinatario, String tipo, int quantidade, String duracao, int chamado) {
        this.idRetiradaDoacaoArrecadacao = idRetiradaDoacaoArrecadacao;
        this.destinatario = destinatario;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.duracao = duracao;
        this.chamado = chamado;
    }

    public int getIdRetiradaDoacaoArrecadacao() {
        return idRetiradaDoacaoArrecadacao;
    }

    public void setIdRetiradaDoacaoArrecadacao(int idRetiradaDoacaoArrecadacao) {
        this.idRetiradaDoacaoArrecadacao = idRetiradaDoacaoArrecadacao;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
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

    public int getChamado() {
        return chamado;
    }

    public void setChamado(int chamado) {
        this.chamado = chamado;
    }
    
    
    
    
}
