package com.mycompany.bingo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Carta extends Tabla {

    private int columnas;
    private int filas;

    public Carta(int columnas, int filas) {
        super(columnas, filas);
        this.columnas = columnas;
        this.filas = filas;
    }

    @Override
    public boolean generarTabla() {
        // Definir los rangos de números para cada columna
        int[][] rangos = {
            {1, 15}, // B
            {16, 30}, // I
            {31, 45}, // N
            {46, 60}, // G
            {61, 75} // O
        };

        char[] letras = {'B', 'I', 'N', 'G', 'O'};
        for (int i = 0; i < columnas; i++) {
            // Crear una lista de números dentro del rango de la columna
            List<Integer> numeros = new ArrayList<>();
            for (int num = rangos[i][0]; num <= rangos[i][1]; num++) {
                numeros.add(num);
            }
            // Barajar los números para que sean aleatorios
            Collections.shuffle(numeros);

            // Asignar los primeros 'filas' números a la columna
            for (int j = 0; j < filas; j++) {
                Bola bola;
                
                //En caso de ser la bola central
                //Marcar como comodin
                if (i == 2 && j == 2) { 
                    bola = new Bola(Color.WHITE, 'x', 0);
                    bola.setText("N");
                    bola.marcarBola();
                    Random rand = new Random();
                    Color colorAleatorio = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                    bola.setBackground(colorAleatorio); // Cambiar el color de fondo
                } else {
                    bola = new Bola(Color.WHITE, letras[i], numeros.get(j));
                }

                this.agregarBola(j, i, bola);

            }

        }
        return true; // Indicar que la tabla se generó correctamente
    }

    public void imprimirTabla() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Bola bola = this.getBola(i, j);
                System.out.print(bola.getLetra() + "" + bola.getNumero() + "\t");
            }
            System.out.println();
        }
    }

}
