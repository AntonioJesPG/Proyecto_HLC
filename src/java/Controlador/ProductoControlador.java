/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Compra;
import Modelo.Producto;
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
public class ProductoControlador {
    
        Connection miconexion=new Conexion().getConector();
    
    public void insertarProducto(Producto p) throws SQLException{
        String sentencia = "insert into productos (id,nProducto,codigo,precio,descripcion) values(?,?,?,?,?)";
        
        PreparedStatement instruccion = miconexion.prepareStatement(sentencia);
        instruccion.setInt(1,p.getId());
        instruccion.setString(2,p.getNombre());
        instruccion.setString(3,p.getCodigo());
        instruccion.setFloat(4,p.getPrecio());
        instruccion.setString(5,p.getDescripcion());
        instruccion.executeUpdate();
        instruccion.close();
        
    }
    
    public void eliminarProducto(Producto p) throws SQLException{
        String sentencia = "delete from productos where id='"+ p.getId() + "';";
        PreparedStatement instruccion = miconexion.prepareStatement(sentencia);
        instruccion.executeUpdate();
        instruccion.close();
    }
    
    public void modificarProducto(Producto p) throws SQLException{
        
        String sentencia = "update productos set nProducto=?, codigo=?, precio=?, descripcion=? where id='"+ p.getId() + "';";
        
        PreparedStatement instruccion = miconexion.prepareStatement(sentencia);
        instruccion.setString(1,p.getNombre());
        instruccion.setString(2,p.getCodigo());
        instruccion.setFloat(3,p.getPrecio());
        instruccion.setString(4,p.getDescripcion());
        instruccion.executeUpdate();
        instruccion.close();
        
    }
    
    public List<Producto> findAllProductos()throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from productos");

            rs.beforeFirst();
            List<Producto> milista = new ArrayList<Producto>();
            
            while(rs.next()){
                milista.add(new Producto(rs.getInt("id"),rs.getString("nProducto"),rs.getString("codigo"), rs.getString("descripcion"), rs.getFloat("precio")));
                
            }
            
            return milista;
    }
    
    public Producto findLastProducto()throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("SELECT * FROM productos ORDER BY id DESC LIMIT 1;");

            rs.beforeFirst();
            Producto p = null;
            while(rs.next()){
               p = new Producto(rs.getInt("id"),rs.getString("nProducto"),rs.getString("codigo"), rs.getString("descripcion"), rs.getFloat("precio"));
            }
            
            return p;
    }
    
    public String generarCodigo() throws SQLException{
        String codigo;
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String n = String.valueOf((int)(Math.random()*(9999-1000)) + 1000);
        int letra = (int)(Math.random()*(26-1))+1;
        do{
            codigo = n + alphabet[1];
        }while(comprobarCodigo(codigo));
            
        
        return codigo;
    }
    
    public boolean comprobarCodigo(String codigo)throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("SELECT * FROM productos where codigo='" + codigo + "';");

            rs.beforeFirst();
            Producto p = null;
            if(rs.next()){
              return true;
            }
            
            return false;
    }
    
    public int contarProductos()throws SQLException{
        List<Producto> productos = findAllProductos();
        int cantidad = productos.size();
        return cantidad;
    }
    
    public Producto seleccionarProducto(int id) throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from productos where id='" + id + "';");

            rs.beforeFirst();
            Producto p = null;
            while(rs.next()){
               p =  new Producto(rs.getInt("id"),rs.getString("nProducto"),rs.getString("codigo"), rs.getString("descripcion"), rs.getFloat("precio"));
            }
            
            return p;
    }
    
    public Producto seleccionarProductoNombre(String nombre) throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from productos where nProducto='" + nombre + "';");

            rs.beforeFirst();
            Producto p = null;
            while(rs.next()){
                p =  new Producto(rs.getInt("id"),rs.getString("nProducto"),rs.getString("codigo"), rs.getString("descripcion"), rs.getFloat("precio"));
            }
            
            return p;
    }
    
    public boolean comprobarProducto(String nProducto, String codigo) throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from productos where nProducto='" + nProducto + "' OR codigo='" + codigo + "';");
            out.println("comprobadoString");
            rs.beforeFirst();
            Producto p = null;
            if(rs.next()){
               return true;
            }
            return false;
    }

    public void cerrarConexion() throws SQLException{
        miconexion.close();
    }
    
    
}
