/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.arbolfx.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ArbolBinario {

    private Node raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Node insertarRec(Node nodo, int valor) {
        if (nodo == null) {
            return new Node(valor);
        }

        if (valor < nodo.dato) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            nodo.derecho = insertarRec(nodo.derecho, valor);
        }

        return nodo;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Node nodo, int valor) {
        if (nodo == null) {
            return false;
        }
        if (nodo.dato == valor) {
            return true;
        }

        if (valor < nodo.dato) {
            return buscarRec(nodo.izquierdo, valor);
        } else {
            return buscarRec(nodo.derecho, valor);
        }
    }

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Node eliminarRec(Node nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.dato) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            nodo.derecho = eliminarRec(nodo.derecho, valor);
        } else {
            // Caso 1: sin hijos
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }
            // Caso 2: un hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Caso 3: dos hijos
            Node sucesor = minimo(nodo.derecho);
            nodo.dato = sucesor.dato;
            nodo.derecho = eliminarRec(nodo.derecho, sucesor.dato);
        }

        return nodo;
    }

    private Node minimo(Node nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public List<Integer> inOrden() {
        List<Integer> lista = new ArrayList<>();
        inOrdenRec(raiz, lista);
        return lista;
    }

    private void inOrdenRec(Node nodo, List<Integer> lista) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierdo, lista);
            lista.add(nodo.dato);
            inOrdenRec(nodo.derecho, lista);
        }
    }

    public List<Integer> preOrden() {
        List<Integer> lista = new ArrayList<>();
        preOrdenRec(raiz, lista);
        return lista;
    }

    private void preOrdenRec(Node nodo, List<Integer> lista) {
        if (nodo != null) {
            lista.add(nodo.dato);
            preOrdenRec(nodo.izquierdo, lista);
            preOrdenRec(nodo.derecho, lista);
        }
    }

    public List<Integer> postOrden() {
        List<Integer> lista = new ArrayList<>();
        postOrdenRec(raiz, lista);
        return lista;
    }

    private void postOrdenRec(Node nodo, List<Integer> lista) {
        if (nodo != null) {
            postOrdenRec(nodo.izquierdo, lista);
            postOrdenRec(nodo.derecho, lista);
            lista.add(nodo.dato);
        }
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public Node getRaiz() {
        return raiz;
    }
}
