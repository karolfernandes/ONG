/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ColaboradoresModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ALUNO
 */
public class ColaboradoresController {
  public boolean cadastrarColaboradores(ColaboradoresModel f) {
      String sql ="INSERT INTO Colaborador(nome, cpf, funcao, sexo, dataNascimento, email, senha, telefone)"
              +"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      try (Connection conn = ConexaoComBancoDados.conectar();
              PreparedStatement ps = conn.prepareStatement(sql)){
                  
                  ps.setString(1, f.getNome());
                  ps.setString(2, f.getCpf());
                  ps.setString(3, f.getFuncao());
                  ps.setString(4, f.getSexo());
                  ps.setString(5, f.getDataNascimento());
                  ps.setString(6, f.getEmail());
                  ps.setString(7, f.getSenha());
                  ps.setString(8, f.getTelefone());
                  
                  int rowsAffeted = ps.executeUpdate();
                  return rowsAffeted > 0;
              } catch (SQLException e){
                      e.printStackTrace();
              return false;
                      
                      
      }  
  }}
