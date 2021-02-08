/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Compra;
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
public class CompraControlador {
    
    Connection miconexion=new Conexion().getConector();
    
    public void insertarCompra(Compra c) throws SQLException{
        String sentencia = "insert into compra (id,nProducto,nUsuario,precio) values(?,?,?,?)";
        
        PreparedStatement instruccion = miconexion.prepareStatement(sentencia);
        instruccion.setInt(1,c.getId());
        instruccion.setString(2,c.getNombreProducto());
        instruccion.setString(3,c.getNombreComprador());
        instruccion.setFloat(4,c.getPrecio());
        instruccion.executeUpdate();
        instruccion.close();
        
    }
    
    public void eliminarCompra(Compra c) throws SQLException{
        String sentencia = "delete from compra where id='"+ c.getId() + "';";
        PreparedStatement instruccion = miconexion.prepareStatement(sentencia);
        instruccion.executeUpdate();
        instruccion.close();
    }
    
    public void modificarCompra(Compra c) throws SQLException{
        
        String sentencia = "update compra set nUsuario=?, nProducto=?, precio=? where id='"+ c.getId() + "';";
        
        PreparedStatement instruccion = miconexion.prepareStatement(sentencia);
        instruccion.setString(1,c.getNombreProducto());
        instruccion.setString(2,c.getNombreComprador());
        instruccion.setFloat(3,c.getPrecio());
        instruccion.executeUpdate();
        instruccion.close();
        
    }
    
    public List<Compra> findAllCompras()throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from compra");

            rs.beforeFirst();
            List<Compra> milista = new ArrayList<Compra>();
            
            while(rs.next()){
                milista.add(new Compra(rs.getInt("id"),rs.getString("nProducto"),rs.getString("nUsuario"), rs.getFloat("precio")));
                
            }
            
            return milista;
    }
    
    
    public int contarCompras()throws SQLException{
        List<Compra> compras = findAllCompras();
        int cantidad = compras.size();
        return cantidad;
    }
    
    public Compra seleccionarCompra(int id) throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from compra where id='" + id + "';");

            rs.beforeFirst();
            Compra c = null;
            while(rs.next()){
               c = new Compra(rs.getInt("id"),rs.getString("nProducto"),rs.getString("nUsuario"), rs.getFloat("precio"));
            }
            
            return c;
    }
    
    public List<Compra> findAllComprasUsuario(String usuario)throws SQLException{
        Statement instruccion2 = miconexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = instruccion2.executeQuery("select * from compra where nUsuario='" + usuario + "';");

            rs.beforeFirst();
            List<Compra> milista = new ArrayList<Compra>();
            
            while(rs.next()){
                milista.add(new Compra(rs.getInt("id"),rs.getString("nProducto"),rs.getString("nUsuario"), rs.getFloat("precio")));
                
            }
            
            return milista;
    }
    
    public void cerrarConexion() throws SQLException{
        miconexion.close();
    }
    
}
