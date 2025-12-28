/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaenlazadasimple;

/**
 *
 * @author Admin
 */
public class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada(Nodo cabeza) {
        this.cabeza = null;
    }
    
    public boolean agregar(int dato){
        Nodo nuevoNodo = new Nodo(dato);
        if(cabeza == null){
            cabeza = nuevoNodo;
        }else{
            Nodo actual = new Nodo();
            while(nuevoNodo.getSiguiente()== null){
                actual = actual.siguiente;
            }
        }
    }return null;
    
}
