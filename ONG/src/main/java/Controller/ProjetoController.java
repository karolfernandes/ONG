/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ProjetoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ALUNO
 */
public class ProjetoController {
 public boolean cadastrarProjeto(ProjetoModel f){
     String sql = "INSERT INTO Projeto(nome, horario, data, duracao)"
             +"VALUES (?, ?, ?, ?)";
     try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){
             
             ps.setString(1, f.getNome());
             ps.setString(2, f.getHorario());
             ps.setString(3, f.getDataProjeto());
             ps.setString(4, f.getDuracao());
             
             int rowsAffeted = ps.executeUpdate();
             return rowsAffeted >0;
            
 } catch (SQLException e) {
     e.printStackTrace();
     return false;
 } 
}}
