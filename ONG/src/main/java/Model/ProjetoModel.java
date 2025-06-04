/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class ProjetoModel {
    private int idProjeto;
    private String nome;
    private String horario;
    private String dataProjeto;
    private String duracao;
    private int chamadoIdChamado;

    public ProjetoModel() {
    }

    public ProjetoModel(int idProjeto, String nome, String horario, String dataProjeto, String duracao, int chamadoIdChamado) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.horario = horario;
        this.dataProjeto = dataProjeto;
        this.duracao = duracao;
        this.chamadoIdChamado = chamadoIdChamado;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDataProjeto() {
        return dataProjeto;
    }

    public void setDataProjeto(String dataProjeto) {
        this.dataProjeto = dataProjeto;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getChamadoIdChamado() {
        return chamadoIdChamado;
    }

    public void setChamadoIdChamado(int chamadoIdChamado) {
        this.chamadoIdChamado = chamadoIdChamado;
    }
}
