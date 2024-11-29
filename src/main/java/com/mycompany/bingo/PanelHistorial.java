package com.mycompany.bingo;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.util.ArrayList;


public class PanelHistorial extends JPanel {
    private Historial historial;

    public PanelHistorial() {
        this.historial = new Historial(5, 15); // Crear un historial con 5 columnas y 15 filas
        this.historial.generarTabla(); // Generar las bolas del tablero

        setLayout(new GridLayout(5, 15)); // Configurar el GridLayout: 5 filas, 15 columnas

        // Obtener las bolas del historial (en una lista)
        ArrayList<Bola> bolasOrdenadas = obtenerBolasOrdenadas();

        // Agregar las bolas al panel en orden
        for (Bola bola : bolasOrdenadas) {
            this.add(bola); // Agregar la Bola (que extiende JButton) al panel
        }
    }

    // Método para obtener las bolas ordenadas por letra y número
    private ArrayList<Bola> obtenerBolasOrdenadas() {
        ArrayList<Bola> bolasOrdenadas = new ArrayList<>();

        // Iterar por columnas primero (orden por letra: B, I, N, G, O)
        for (int columna = 0; columna < historial.getColumnas(); columna++) {
            for (int fila = 0; fila < historial.getFilas(); fila++) {
                Bola bola = historial.getBola(fila, columna);
                if (bola != null) {
                    bolasOrdenadas.add(bola);
                }
            }
        }

        return bolasOrdenadas;
    }

    public void buscarBola(Bola bolaBuscada) {
        // Iterar sobre todas las bolas en el historial
        for (int fila = 0; fila < historial.getFilas(); fila++) {
            for (int columna = 0; columna < historial.getColumnas(); columna++) {
                Bola bola = historial.getBola(fila, columna);
                // Comprobar si la bola en el historial coincide con la bola buscada
                if (bola.getLetra() == bolaBuscada.getLetra() && bola.getNumero() == bolaBuscada.getNumero()) {
                    bola.setBackground(Color.YELLOW); // Cambiar color de fondo a amarillo
                    bola.revalidate(); // Revalidar el componente
                    bola.marcarBola(); // Marcar la bola
                    break; // Salir del bucle, ya que la bola es única
                }
            }
        }
    }
}
