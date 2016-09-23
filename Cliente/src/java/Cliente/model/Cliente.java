/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.model;

/**
 *
 * @author ulises
 */
public class Cliente {
     private int idCliente;
    private String numeroCliente;
    private String nombreCliente;
    private String apellido;
    private String sexo;
    private String direccion;
    
    
      public Cliente(int idCliente, String numeroCliente, String nombreCliente, String apellido, String sexo, String direccion) {
        this.idCliente = idCliente;
        this.numeroCliente = numeroCliente;
        this.nombreCliente = nombreCliente;
        this.apellido = apellido;
        this.sexo = sexo;
        this.direccion = direccion;
    }
    
    public Cliente(){
        this(0,"","","","","");
    }

   

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "cliente{" + "idCliente=" + idCliente + ", numeroCliente=" + numeroCliente + ", nombreCliente=" + nombreCliente 
                + ", apellido=" + apellido + ", sexo=" + sexo + ", direccion=" + direccion +  '}';
    }
    
    
}

