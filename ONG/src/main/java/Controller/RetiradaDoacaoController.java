/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.RetiradaDoacaoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ALUNO
 */
public class RetiradaDoacaoController {
 public boolean cadastrarRetiradaDoacao(RetiradaDoacaoModel f){
     String sql = "INSERT INTO RetiradaDoacao(tipo, quantidade)"
             +"VALUES (?, ?)";
     try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
         
             ps.setString(1, f.getTipo());
             ps.setInt(2, f.getQuantidade());
             
             int rowsAffected = ps.executeUpdate();
             return rowsAffected >0;
 } catch (SQLException e){
     e.printStackTrace();
     return false;
 }  
}}
