/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.EntradaDoacaoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntradaDoacaoController {

   public boolean cadastrar(EntradaDoacaoModel entrada) {
        String sql = "INSERT INTO EntradaDoacao (tipo, fornecedor, quantidade,duracao) VALUES (?, ?, ?,?)";

        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entrada.getTipo());
            stmt.setString(2, entrada.getFornecedor());
            stmt.setInt(3, entrada.getQuantidade());
            stmt.setString(4, entrada.getDuracao());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar entrada de doação: " + e.getMessage());
            return false;
        }
    }

    public List<EntradaDoacaoModel> listar() {
        List<EntradaDoacaoModel> lista = new ArrayList<>();
        String sql =  "SELECT * FROM EntradaDoacao" ;
               
             
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EntradaDoacaoModel e = new EntradaDoacaoModel();
                e.setIdEntradaDoacao(rs.getInt("idEntradaDoacao"));
                e.setFornecedor(rs.getString("fornecedor"));
                e.setTipo(rs.getString("tipo"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setDuracao(rs.getString("duracao"));
                lista.add(e);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar entradas de doação: " + e.getMessage());
        }
        return lista;
    }

    public EntradaDoacaoModel pesquisarPorId(int id) {
        String sql = "SELECT * FROM EntradaDoacao WHERE idEntradaDoacao = ?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                EntradaDoacaoModel e = new EntradaDoacaoModel();
                e.setIdEntradaDoacao(rs.getInt("idEntradaDoacao"));
                e.setFornecedor(rs.getString("fornecedor"));
                e.setTipo(rs.getString("tipo"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setDuracao(rs.getString("duracao"));
                return e;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar entrada de doação: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizar(EntradaDoacaoModel entrada) {
        String sql = "UPDATE EntradaDoacao SET fornecedor=?, tipo=?, quantidade=?, duracao=? WHERE idEntradaDoacao=?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entrada.getFornecedor());
            stmt.setString(2, entrada.getTipo());
            stmt.setInt(3, entrada.getQuantidade());
            stmt.setString(4, entrada.getDuracao());
            stmt.setInt(5, entrada.getIdEntradaDoacao());

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
        String sql = "DELETE FROM EntradaDoacao WHERE idEntradaDoacao = ?";
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

