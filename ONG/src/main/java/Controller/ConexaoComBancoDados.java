/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ALUNO
 */
public class ConexaoComBancoDados {
    public static Connection conectar() {
        Connection conexao = null;

        String url = "jdbc:mysql://localhost:3306/ONG"; // Substitua "sistema" pelo nome do seu banco
        String usuario = "root";  // seu usuário MySQL
        String senha = "";    // sua senha MySQL

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

        return conexao;
    }
}

















