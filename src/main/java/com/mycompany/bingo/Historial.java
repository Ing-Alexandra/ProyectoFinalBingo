package com.mycompany.bingo;

import java.awt.Color;


public class Historial extends Tabla {


    public Historial(int columnas, int filas) {
        super(columnas, filas);
    }

    @Override
    public boolean generarTabla() {
        // Letras B, I, N, G, O con rangos de números correspondientes
        char[] letras = {'B', 'I', 'N', 'G', 'O'};
        int contador = 1; // Contador para los números del 1 al 75

        // Crear las 75 bolas (5 columnas x 15 números por letra)
        for (int columna = 0; columna < 5; columna++) {
            for (int fila = 0; fila < 15; fila++) {
                char letra = letras[columna]; // Obtener la letra correspondiente
                int numero = contador; // Número correspondiente
                Bola bola = new Bola(new Color(200, 200, 255), letra, numero);

                // Agregar la bola al tablero de la tabla
                this.agregarBola(fila, columna, bola);


                contador++; // Incrementar el contador para la siguiente bola
            }
        }
        return true;
    } 
}
