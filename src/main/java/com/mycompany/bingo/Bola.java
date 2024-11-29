package com.mycompany.bingo;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Bola extends JButton {

    private Color color;
    private char letra;
    private int numero;
    private boolean marcado;

    // Constructor
    public Bola(Color color, char letra, int numero) {
        this.color = color;
        this.letra = letra;
        this.numero = numero;
        this.marcado = false;

        // Configurar el botón (heredado de JButton)
        this.setBackground(color);
        this.setText(letra+String.valueOf(numero));
        this.setPreferredSize(new Dimension(60, 60)); // Tamaño preferido (ancho x alto)

        this.setFont(new Font("Arial", Font.BOLD, 14)); // "Arial" es la fuente, BOLD es el estilo, 14 es el tamaño
    }

    // Getters y Setters
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.setBackground(color);
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
        this.setText(letra + String.valueOf(this.numero));
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        this.setText(this.letra + String.valueOf(numero));
    }

    public void marcarBola() {
        marcado = true;
    }
    
    public boolean isMarcado(){
        return marcado;
    }

    @Override
    public String toString() {
        return "Bola{"
                + "letra=" + letra
                + ", numero=" + numero
                + ", marcado=" + marcado
                + '}';
    }

}
