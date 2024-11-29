package com.mycompany.bingo;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Gui extends javax.swing.JFrame {

    private boolean inicio;
    private Bingo juego;

    public Gui() {
        initComponents();
        iniciarJuego();
    }

    public void iniciarJuego() {
        inicio = false;
        int numeroIngresado = obtenerNumero();
        if (numeroIngresado != -1) {
            System.out.println("Número ingresado: " + numeroIngresado);
        }

        juego = new Bingo(2, numeroIngresado);

        ArrayList<Jugador> jugadores = juego.getJugadores();

        tablero.setLayout(new GridLayout(1, 1));
        tablero.add(juego.getHistorial());

        jugador1.setLayout(new GridLayout(1, 1));
        jugador1.add(jugadores.get(0));

        jugador2.setLayout(new GridLayout(1, 1));
        jugador2.add(jugadores.get(1));

    }

    public int obtenerNumero() {
        // Mostrar el cuadro de diálogo para ingresar un número
        String input = JOptionPane.showInputDialog(null, "Ingrese un número del 1 al 38:", "Ingreso de Número", JOptionPane.QUESTION_MESSAGE);

        // Validar la entrada
        try {
            int numero = Integer.parseInt(input); // convertimos el valor ingresado a número

            // Comprobar si el número está dentro del rango
            if (numero >= 1 && numero <= 38) {
                return numero; // Retornar el número válido
            } else {
                // Si el número no está dentro del rango, mostramos un mensaje de error
                JOptionPane.showMessageDialog(null, "El número debe estar entre 1 y 38.", "Error", JOptionPane.ERROR_MESSAGE);
                return -1; // Retornamos -1 para indicar un error
            }
        } catch (NumberFormatException e) {
            // Si el usuario no ingresa un número válido
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Retornamos -1 si la entrada no es válida
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablero = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jugador1 = new javax.swing.JPanel();
        jugador2 = new javax.swing.JPanel();
        ultimaBola = new javax.swing.JLabel();
        restJugador1 = new javax.swing.JButton();
        restJugador2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jButton1.setText("SacarBola");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jugador1Layout = new javax.swing.GroupLayout(jugador1);
        jugador1.setLayout(jugador1Layout);
        jugador1Layout.setHorizontalGroup(
            jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jugador1Layout.setVerticalGroup(
            jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jugador2Layout = new javax.swing.GroupLayout(jugador2);
        jugador2.setLayout(jugador2Layout);
        jugador2Layout.setHorizontalGroup(
            jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        jugador2Layout.setVerticalGroup(
            jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        ultimaBola.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ultimaBola.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ultimaBola.setText("Ultima Bola");

        restJugador1.setText("Tomar nueva carta");
        restJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restJugador1ActionPerformed(evt);
            }
        });

        restJugador2.setText("Tomar nueva carta");
        restJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restJugador2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ultimaBola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addComponent(tablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ultimaBola, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(restJugador2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(restJugador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!inicio) {
            inicio = true;
            juego.setJuegoInicio(true);
        }

        if (juego.isJuegoInicio()) {
            Bola sacarBola = juego.sacarBola();
            ultimaBola.setText("Última: \n" + sacarBola.getText());
            juego.marcarCartas();
            boolean huboVictoria = juego.validarVictoria();
            
            if (huboVictoria) {
                System.out.println("El juego acabó");

                int jugadorQueGano = juego.getJugadorQueGano();

                if (jugadorQueGano == 0) {
                    // Empate
                    ultimaBola.setText("Empate");
                } else {
                    // Ganador único
                    ultimaBola.setText("Ganó Jugador " + jugadorQueGano);
                }
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void restJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restJugador1ActionPerformed
        juego.generarCartasYEntregar(0);
    }//GEN-LAST:event_restJugador1ActionPerformed

    private void restJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restJugador2ActionPerformed
        juego.generarCartasYEntregar(1);
    }//GEN-LAST:event_restJugador2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jugador1;
    private javax.swing.JPanel jugador2;
    private javax.swing.JButton restJugador1;
    private javax.swing.JButton restJugador2;
    private javax.swing.JPanel tablero;
    private javax.swing.JLabel ultimaBola;
    // End of variables declaration//GEN-END:variables
}
