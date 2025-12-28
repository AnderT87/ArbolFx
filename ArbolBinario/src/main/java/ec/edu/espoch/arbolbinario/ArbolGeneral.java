/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.arbolbinario;


public class ArbolGeneral<E> {
     private Nodo<E> raiz;
     
     public ArbolGeneral(){
         this.raiz = null;
     }

    public Nodo<E> getRaiz() {
        return raiz;
    }
     
    //Insertar (BST)
    public void insertar(E valor){
        raiz = insertarRec(raiz,valor);
    }
    
    private Nodo<E> insertarRec(Nodo<E> actual,E valor){
        if (actual == null) return new Nodo<E>(valor);
        
        if(valor.equals(actual.valor ) ){
            actual.izquierdo = insertarRec(actual.izquierdo,valor);
        }else if(valor.equals(actual.valor)){
            actual.derecho = insertarRec(actual.derecho,valor);
        }
        
        return actual;
    }
    
    
    //Arbol generico este tipo de arbol puede agregar cualquier tipo de datos ya se entero,registos, String ,ect.
    
    //public class NodoBinario<E> = se define el tipo de dtoa en que se declara el arbol

    @Override
    public String toString() {
        return "ArbolGeneral{" + "raiz=" + raiz + '}';
    }
    
}
