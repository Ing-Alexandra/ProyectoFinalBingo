package com.mycompany.bingo;

import java.util.ArrayList;

public class Bingo {

    private int tipoDeJuego;
    private Patron patronGanador;
    private int numJugadores;
    private ArrayList<Jugador> jugadores;
    private Tombola tombola;
    private PanelHistorial historial;
    private boolean juegoInicio;
    private Bola ultimaBola;

    public Bingo(int numJugadores, int cartaGanadora) {
        patronGanador = new Patron(cartaGanadora);
        patronGanador.imprimirPatron();
        this.numJugadores = numJugadores;
        jugadores = new ArrayList<>();
        tombola = new Tombola();
        historial = new PanelHistorial();
        juegoInicio = false;

        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(new Jugador(i));
            generarCartasYEntregar(i);
        }
    }

    public boolean validarVictoria() {
        // Obtener el patrón de victoria

        boolean huboGanador = false;
        boolean[][] patronDeVictoria = patronGanador.getPatronDeVictoria();

        // Iterar sobre los jugadores
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = jugadores.get(i);
            Bola[][] bolas = jugador.getCarta().getBolas();

            boolean victoria = true; // Asumir que el jugador ha ganado, validar después

            // Validar cada posición del patrón
            for (int fila = 0; fila < patronDeVictoria.length; fila++) {
                for (int columna = 0; columna < patronDeVictoria[fila].length; columna++) {
                    if (patronDeVictoria[fila][columna]) { // Solo validar las posiciones del patrón
                        if (!bolas[fila][columna].isMarcado()) { // Si no está marcada, no es victoria
                            victoria = false;
                            break; // Salir del bucle, no es necesario seguir verificando
                        }
                    }
                }
                if (!victoria) {
                    break; // Salir del bucle exterior si ya se detectó que no ganó
                }
            }

            if (victoria) {
                huboGanador = true;
                jugador.marcarVictoria();
                juegoInicio = false;
                System.out.println("El jugador " + (jugador.getId() + 1) + " ha ganado!");

            }
        }

        return huboGanador; // Ningún jugador cumplió con el patrón de victoria
    }

    public void generarCartasYEntregar(int id) {
        if (!juegoInicio) {
            Jugador jugador = jugadores.get(id);
            jugador.tomarCarta();
        }
    }

    public void marcarCartas() {

        for (int i = 0; i < numJugadores; i++) {
            jugadores.get(i).buscarBola(ultimaBola);
        }
        historial.buscarBola(ultimaBola);

    }

    public int getJugadorQueGano() {
        int indiceGanador = -1;
        int cantidadGanadores = 0;

        // Recorremos la lista de jugadores
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getGano()) {
                cantidadGanadores++;
                indiceGanador = i; // Guardamos el índice del ganador
                // Si ya hay más de un ganador, no necesitamos seguir
                if (cantidadGanadores > 1) {
                    System.out.println("Empate");
                    return 0; // Empate, más de un jugador ganó
                }
            }
        }

        // Si hay un solo ganador, devolvemos su índice, de lo contrario -1 (nadie ganó)
        return cantidadGanadores == 1 ? (indiceGanador+1) : -1;
    }

    public Bola sacarBola() {
        ultimaBola = tombola.sacarBolaAleatoria();
        return ultimaBola;
    }

    public int getTipoDeJuego() {
        return tipoDeJuego;
    }

    public Patron getPatronGanador() {
        return patronGanador;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Tombola getTombola() {
        return tombola;
    }

    public PanelHistorial getHistorial() {
        return historial;
    }

    public boolean isJuegoInicio() {
        return juegoInicio;
    }

    public Bola getUltimaBola() {
        return ultimaBola;
    }

    public void setTipoDeJuego(int tipoDeJuego) {
        this.tipoDeJuego = tipoDeJuego;
    }

    public void setPatronGanador(Patron patronGanador) {
        this.patronGanador = patronGanador;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setTombola(Tombola tombola) {
        this.tombola = tombola;
    }

    public void setHistorial(PanelHistorial historial) {
        this.historial = historial;
    }

    public void setJuegoInicio(boolean juegoInicio) {
        this.juegoInicio = juegoInicio;
    }

    public void setUltimaBola(Bola ultimaBola) {
        this.ultimaBola = ultimaBola;
    }

}
