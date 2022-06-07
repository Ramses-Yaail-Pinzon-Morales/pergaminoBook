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
public class usuarioDAO implements usuarioCRUD{
    Connection conectar = null;
    ConexionDB db = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int Ingresar(usuario usuario) {
        int respuesta = 0;
        String sql = "SELECT correo, pass FROM usuario WHERE correo = ? AND pass = ?";
        try {
            conectar = db.Conectar();
            ps = conectar.prepareStatement(sql);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getPass());
            rs = ps.executeQuery();
            while(rs.next()) {
                respuesta = respuesta + 1;
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPass(rs.getString("pass"));
            }
            
            if (respuesta == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
            return 0;
        }
    }
    
}
