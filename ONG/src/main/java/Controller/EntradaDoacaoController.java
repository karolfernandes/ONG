/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.EntradaDoacaoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ALUNO
 */
public class EntradaDoacaoController {
 public boolean cadastrarEntradaDoacoes(EntradaDoacaoModel f){
     String sql = "INSERT INTO EntradaDoacao(fornecedor, tipo, quantidade, duracao)"
             +"VALUES (?, ?, ?, ?)";
     try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){
             
         ps.setString(1, f.getFornecedor());
         ps.setString(2, f.getTipo());
         ps.setInt(3, f.getQuantidade());
         ps.setString(4, f.getDuracao());
         
         int rowsAffected = ps.executeUpdate();
         return rowsAffected > 0;
                  } catch (SQLException e){
              e.printStackTrace();
              return false;
             }
}}
