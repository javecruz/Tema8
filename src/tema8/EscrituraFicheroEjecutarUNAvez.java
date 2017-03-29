package tema8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class EscrituraFicheroEjecutarUNAvez {
    
    public static void main(String args[]) throws IOException{
    
    
    ArrayList<Contacto> agenda = new ArrayList<Contacto>();
    
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Agenhjasgdghasdda.txt"));
            
      
            oos.writeObject(agenda);
            
            oos.close();
    
    
    
    
    
    }
    
    
    
}
