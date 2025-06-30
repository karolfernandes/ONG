/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



import Model.CalendarioModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarioController {

    public boolean cadastrar(CalendarioModel calendario) {
        String sql = "INSERT INTO Calendario (dataCalendario, horario, localCalendario, participantes, descricao, anexos) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, calendario.getDataCalendario());
            stmt.setString(2, calendario.getHorario());
            stmt.setString(3, calendario.getLocalCalendario());
            stmt.setString(4, calendario.getParticipantes());
            stmt.setString(5, calendario.getDescricao());
            stmt.setString(6, calendario.getAnexos());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<CalendarioModel> listar() {
        List<CalendarioModel> lista = new ArrayList<>();
        
        String sql =  "SELECT c.*, p.nome AS nome Calendario FROM Calendario ca"
                + "INNER JOIN Calendario ca ON ca.Calendario_idCalendario = p.idCalendario"
                + "WHERE c.nome LIKE ? OR c.cpf LIKE ?";
        
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CalendarioModel c = new CalendarioModel();
                c.setIdCalendario(rs.getInt("idCalendario"));
                c.setDataCalendario(rs.getString("dataCalendario"));
                c.setHorario(rs.getString("horario"));
                c.setLocalCalendario(rs.getString("localCalendario"));
                c.setParticipantes(rs.getString("participantes"));
                c.setDescricao(rs.getString("descricao"));
                c.setAnexos(rs.getString("anexos"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar calendários: " + e.getMessage());
        }
        return lista;
    }

    public CalendarioModel pesquisarPorId(int id) {
        String sql = "SELECT * FROM Calendario WHERE idCalendario = ?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                CalendarioModel c = new CalendarioModel();
                c.setIdCalendario(rs.getInt("idCalendario"));
                c.setDataCalendario(rs.getString("dataCalendario"));
                c.setHorario(rs.getString("horario"));
                c.setLocalCalendario(rs.getString("localCalendario"));
                c.setParticipantes(rs.getString("participantes"));
                c.setDescricao(rs.getString("descricao"));
                c.setAnexos(rs.getString("anexos"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar calendário: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizar(CalendarioModel calendario) {
        String sql = "UPDATE Calendario SET dataCalendario=?, horario=?, localCalendario=?, participantes=?, descricao=?, anexos=? WHERE idCalendario=?";
        try (Connection conn = ConexaoComBancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, calendario.getDataCalendario());
            stmt.setString(2, calendario.getHorario());
            stmt.setString(3, calendario.getLocalCalendario());
            stmt.setString(4, calendario.getParticipantes());
            stmt.setString(5, calendario.getDescricao());
            stmt.setString(6, calendario.getAnexos());
            stmt.setInt(7, calendario.getIdCalendario());

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
        String sql = "DELETE FROM Calendario WHERE idCalendario = ?";
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
