/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.dao;

import Cliente.model.Cliente;
import Cliente.util.utilDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ulises
 */
public class ClienteDAOImp implements ClienteDAO{
  private Connection connection;
    
    public ClienteDAOImp() {
        connection = utilDB.getConnection();
    }

    @Override
    public void agregarCliente(Cliente cliente) {
          try {
            String query = "INSERT INTO Cliente(numeroCliente,nombreCliente, apellido,sexo,direccion)" + "VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getNumeroCliente());
            ps.setString(2, cliente.getNombreCliente());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getSexo());
            ps.setString(4, cliente.getDireccion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  

    @Override
    public void borrarCliente(int idCliente) {
          try {
            String query = "DELETE FROM cliente WHERE "
                    + " id_cliente=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idCliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
     

    @Override
    public void cambiarCliente(Cliente cliente) {
         try {
            String query = "UPDATE cliente SET login= ?"
                    + ", numeroCliente=?"
                    + ", nombreCliente=?"
                    + ", apellido=?"
                    + ", sexo=?"
                    + ", direccion=?"
                    + "WHERE id_usuario=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getNumeroCliente());
            ps.setString(2, cliente.getNombreCliente());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getSexo());
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   

    @Override
    public Cliente elegirCliente(int idCliente) {
        Cliente cliente=null;
        try {
            String query = " SELECT * FROM cliente WHERE id_cliente=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                  cliente = new Cliente();
                        rs.getInt("id_cliente");
                        rs.getString("numeroCliente");
                        rs.getString("nombreCliente");
                        rs.getString("apellido");
                        rs.getString("sexo");
                        rs.getString("direccion");
             
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> desplegarClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id_cliente"),
                        rs.getString("numeroCliente"),
                        rs.getString("nombreCliente"),
                        rs.getString("apellido"),
                        rs.getString("sexo"),
                        rs.getString("direccion"));
                clientes.add(cliente);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
        
    }
    
 

    
}//FIN DE LA CLASE

