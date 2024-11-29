package com.mycompany.bingo;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Random;

public class Jugador extends JPanel {

    private int id;
    private Carta carta;
    private boolean gano;

    public Jugador(int id) {
        this.id = id;
        this.carta = new Carta(5, 5); // Crear una carta con 5 columnas y 5 filas
        this.carta.generarTabla(); // Generar las bolas del tablero
        this.gano = false;

        // Configurar transparencia
        this.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
        this.setOpaque(false); // Permitir transparencia

        // Configurar el JPanel con un GridLayout
        this.setLayout(new GridLayout(5, 5)); // 5 filas, 5 columnas

        // Agregar cada Bola al JPanel
        for (int i = 0; i < carta.getFilas(); i++) {
            for (int j = 0; j < carta.getColumnas(); j++) {
                Bola bola = carta.getBola(i, j);
                this.add(bola); // Agregar la Bola (que extiende JButton) al panel
            }
        }
    }

    public int getId() {
        return id;
    }

    public Carta getCarta() {
        return carta;
    }

    public void buscarBola(Bola bolaBuscada) {
        // Iterar sobre todas las bolas en el tablero del jugador
        for (int i = 0; i < carta.getFilas(); i++) {
            for (int j = 0; j < carta.getColumnas(); j++) {
                Bola bola = carta.getBola(i, j); // Obtener cada bola del tablero

                // Comprobar si la bola en el tablero coincide con la bola generada
                if (bola.getLetra() == bolaBuscada.getLetra() && bola.getNumero() == bolaBuscada.getNumero()) {
                    bola.marcarBola(); // Marcar la bola encontrada

                    // Generar un color aleatorio para el fondo
                    Random rand = new Random();
                    Color colorAleatorio = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

                    // Comprobar si el color es blanco, y en ese caso asignar otro color
                    while (colorAleatorio.equals(Color.WHITE)) {
                        colorAleatorio = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                    }

                    bola.setBackground(colorAleatorio); // Cambiar el color de fondo

                    bola.revalidate(); // Revalidar el componente
                    bola.repaint(); // Repintar el componente
                    break; // Salir del bucle, ya que la bola es única
                }
            }
        }
    }

    public boolean getGano() {
        return gano;
    }

    public void marcarVictoria() {
        gano = true;
    }

    public void tomarCarta() {
        // Limpiar todas las bolas del panel
        this.removeAll();

        // Generar una nueva carta
        carta.generarTabla();

        // Volver a agregar las bolas generadas a este panel
        for (int i = 0; i < carta.getFilas(); i++) {
            for (int j = 0; j < carta.getColumnas(); j++) {
                Bola bola = carta.getBola(i, j);
                this.add(bola); // Agregar la bola al panel
            }
        }

        // Asegurarse de que los componentes se actualicen y repinten
        this.revalidate();
        this.repaint();
    }

}
