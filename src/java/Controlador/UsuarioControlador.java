/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Drakthon
 */
public class UsuarioControlador {
    
    Connection miconexion=new Conexion().getConector();
    
    public void insertarUsuario(Usuario u) throws SQLException{
        String sentencia = "insert into usuarios (id,nUsuario,contrasena,direccion,telefono,dni,mail,saldo) values(?,?,?,?,?,?,?,?)";
        
        PreparedStatement instruccion = miconexion.prepareStatement(sentencia);
        instruccion.setInt(1,u.getId());
        instruccion.setString(2,u.getNombre());
        instruccion.setString(3,u.getContrasenia());
        instruccion.setString(4,u.getDireccion());
        instruccion.setString(5,u.getTelefono());
        instruccion.setString(6,u.getDni());
        instruccion.setString(7,u.getEmail());
        instruccion.setFloat(8,u.getSaldo());
        instruccion.executeUpdate();
        instruccion.close();
        
    }
    
    public void eliminarUsuario(Usuario u) throws SQLException{
        String sentencia = "delete from usuarios where id='"+ u.getId() + "';";
        PreparedStatement instruccion = miconexion.prepareStatement(sentencia);
        instruccion.executeUpdate();
        instruccion.close();
    }
    
    public void modificarUsuario(Usuario u) throws SQLException{
        
        String sentencia = "update usuarios set nUsuario=?, contrasena=?, direccion=?, telefono=?, dni=?, mail=?, saldo=? where id='"+ u.getId() + "';";
        
        PreparedStatement instruccion = miconexion.prepareStatement(sentencia);
        instruccion.setString(1,u.getNombre());
        instruccion.setString(2,u.getContrasenia());
        instruccion.setString(3,u.getDireccion());
        instruccion.setString(4,u.getTelefono());
        instruccion.setString(5,u.getDni());
        instruccion.setString(6,u.getEmail());
        instruccion.setFloat(7,u.getSaldo());
        instruccion.executeUpdate();
        instruccion.close();
        
    }
    
    public List<Usuario> findAllUsuarios()throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from usuarios");

            rs.beforeFirst();
            List<Usuario> milista = new ArrayList<Usuario>();
            
            while(rs.next()){
                milista.add(new Usuario(rs.getInt("id"),rs.getString("nUsuario"),rs.getString("contrasena"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("dni"), rs.getString("mail"), rs.getFloat("saldo")));
                
            }
            
            return milista;
    }
    
    public int contarUsuarios()throws SQLException{
        List<Usuario> usuarios = findAllUsuarios();
        int cantidad = usuarios.size();
        return cantidad;
    }
    
    public Usuario seleccionarUsuario(int id) throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from usuarios where id='" + id + "';");

            rs.beforeFirst();
            Usuario u = null;
            while(rs.next()){
               u = new Usuario(rs.getInt("id"),rs.getString("nUsuario"),rs.getString("contrasena"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("dni"), rs.getString("mail"), rs.getFloat("saldo"));     
            }
            
            return u;
    }
    
    public Usuario seleccionarUsuarioNombre(String nombre) throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from usuarios where nUsuario='" + nombre + "';");

            rs.beforeFirst();
            Usuario u = null;
            while(rs.next()){
               u = new Usuario(rs.getInt("id"),rs.getString("nUsuario"),rs.getString("contrasena"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("dni"), rs.getString("mail"), rs.getFloat("saldo"));     
            }
            
            return u;
    }
    
    public Usuario seleccionarAdmin() throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from usuarios where nUsuario='admin';");

            rs.beforeFirst();
            Usuario u = null;
            while(rs.next()){
               u = new Usuario(rs.getInt("id"),rs.getString("nUsuario"),rs.getString("contrasena"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("dni"), rs.getString("mail"), rs.getFloat("saldo"));     
            }
            
            return u;
    }
    
    public boolean comprobarUsuario(String usuario, String pass) throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from usuarios where nUsuario='" + usuario + "' AND contrasena='" + pass + "';");
            out.println("comprobadoString");
            rs.beforeFirst();
            Usuario u = null;
            if(rs.next()){
               return true;
            }
            return false;
    }
    
    public boolean comprobarUsuarioExistente(String usuario) throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from usuarios where nUsuario='" + usuario + "';");

            rs.beforeFirst();
            Usuario u = null;
            if(rs.next()){
               return true;
            }
            return false;
    }
    
    public boolean comprobarDni(String dni) throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from usuarios where nUsuario='" + dni + "';");

            rs.beforeFirst();
            Usuario u = null;
            if(rs.next()){
               return true;
            }
            return false;
    }
    
    public void cerrarConexion() throws SQLException{
        miconexion.close();
    }
    
}
