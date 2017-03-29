/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema8;

import java.io.Serializable;

/**
 *
 * @author AlumMati
 */
public class Contacto implements Serializable {

  private String nombre;
  private String direccion;
  private int telefono;
  private String fnacimiento; // formato ejemplo yyyy/MM/dd 1989/03/26
  private String notas;
  
  public Contacto(String nombre, String direccion, int telefono, String fnacimiento, String notas){
  
      this.nombre = nombre;
      this.direccion = direccion;
      this.telefono = telefono;
      this.fnacimiento = fnacimiento;
      this.notas = notas;
      
  }
  
  
  @Override
  public String toString() {
  
  
  return "Nombre:\t " + nombre + "\nDirección:\t " + direccion + "\nTeléfono:\t " + telefono + "\nFecha de Nacimiento:\t " + fnacimiento + "\nNotas:\t " + notas;
  
  }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the fnacimiento
     */
    public String getFnacimiento() {
        return fnacimiento;
    }

    /**
     * @param fnacimiento the fnacimiento to set
     */
    public void setFnacimiento(String fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    /**
     * @return the notas
     */
    public String getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }
    
}
