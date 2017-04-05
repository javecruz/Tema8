/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema8;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author AlumMati
 */
public class Contacto implements Serializable {

  private String nombre;
  private String direccion;
  private int telefono;
  private Date fnacimiento; // formato ejemplo yyyy/MM/dd 1989/03/26
  private String notas;
  
  public Contacto(String nombre, String direccion, int telefono, String fnacimiento, String notas) throws ParseException{
      SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
      this.nombre = nombre;
      this.direccion = direccion;
      this.telefono = telefono;
      // el parametro que le entra es string, lo que hace esto es coger esa string y pasarlo a date en un formato dado
      this.fnacimiento = df.parse(fnacimiento);
      this.notas = notas;
      
  }
  
  
  @Override
  public String toString() {
  Calendar bienHecho = new GregorianCalendar();
  //bienHecho.setTime(this.fnacimiento);
  SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
  
  
    return "Nombre:\t " + nombre + "\nDirección:\t " + direccion + "\nTeléfono:\t " + telefono + "\nFecha de Nacimiento:\t " + df.format(fnacimiento) + "\nNotas:\t " + notas;

  //return "Nombre:\t " + nombre + "\nDirección:\t " + direccion + "\nTeléfono:\t " + telefono + "\nFecha de Nacimiento:\t " + "El año es: " + bienHecho.get(Calendar.YEAR) + " el mes es " + bienHecho.get(Calendar.MONTH) + " y el dia es " + bienHecho.get(Calendar.DAY_OF_MONTH) + "\nNotas:\t " + notas;
  
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
    public Date getFnacimiento() {
        return fnacimiento;
    }

    /**
     * @param fnacimiento the fnacimiento to set
     */
   

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
