/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class ChamadoModel {

    private int idChamado;
    private String tipo;
    private String problema;
    private String resolvido;
    private int colaboradorIdVoluntario;
    private String nomeChamado;

    private String nomeColaborador;

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public ChamadoModel() {
    }

    public ChamadoModel(int idChamado, String tipo, String problema, String resolvido, int colaboradorIdVoluntario) {
        this.idChamado = idChamado;
        this.tipo = tipo;
        this.problema = problema;
        this.resolvido = resolvido;
        this.colaboradorIdVoluntario = colaboradorIdVoluntario;
    }

    public int getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(int idChamado) {
        this.idChamado = idChamado;
    }

    public String getNomeChamado() {
        return nomeChamado;
    }

    public void setNomeChamado(String nomeChamado) {
        this.nomeChamado = nomeChamado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getResolvido() {
        return resolvido;
    }

    public void setResolvido(String resolvido) {
        this.resolvido = resolvido;
    }

    public int getColaboradorIdVoluntario() {
        return colaboradorIdVoluntario;
    }

    public void setColaboradorIdVoluntario(int colaboradorIdVoluntario) {
        this.colaboradorIdVoluntario = colaboradorIdVoluntario;
    }
}
