/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.ProjetoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoController {

    public Boolean cadastrar(ProjetoModel projeto) {
        String sql = "INSERT INTO Projeto (nome, horario, dataProjeto, duracao, Chamado_idChamado) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getHorario());
            stmt.setString(3, projeto.getDataProjeto());
            stmt.setString(4, projeto.getDuracao());
            stmt.setInt(5, projeto.getChamadoIdChamado());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar projeto: " + e.getMessage());
            return false;
        }
    }

  public List<ProjetoModel> listarProjetosComNomeChamado() {
    List<ProjetoModel> lista = new ArrayList<>();

    String sql = "SELECT p.idProjeto, p.nome AS nomeProjeto, p.horario, p.dataProjeto, p.duracao, c.problema AS nomeChamado "
               + "FROM Projeto p JOIN Chamado c ON p.Chamado_idChamado = c.idChamado";

    try (Connection conn = ConexaoComBancoDados.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            ProjetoModel projeto = new ProjetoModel();
            projeto.setIdProjeto(rs.getInt("idProjeto"));
            projeto.setNome(rs.getString("nomeProjeto"));
            projeto.setHorario(rs.getString("horario"));
            projeto.setDataProjeto(rs.getString("dataProjeto"));
            projeto.setDuracao(rs.getString("duracao"));
            projeto.setNomeChamado(rs.getString("nomeChamado")); // novo campo no model

            lista.add(projeto);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao listar projetos: " + e.getMessage());
    }

    return lista;
}



  public List<ProjetoModel> pesquisarPorId(String textoPesquisa) {
    List<ProjetoModel> lista = new ArrayList<>();

    String sql = "SELECT p.idProjeto, p.nome AS nomeProjeto, p.horario, p.dataProjeto, p.duracao, c.problema AS nomeChamado "
               + "FROM Projeto p JOIN Chamado c ON p.Chamado_idChamado = c.idChamado "
               + "WHERE p.nome LIKE ?";

    try (Connection conn = ConexaoComBancoDados.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, "%" + textoPesquisa + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ProjetoModel projeto = new ProjetoModel();
            projeto.setIdProjeto(rs.getInt("idProjeto"));
            projeto.setNome(rs.getString("nomeProjeto"));
            projeto.setHorario(rs.getString("horario"));
            projeto.setDataProjeto(rs.getString("dataProjeto"));
            projeto.setDuracao(rs.getString("duracao"));
            projeto.setNomeChamado(rs.getString("nomeChamado"));
            lista.add(projeto);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao pesquisar projetos: " + e.getMessage());
    }

    return lista;
}


    public boolean atualizar(ProjetoModel projeto) {
        String sql = "UPDATE Projeto SET nome=?, horario=?, dataProjeto=?, duracao=?, Chamado_idChamado=? WHERE idProjeto=?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getHorario());
            stmt.setString(3, projeto.getDataProjeto());
            stmt.setString(4, projeto.getDuracao());
            stmt.setInt(5, projeto.getIdChamado());
            stmt.setInt(6, projeto.getIdProjeto());

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
        String sql = "DELETE FROM Projeto WHERE idProjeto = ?";
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
