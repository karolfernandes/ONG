/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



import Model.ChamadoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChamadoController {

    public boolean cadastrar(ChamadoModel chamado) {
        String sql = "INSERT INTO Chamado (tipo, problema, resolvido, Colaborador_idVoluntario) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chamado.getTipo());
            stmt.setString(2, chamado.getProblema());
            stmt.setString(3, chamado.getResolvido());
            stmt.setInt(4, chamado.getColaboradorIdVoluntario());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    
    public List<ChamadoModel> listarChamados() {
    List<ChamadoModel> lista = new ArrayList<>();
    String sql = "SELECT tipo, problema, resolvido, idChamado FROM Chamado";

    try (Connection conn = ConexaoComBancoDados.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            ChamadoModel chamado = new ChamadoModel();
            chamado.setTipo(rs.getString("tipo"));
            chamado.setProblema(rs.getString("problema"));
            chamado.setResolvido(rs.getString("resolvido"));
            chamado.setIdChamado(rs.getInt("idChamado"));
            lista.add(chamado);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

    
    

    public List<ChamadoModel> listar() {
        List<ChamadoModel> lista = new ArrayList<>();
        
        String sql =  "SELECT c.*, p.nome AS nome Chamado FROM Colaboradores ch" 
                + "INNER JOIN Chamado p ON ch.Chamado_idChamado = p.idChamado"
                + "WHERE c.nome LIKE ? OR c.cpf LIKE ?";
        
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ChamadoModel c = new ChamadoModel();
                c.setIdChamado(rs.getInt("idChamado"));
                c.setTipo(rs.getString("tipo"));
                c.setProblema(rs.getString("problema"));
                c.setResolvido(rs.getString("resolvido"));
                c.setColaboradorIdVoluntario(rs.getInt("Colaborador_idVoluntario"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar chamados: " + e.getMessage());
        }
        return lista;
    }

    public List<ChamadoModel> pesquisarPorId(String nome) {
          List<ChamadoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM Chamado WHERE tipo like ?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,"%"+ nome+ "%");
            
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ChamadoModel c = new ChamadoModel();
                c.setIdChamado(rs.getInt("idChamado"));
                c.setTipo(rs.getString("tipo"));
                c.setProblema(rs.getString("problema"));
                c.setResolvido(rs.getString("resolvido"));
                c.setColaboradorIdVoluntario(rs.getInt("Colaborador_idVoluntario"));
                 lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar chamado: " + e.getMessage());
        }
        return lista;
    }

    public boolean marcarComoResolvido(int idChamado) {
    String sql = "UPDATE Chamado SET resolvido = 'sim' WHERE idChamado = ?";

    try (Connection conn = ConexaoComBancoDados.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

      
        stmt.setInt(1, idChamado);
        int linhasAfetadas = stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean excluir(int id) {
        String sql = "DELETE FROM Chamado WHERE idChamado = ?";
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
