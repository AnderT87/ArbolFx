/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.arbolfx.view;

import ec.edu.espoch.arbolfx.model.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ArbolCanvas extends Canvas {

     private Node raiz;
    private Integer highlightValue = null;

    private final double NODE_RADIUS = 20;
    private final double LEVEL_HEIGHT = 70;

    public ArbolCanvas() {
        setWidth(1000);
        setHeight(500);
    }

    /* ======= MÉTODOS USADOS POR EL CONTROLADOR ======= */

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public void highlight(int valor) {
        this.highlightValue = valor;
    }

    public void clearHighlight() {
        this.highlightValue = null;
    }

    public void render() {
        GraphicsContext g = getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (raiz == null) {
            g.setFill(Color.GRAY);
            g.setFont(Font.font(16));
            g.fillText("Árbol vacío", 30, 40);
            return;
        }

        dibujarArbol(g, raiz, getWidth() / 2, 50, getWidth() / 4);
    }

    /* ======= DIBUJO RECURSIVO ======= */

    private void dibujarArbol(GraphicsContext g, Node nodo, double x, double y, double offset) {
        if (nodo == null) return;

        // Izquierdo
        if (nodo.izquierdo != null) {
            g.setStroke(Color.BLACK);
            g.strokeLine(x, y, x - offset, y + LEVEL_HEIGHT);
            dibujarArbol(g, nodo.izquierdo, x - offset, y + LEVEL_HEIGHT, offset / 2);
        }

        // Derecho
        if (nodo.derecho != null) {
            g.setStroke(Color.BLACK);
            g.strokeLine(x, y, x + offset, y + LEVEL_HEIGHT);
            dibujarArbol(g, nodo.derecho, x + offset, y + LEVEL_HEIGHT, offset / 2);
        }

        drawNode(g, nodo, x, y);
    }

    /* ======= NODO (CON HIGHLIGHT) ======= */

    private void drawNode(GraphicsContext g, Node nodo, double x, double y) {

        boolean resaltado = (highlightValue != null && nodo.dato == highlightValue);

        g.setFill(resaltado ? Color.LIGHTGREEN : Color.WHITE);
        g.setStroke(resaltado ? Color.GREEN : Color.BLACK);
        g.setLineWidth(resaltado ? 3 : 2);

        g.fillOval(x - NODE_RADIUS, y - NODE_RADIUS,
                   NODE_RADIUS * 2, NODE_RADIUS * 2);
        g.strokeOval(x - NODE_RADIUS, y - NODE_RADIUS,
                     NODE_RADIUS * 2, NODE_RADIUS * 2);

        g.setFill(Color.BLACK);
        g.setFont(Font.font(14));
        g.fillText(String.valueOf(nodo.dato), x - 6, y + 5);
    }
}
