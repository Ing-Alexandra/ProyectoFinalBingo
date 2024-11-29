package com.mycompany.bingo;

import java.awt.Color;
import java.util.HashSet;
import java.util.Random;

public class Tombola {

    private HashSet<Bola> bolas;

    // Constructor: Inicializa las bolas de la tombola
    public Tombola() {
        bolas = new HashSet<Bola>();

        // Letras B, I, N, G, O con rangos de números correspondientes
        char[] letras = {'B', 'I', 'N', 'G', 'O'};
        
        // Crear las 75 bolas (con letras B, I, N, G, O y números del 1 al 75)
        for (int i = 0; i < 75; i++) {
            char letra = letras[i / 15]; // Letras B, I, N, G, O
            int numero = i + 1; // Números del 1 al 75
            Bola bola = new Bola(new Color(200, 200, 255), letra, numero);
            bolas.add(bola);
        }
    }

    // Método para sacar una bola aleatoria
    public Bola sacarBolaAleatoria() {
        // Convertir el HashSet a un ArrayList para obtener un índice aleatorio
        Bola bolaSorteada = null;

        if (!bolas.isEmpty()) {
            // Convertir el HashSet a ArrayList
            Object[] bolasArray = bolas.toArray();

            Random random = new Random();
            int indiceAleatorio = random.nextInt(bolasArray.length);

            // Obtener la bola aleatoria
            bolaSorteada = (Bola) bolasArray[indiceAleatorio];

            // Eliminar la bola sorteada del HashSet para evitar repeticiones
            bolas.remove(bolaSorteada);
        }

        return bolaSorteada;  // Puede ser null si no hay bolas disponibles
    }

    // Método para saber cuántas bolas quedan
    public int bolasRestantes() {
        return bolas.size();
    }
}
