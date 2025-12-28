/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.arbolfx.model;

/**
 *
 * @author Admin
 */
public class Node {
    public int dato;
    public Node izquierdo;
    public Node derecho;

    public Node(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}
