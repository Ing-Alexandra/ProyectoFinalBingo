package com.mycompany.bingo;

public abstract class Tabla {
    
    private int columnas;
    private int filas;
    private Bola[][] bolas;
    
    // Constructor
    public Tabla(int columnas, int filas) {
        this.columnas = columnas;
        this.filas = filas;
        this.bolas = new Bola[filas][columnas];
    }

    // Métodos
    public void agregarBola(int fila, int columna, Bola bola) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IllegalArgumentException("Posición fuera de los límites de la tabla.");
        }
        bolas[fila][columna] = bola;
    }

    public Bola getBola(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IllegalArgumentException("Posición fuera de los límites de la tabla.");
        }
        return bolas[fila][columna];
    }

    // Getters
    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    public Bola[][] getBolas() {
        return bolas;
    }
    
    public abstract boolean generarTabla();
    
}
