/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ChamadoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ALUNO
 */
public class ChamadoController {
 public boolean cadastrarChamado(ChamadoModel f){
     String sql = "INSERT INTO Chamado(tipo, problema, resolvido)"
             +"VALUES (?, ?, ?)";
     try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){
         ps.setString(1, f.getTipo());
         ps.setString(2, f.getProblema());
         ps.setString(3, f.getResolvido());
         
         int rowsAffected = ps.executeUpdate();
         return rowsAffected > 0;
         
     }catch (SQLException e){
         e.printStackTrace();
         return false;
     }
 }   
}
