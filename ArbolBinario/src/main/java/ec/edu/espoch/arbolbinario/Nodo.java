/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.arbolbinario;

/**
 *
 * @author Admin
 */
public class Nodo <E> {
    
    public E valor;
    public Nodo<E> izquierdo;
    public Nodo<E> derecho;

    public Nodo(E valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "valor=" + valor + ", izquierdo=" + izquierdo + ", derecho=" + derecho + '}';
    }
    
    
    
}
