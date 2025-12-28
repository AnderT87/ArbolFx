/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espoch.arbolbinario;

/**
 *
 * @author Admin
 */
public class ImplementacionArbolGeneral {

    public static void main(String[] args) {
        
        ArbolGeneral<String> t = new ArbolGeneral<>();
        
        
        t.insertar("Andres");
        t.insertar("hola");
        t.insertar("hello");
        
        
        t.toString();
                
    }
}
