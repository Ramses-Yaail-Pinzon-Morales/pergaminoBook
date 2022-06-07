/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.*;
/**
 *
 * @author silvi
 */
public class ConexionDB {
    private static Connection conectar;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "SilviaPOSS21";
    private static final String url = "jdbc:mysql://localhost:3306/pergaminobook"+"?useTimezone=true&serverTimezone=UTC";
    
    public ConexionDB() {
        conectar = null;
        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado a la base de datos.");
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    public Connection Conectar() {
        return conectar;
    }
}
