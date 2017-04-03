package tema8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        Scanner tec = new Scanner(System.in);
        ArrayList<Contacto> agenda = leerFichero();
        int opt = 0;  // controla menu
        
        
        if(agenda.isEmpty()==false){
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            int num = 0;
            Date fnac; 
            
            for(Contacto p:agenda){
            
            fnac = df.parse(p.getFnacimiento());
            
            num = check(fnac);
            
            if(num>0){
                System.out.println("Es el cumpleaños de: " + p.getNombre());
                System.out.println("Y cumple " + num + " años.");
                System.out.println();
            }
        
        }
        
        }
        
        
        
        
        
        
        
        
        do {
            do {
                System.out.println("\t\t\tMENU PRINCIPAL");
                System.out.println("\t1 = Consultar contacto por nombre");
                System.out.println("\t2 = Eliminar contacto por nombre");      // no voy a controlar si hay mas con 1 del mismo nombre, en ese caso eliminaría contactos por otro atributo o combinación de atributus ej: nombre + fnacimiento
                System.out.println("\t3 = Añadir Contacto");
                System.out.println("\t4 = Salir");

                opt = tec.nextInt();
                // consumo linea
                tec.nextLine();

                if (opt < 1 || opt > 4) {
                    System.out.println("ERROR, vuelva introducir");
                }

            } while (opt < 1 || opt > 4);

            switch (opt) {

                case 1:
                    System.out.println("Dame el nombre para buscar la info del contacto");
                    String nomAux = tec.nextLine();

                    boolean sw = false;
                    for (int i = 0; i < agenda.size(); i++) {
                        if (agenda.get(i).getNombre().equalsIgnoreCase(nomAux)) {
                            System.out.println(agenda.get(i).toString());
                        }
                        sw = true;

                    }
                    if (sw == false) {
                        System.out.println("No se ha encontrado el contacto");
                    }
                    break;

                case 2:

                    System.out.println("Dame el nombre para borrar el contacto");
                    String eliAux = tec.nextLine();
                    boolean sww = false;

                    for (int i = 0; i < agenda.size(); i++) {
                        if (agenda.get(i).getNombre().equalsIgnoreCase(eliAux)) {
                            agenda.remove(i);
                        }
                        sww = true;
                    }

                    if (sww == false) {
                        System.out.println("No se ha encontrado el contacto");
                    }
                    break;

                case 3:
                    
                    System.out.println("Dame el nombre"); 
                    String nombre = tec.nextLine();
                    
                    System.out.println("Dame la direccion");
                    String direccion = tec.nextLine();
                    
                    System.out.println("Dame el número de teléfono");
                    int telefono = tec.nextInt();
                    tec.nextLine(); // consumo linea
                    
                    System.out.println("Dame la fecha formato yyyy/MM/dd");
                    String fnacimiento = tec.nextLine(); // formato ejemplo yyyy/MM/dd 1989/03/26, NO VOY A CONTROLAR EL FORMATO....
                    
                    System.out.println("Escribe cualquier nota");
                    String notas = tec.nextLine();
                    
                    Contacto con = new Contacto(nombre,direccion,telefono,fnacimiento,notas);
                    
                    
                    agenda.add(con);
                    System.out.println("Contacto añadido.");
                    break;

            }

        } while (opt != 4);

        // ha salido del mundo, asi que ahora vuelco la info a un fichero
        
           ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Agenda.txt"));
            
            //escribo la lista entera 
            oos.writeObject(agenda);
            
            oos.close();
        
        
        
    }
   
    
    
    public static int check(Date fnacimiento){
    
    int dif = 0;

       Calendar cIni = new GregorianCalendar();
       cIni.setTime(fnacimiento);
       Date actual = new Date();
       Calendar cFin = new GregorianCalendar();
       cFin.setTime(actual);
       
       
       if(cIni.get(Calendar.MONTH)==cFin.get(Calendar.MONTH) && cIni.get(Calendar.DAY_OF_MONTH)==cFin.get(Calendar.DAY_OF_MONTH)){
       
           System.out.println("ES EL CUMPLE DE ALGUIEN ...");
           
           
       if ( cFin.get(Calendar.MONTH) >= cIni.get(Calendar.MONTH) ||(cFin.get(Calendar.MONTH) >= cIni.get(Calendar.MONTH)) && (cFin.get(Calendar.DAY_OF_MONTH) >= cIni.get(Calendar.DAY_OF_MONTH))) {
              dif =cFin.get(Calendar.YEAR) - cIni.get(Calendar.YEAR);
        } else {
              dif = cFin.get(Calendar.YEAR) - cIni.get(Calendar.YEAR) - 1;
        }
    
       }
    return dif;
    }
    
    
    public static ArrayList<Contacto> leerFichero() throws IOException, ClassNotFoundException{
        
        File f = new File("Agenda.txt");
        
        if(!f.exists()){
        //EscrituraFicheroEjecutarUNAvez random = new EscrituraFicheroEjecutarUNAvez();
             ArrayList<Contacto> agenda = new ArrayList<Contacto>();
    
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Agenda.txt"));
            
      
            oos.writeObject(agenda);
            
            oos.close();
        }
        
        
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Agenda.txt"));
        
    return (ArrayList<Contacto>) ois.readObject();
    
    
    }
    
    
    
    
    
    
    
    }
    


