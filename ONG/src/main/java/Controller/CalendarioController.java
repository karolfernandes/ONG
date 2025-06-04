/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CalendarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ALUNO
 */
public class CalendarioController {
 public boolean cadastrsrCalendario(CalendarioModel f) {
     String sql = "INSERT INTO Calendario(data, horario, local, participantes, descricao, anexos)"
      +"VALUES (?, ?, ?, ?, ?, ?)";
     try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
         ps.setString(1, f.getDataCalendario());
         ps.setString(2, f.getHorario());
         ps.setString(3, f.getLocalCalendario());
         ps.setString(4, f.getParticipantes());
         ps.setString(5, f.getDescricao());
         ps.setString(6, f.getAnexos());
         
         int rowsAffected = ps.executeUpdate();
         return rowsAffected >0;
     }catch (SQLException e){
         e.printStackTrace();
         return false;
     }
 }  
}
