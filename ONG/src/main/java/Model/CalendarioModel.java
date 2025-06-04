/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class CalendarioModel {
    private int idCalendario;
    private String dataCalendario;
    private String horario;
    private String localCalendario;
    private String participantes;
    private String descricao;
    private String anexos;

    public CalendarioModel() {
    }

    public CalendarioModel(int idCalendario, String dataCalendario, String horario, String localCalendario, String participantes, String descricao, String anexos) {
        this.idCalendario = idCalendario;
        this.dataCalendario = dataCalendario;
        this.horario = horario;
        this.localCalendario = localCalendario;
        this.participantes = participantes;
        this.descricao = descricao;
        this.anexos = anexos;
    }

    public int getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(int idCalendario) {
        this.idCalendario = idCalendario;
    }

    public String getDataCalendario() {
        return dataCalendario;
    }

    public void setDataCalendario(String dataCalendario) {
        this.dataCalendario = dataCalendario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocalCalendario() {
        return localCalendario;
    }

    public void setLocalCalendario(String localCalendario) {
        this.localCalendario = localCalendario;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }
}
