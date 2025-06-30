/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.ProjetoModel;
import Model.RetiradaDoacaoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetiradaDoacaoController {

    public boolean cadastrar(RetiradaDoacaoModel retirada) {
        String sql = "INSERT INTO RetiradaDoacao (destinatario, tipo, quantidade,campoDataRetirada, Chamado_idChamado) VALUES (?, ?, ?,?, ?)";

        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, retirada.getDestinatario());
            stmt.setString(2, retirada.getTipo());
            stmt.setInt(3, retirada.getQuantidade());
           stmt.setString(4, retirada.getData());
            stmt.setInt(5, retirada.getIdChamado());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<RetiradaDoacaoModel> listarTodos() {
        List<RetiradaDoacaoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM RetiradaDoacao";

        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                RetiradaDoacaoModel retirada = new RetiradaDoacaoModel();
                retirada.setIdRetiradaDoacaoArrecadacao(rs.getInt("idRetiradaDoacaoe"));
                retirada.setDestinatario(rs.getString("destinatario"));
                retirada.setTipo(rs.getString("tipo"));
                retirada.setQuantidade(rs.getInt("quantidade"));
             retirada.setData(rs.getString("dataRetirada"));
                retirada.setIdChamado(rs.getInt("Chamado_idChamado"));
                lista.add(retirada);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<RetiradaDoacaoModel> listar() {
        List<RetiradaDoacaoModel> lista = new ArrayList<>();
        String sql = "SELECT c.*, p.nome AS nome RetiradaDoacao FROM RetiradaDoacao rd" 
                + "INNER JOIN RetiradaDoacao p ON rd.RetiradaDoacao_idRetiradaDoacaoe = p.idRetiradaDoacaoe"
                + "WHERE c.nome LIKE ? OR c.cpf LIKE ?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                RetiradaDoacaoModel r = new RetiradaDoacaoModel();
                r.setIdRetiradaDoacaoArrecadacao(rs.getInt("idRetiradaDoacaoe"));
                r.setDestinatario(rs.getString("destinatario"));
                r.setTipo(rs.getString("tipo"));
                r.setQuantidade(rs.getInt("quantidade"));
                r.setData(rs.getString("dataRetirada"));
                r.setIdChamado(rs.getInt("Chamado_idChamado"));
                lista.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar retiradas de doação: " + e.getMessage());
        }
        return lista;
    }

    public RetiradaDoacaoModel pesquisarPorId(int id) {
        String sql = "SELECT * FROM RetiradaDoacao WHERE idRetiradaDoacaoe = ?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                RetiradaDoacaoModel r = new RetiradaDoacaoModel();
                r.setIdRetiradaDoacaoArrecadacao(rs.getInt("idRetiradaDoacaoe"));
                r.setDestinatario(rs.getString("destinatario"));
                r.setTipo(rs.getString("tipo"));
                r.setQuantidade(rs.getInt("quantidade"));
                r.setData(rs.getString("dataRetirada"));
                r.setIdChamado(rs.getInt("Chamado_idChamado"));
                return r;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar retirada de doação: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizar(RetiradaDoacaoModel retirada) {
        String sql = "UPDATE RetiradaDoacao SET destinatario=?, tipo=?, quantidade=?, dataRetirada=?, Chamado_idChamado=? WHERE idRetiradaDoacaoe=?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, retirada.getDestinatario());
            stmt.setString(2, retirada.getTipo());
            stmt.setInt(3, retirada.getQuantidade());
            stmt.setString(4, retirada.getData());
            stmt.setInt(5, retirada.getIdChamado());
            stmt.setInt(6, retirada.getIdRetiradaDoacaoArrecadacao());

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
        String sql = "DELETE FROM RetiradaDoacao WHERE idRetiradaDoacaoe = ?";
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

    public List<ProjetoModel> pesquisarPorId(String textoPesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
