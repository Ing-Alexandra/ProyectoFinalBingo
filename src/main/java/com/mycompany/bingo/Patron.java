package com.mycompany.bingo;

public class Patron {

    private boolean[][] patronDeVictoria;

    public Patron(int tipoDePatron) {
        patronDeVictoria = new boolean[5][5];
        this.patronDeVictoria = generarPatronGanador(tipoDePatron);
    }

    public boolean[][] generarPatronGanador(int id) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                patronDeVictoria[i][j] = false;
            }
        }

        switch (id) {
            case 1 -> generarLineaVertical(0);
            case 2 -> generarLineaVertical(1);
            case 3 -> generarLineaVertical(2);
            case 4 -> generarLineaVertical(3);
            case 5 -> generarLineaVertical(4);
            case 6 -> generarDiagonalPrincipal();
            case 7 -> generarLineaHorizontal(0);
            case 8 -> generarLineaHorizontal(1);
            case 9 -> generarLineaHorizontal(2);
            case 10 -> generarLineaHorizontal(3);
            case 11 -> generarLineaHorizontal(4);
            case 12 -> generarDiagonalInvertida();
            case 13 -> generarRectangulo(0, 0, 3, 2);
            case 14 -> generarRectangulo(1, 0, 3, 2);
            case 15 -> generarRectangulo(2, 0, 3, 2);
            case 16 -> generarRectangulo(0, 1, 3, 2);
            case 17 -> generarRectangulo(1, 1, 3, 2);
            case 18 -> generarRectangulo(2, 1, 3, 2);
            case 19 -> generarRectangulo(0, 2, 3, 2);
            case 20 -> generarRectangulo(1, 2, 3, 2);
            case 21 -> generarRectangulo(2, 2, 3, 2);
            case 22 -> generarRectangulo(0, 3, 3, 2);
            case 23 -> generarRectangulo(1, 3, 3, 2);
            case 24 -> generarRectangulo(2, 3, 3, 2);
            case 25 -> generarRectangulo(0, 0, 2, 3);
            case 26 -> generarRectangulo(0, 1, 2, 3);
            case 27 -> generarRectangulo(0, 2, 2, 3);
            case 28 -> generarRectangulo(1, 0, 2, 3);
            case 29 -> generarRectangulo(1, 1, 2, 3);
            case 30 -> generarRectangulo(1, 2, 2, 3);
            case 31 -> generarRectangulo(2, 0, 2, 3);
            case 32 -> generarRectangulo(2, 1, 2, 3);
            case 33 -> generarRectangulo(2, 2, 2, 3);
            case 34 -> generarRectangulo(3, 0, 2, 3);
            case 35 -> generarRectangulo(3, 1, 2, 3);
            case 36 -> generarRectangulo(3, 2, 2, 3);
            case 37 -> {
                patronDeVictoria[0][2] = true;
                patronDeVictoria[1][1] = true;
                patronDeVictoria[1][3] = true;
                patronDeVictoria[2][0] = true;
                patronDeVictoria[2][4] = true;
                patronDeVictoria[3][1] = true;
                patronDeVictoria[3][3] = true;
                patronDeVictoria[4][2] = true;
            }
            case 38 -> {
                patronDeVictoria[1][1] = true;
                patronDeVictoria[1][2] = true;
                patronDeVictoria[1][3] = true;
                patronDeVictoria[2][1] = true;
                patronDeVictoria[2][3] = true;
                patronDeVictoria[3][1] = true;
                patronDeVictoria[3][2] = true;
                patronDeVictoria[3][3] = true;
            }
            default -> throw new IllegalArgumentException("ID de patrón inválido: " + id + ". El ID debe estar entre 1 y 38.");
        }

        return patronDeVictoria;
    }

    public boolean[][] getPatronDeVictoria() {
        return patronDeVictoria;
    }

    private void generarLineaVertical(int columna) {
        for (int i = 0; i < 5; i++) {
            patronDeVictoria[i][columna] = true;
        }
    }

    private void generarLineaHorizontal(int fila) {
        for (int j = 0; j < 5; j++) {
            patronDeVictoria[fila][j] = true;
        }
    }

    private void generarDiagonalPrincipal() {
        for (int i = 0; i < 5; i++) {
            patronDeVictoria[i][i] = true;
        }
    }

    private void generarDiagonalInvertida() {
        for (int i = 0; i < 5; i++) {
            patronDeVictoria[i][4 - i] = true;
        }
    }

    public void generarRectangulo(int x, int y, int alto, int ancho) {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (x + i < 5 && y + j < 5) {
                    patronDeVictoria[x + i][y + j] = true;
                }
            }
        }
    }

    public void imprimirPatron() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(patronDeVictoria[i][j] ? "X " : "- ");
            }
            System.out.println();
        }
    }
}
