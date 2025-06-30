/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



import Model.ColaboradorModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.ColaboradorModel;

import java.sql.Connection;
import static java.util.Collections.list;

public class ColaboradorController {
    
   public ColaboradorModel login(String email, String senha) {
    String sql = "SELECT * FROM Colaborador WHERE email = ? AND senha = ?";
    
    try (Connection conn = ConexaoComBancoDados.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            ColaboradorModel colaborador = new ColaboradorModel();
            colaborador.setIdColaborador(rs.getInt("idColaborador"));
            colaborador.setNome(rs.getString("nome"));
            colaborador.setCpf(rs.getString("cpf"));
            colaborador.setFuncao(rs.getString("funcao"));
            colaborador.setSexo(rs.getString("sexo"));
            colaborador.setDataNascimento(rs.getString("dataNascimento"));
            colaborador.setEmail(rs.getString("email"));
            colaborador.setSenha(rs.getString("senha"));
            colaborador.setTelefone(rs.getString("telefone"));
            return colaborador;
        } else {
            return null; // Login inválido
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


    public boolean cadastrar(ColaboradorModel colaborador) {
        String sql = "INSERT INTO Colaborador (nome, cpf, funcao, sexo, dataNascimento, email, senha, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getCpf());
            stmt.setString(3, colaborador.getFuncao());
            stmt.setString(4, colaborador.getSexo());
            stmt.setString(5, colaborador.getDataNascimento());
            stmt.setString(6, colaborador.getEmail());
            stmt.setString(7, colaborador.getSenha());
            stmt.setString(8, colaborador.getTelefone());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
            
        }    
    }

    public List<ColaboradorModel> listar() {
        List<ColaboradorModel> lista = new ArrayList<>();
        String sql = "SELECT c.*, p.nome AS nome Colaboradores FROM Colaboradores co"
                + "INNER JOIN Chamado p ON co.Colaborador_idColaborador = p.idColaborador";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ColaboradorModel c = new ColaboradorModel();
                c.setIdColaborador(rs.getInt("idColaborador"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setFuncao(rs.getString("funcao"));
                c.setSexo(rs.getString("sexo"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                c.setEmail(rs.getString("email"));
                c.setSenha(rs.getString("senha"));
                c.setTelefone(rs.getString("telefone"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar colaboradores: " + e.getMessage());
        }
        return lista;
    }

    public ColaboradorModel pesquisarPorId(int id) {
        String sql = "SELECT * FROM Colaborador WHERE idColaborador = ?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ColaboradorModel c = new ColaboradorModel();
                c.setIdColaborador(rs.getInt("idColaborador"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setFuncao(rs.getString("funcao"));
                c.setSexo(rs.getString("sexo"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                c.setEmail(rs.getString("email"));
                c.setSenha(rs.getString("senha"));
                c.setTelefone(rs.getString("telefone"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar colaborador: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizar(ColaboradorModel colaborador) {
        String sql = "UPDATE Colaborador SET nome=?, cpf=?, funcao=?, sexo=?, dataNascimento=?, email=?, senha=?, telefone=? WHERE idColaborador=?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getCpf());
            stmt.setString(3, colaborador.getFuncao());
            stmt.setString(4, colaborador.getSexo());
            stmt.setString(5, colaborador.getDataNascimento());
            stmt.setString(6, colaborador.getEmail());
            stmt.setString(7, colaborador.getSenha());
            stmt.setString(8, colaborador.getTelefone());
            stmt.setInt(9, colaborador.getIdColaborador());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM Colaborador WHERE idColaborador = ?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
