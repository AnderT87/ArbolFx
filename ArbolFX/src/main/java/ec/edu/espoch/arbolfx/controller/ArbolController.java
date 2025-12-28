/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.arbolfx.controller;

import ec.edu.espoch.arbolfx.model.ArbolBinario;
import ec.edu.espoch.arbolfx.model.Node;
import ec.edu.espoch.arbolfx.view.ArbolCanvas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Admin
 */
public class ArbolController {

    // MODELO
    private ArbolBinario arbol;

    // VISTA (Canvas)
    private ArbolCanvas canvas;

    // FXML
    @FXML
    private TextField txtValor;
    @FXML
    private Label lblEstado;
    @FXML
    private StackPane canvasHolder;

    // =========================
    // INICIALIZACIÓN
    // =========================
    @FXML
    private void initialize() {
        arbol = new ArbolBinario();

        canvas = new ArbolCanvas();
        canvasHolder.getChildren().add(canvas);

        lblEstado.setText("Árbol vacío");
    }

    // =========================
    // INSERTAR
    // =========================
    @FXML
    private void insertar(ActionEvent event) {
        if (txtValor.getText().isEmpty()) {
            lblEstado.setText("Ingrese un valor");
            return;
        }

        int valor = Integer.parseInt(txtValor.getText());
        arbol.insertar(valor);

        actualizarVista();
        lblEstado.setText("Insertado: " + valor);
        txtValor.clear();
    }

    // =========================
    // ELIMINAR
    // =========================
    @FXML
    private void eliminar(ActionEvent event) {
        if (arbol.estaVacio()) {
            lblEstado.setText("El árbol está vacío");
            return;
        }

        int valor = Integer.parseInt(txtValor.getText());
        arbol.eliminar(valor);

        actualizarVista();
        lblEstado.setText("Eliminado: " + valor);
        txtValor.clear();
    }

    // =========================
    // BUSCAR (con highlight)
    // =========================
    @FXML
    private void buscar(ActionEvent event) {
        int valor = Integer.parseInt(txtValor.getText());

        boolean encontrado = arbol.buscar(valor);

        actualizarVista();

        if (encontrado) {
            canvas.highlight(valor);
            lblEstado.setText("Valor encontrado: " + valor);
        } else {
            lblEstado.setText("Valor NO encontrado");
        }
    }

    // =========================
    // ACTUALIZAR VISTA
    // =========================
    @FXML
    private void actualizarVista() {
        canvas.setRaiz(arbol.getRaiz());
        canvas.render();
    }
}
