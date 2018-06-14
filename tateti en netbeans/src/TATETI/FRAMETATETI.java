/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TATETI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MAYFER
 */
public class FRAMETATETI extends javax.swing.JFrame {

    private String ComienzoDelJuego = "X";
    private int xConteo = 0;
    private int oConteo = 0;
    private String[][] Tablero;
    private boolean EstamosJugando;
    private boolean JuegaContraLaComputadora;

    /**
     * Creates new form FRAMETATETI
     */
    public FRAMETATETI() {
        initComponents();
        setSize(650, 600);   // Esto es darle una dimensión fija al frame.
        setLocationRelativeTo(null);    // Esto hace que el frame se centre,
        Tablero = new String[3][3];
        VaciarTablero();
        EstamosJugando = true;
        String[] opciones = {"Humano", "Computadora"};
        int OpcionElegida = JOptionPane.showOptionDialog(null, "Desea jugar contra un humano o una computadora?", "Pregunta Muy Importante", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
        if (OpcionElegida == 1) {
            JuegaContraLaComputadora = true;
        } else {
            JuegaContraLaComputadora = false;
        }
    }

    private void puntajesDelJuego() { // Este es el Metodo que creamos para recolectar y calcular los puntajes de cada jugador.

        puntosPlayerX.setText(String.valueOf(xConteo));
        puntosPlayerO.setText(String.valueOf(oConteo));
    }

    private void ElegiTuJugador() {// Este Método es para elegir el jugador, por X o por O.

        if (ComienzoDelJuego.equalsIgnoreCase("X")) {
            ComienzoDelJuego = "O";
        }// fin del if
        else {
            ComienzoDelJuego = "X";
        }

    } // Fin del Metodo ElegíTuJugador.
    
    // Metodo que determina si es posible hacer una jugada en determinada
    // fila y columna del tablero
    private boolean RealizarJugada(int Fila, int Columna, String Jugador)
    {
        boolean SeRealizoLaJugada = false;
        if (EstamosJugando == true){
            if (Tablero[Fila][Columna] == "") {
                Tablero[Fila][Columna] = Jugador;
                SeRealizoLaJugada = true;
            } else {
                SeRealizoLaJugada = false;
            }
        } else {
            SeRealizoLaJugada = false;
        }
        return SeRealizoLaJugada;
    }
    
    
    private void DibujarBotones() {
        ColorearBoton(jButton1, Tablero[0][0]);
        ColorearBoton(jButton2, Tablero[0][1]);
        ColorearBoton(jButton3, Tablero[0][2]);
        
        ColorearBoton(jButton6, Tablero[1][0]);
        ColorearBoton(jButton7, Tablero[1][1]);
        ColorearBoton(jButton8, Tablero[1][2]);
        
        ColorearBoton(jButton11, Tablero[2][0]);
        ColorearBoton(jButton12, Tablero[2][1]);
        ColorearBoton(jButton13, Tablero[2][2]);
    }
    
    private void ColorearBoton(javax.swing.JButton Boton, String Jugador) {
        Boton.setText(Jugador);
        if (Jugador == "X") {
            Boton.setForeground(Color.ORANGE);
        } else {
            Boton.setForeground(Color.BLUE);
        }
    }
    
    private void VaciarTablero() {
        for (int Fila = 0; Fila < 3; Fila++) {
            for (int Columna = 0; Columna < 3; Columna++) {
                Tablero[Fila][Columna] = "";
            }
        }
    }
    
    private void JugarComputadora() {
        
    }

    private void JugadaGanadora() { // Este Metodo analiza la jugada segun X o O elegido, que resulta ganadora.
        String b1 = jButton1.getText();
        String b2 = jButton2.getText();  // Jugada Ganadora de Primera linea o fila
        String b3 = jButton3.getText();

        String b6 = jButton6.getText();
        String b7 = jButton7.getText(); // Jugada Ganadora de Segunda linea o fila
        String b8 = jButton8.getText();

        String b11 = jButton11.getText();
        String b12 = jButton12.getText(); // Jugada Ganadora de Tercera linea o fila
        String b13 = jButton13.getText();

        if (b1 == "X" && b2 == "X" && b3 == "X") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la X la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            xConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton1.setBackground(Color.YELLOW);
            jButton2.setBackground(Color.YELLOW);
            jButton3.setBackground(Color.YELLOW);
            EstamosJugando = false;
        } // Fin if de la primera jugada Linea 1.

        if (b6 == "X " && b7 == "X" && b8 == "X") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la X la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            xConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton6.setBackground(Color.MAGENTA);
            jButton7.setBackground(Color.MAGENTA);
            jButton8.setBackground(Color.MAGENTA);
            EstamosJugando = false;
        } // Fin If de la segunda jugada Linea 2.

        if (b11 == "X" && b12 == "X" && b13 == "X") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la X  le ha GANADO!! ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            xConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton11.setBackground(Color.WHITE);
            jButton12.setBackground(Color.WHITE);
            jButton13.setBackground(Color.WHITE);
            EstamosJugando = false;

        } // Fin If de la tercera jugada Linea 3.
        if (b1 == "X" && b6 == "X" && b11 == "X") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la X la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            xConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton1.setBackground(Color.ORANGE);
            jButton6.setBackground(Color.ORANGE);
            jButton11.setBackground(Color.ORANGE);
            EstamosJugando = false;

        } // Fin if de la 4 jugada Columna1.
        if (b2 == "X" && b7 == "X" && b12 == "X") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la X la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            xConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton2.setBackground(Color.RED);
            jButton7.setBackground(Color.RED);
            jButton12.setBackground(Color.RED);
            EstamosJugando = false;

        } // Fin if 5 jugada Columna 2.
        if (b3 == "X" && b8 == "X" && b13 == "X") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la X la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            xConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton3.setBackground(Color.GREEN);
            jButton8.setBackground(Color.GREEN);
            jButton13.setBackground(Color.GREEN);
            EstamosJugando = false;

        }// Fin if 6 jugada columna 3.
        if (b1 == "X" && b7 == "X" && b13 == "X") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la X la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            xConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton1.setBackground(Color.CYAN);
            jButton7.setBackground(Color.CYAN);
            jButton13.setBackground(Color.CYAN);
            EstamosJugando = false;

        }// fin if  Jugada de  Diagonal 1.
        if (b11 == "X" && b7 == "X" && b3 == "X") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la X la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            xConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton11.setBackground(Color.BLUE);
            jButton7.setBackground(Color.BLUE);
            jButton3.setBackground(Color.BLUE);
            EstamosJugando = false;

        }// FIN DE LOS IF PARA EL JUGADOR X
        if (b1 == "O" && b2 == "O" && b3 == "O") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la O la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            oConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton1.setBackground(Color.YELLOW);
            jButton2.setBackground(Color.YELLOW);
            jButton3.setBackground(Color.YELLOW);
            EstamosJugando = false;
        } // Fin if de la primera jugada Linea 1.

        if (b6 == "O " && b7 == "O" && b8 == "O") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la O la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            oConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton6.setBackground(Color.MAGENTA);
            jButton7.setBackground(Color.MAGENTA);
            jButton8.setBackground(Color.MAGENTA);
            EstamosJugando = false;

        } // Fin If de la segunda jugada Linea 2.

        if (b11 == "O" && b12 == "O" && b13 == "O") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la O  le ha GANADO!! ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            oConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton11.setBackground(Color.WHITE);
            jButton12.setBackground(Color.WHITE);
            jButton13.setBackground(Color.WHITE);
            EstamosJugando = false;

        } // Fin If de la tercera jugada Linea 3.
        if (b1 == "O" && b6 == "O" && b11 == "O") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la O la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            oConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton1.setBackground(Color.ORANGE);
            jButton6.setBackground(Color.ORANGE);
            jButton11.setBackground(Color.ORANGE);
            EstamosJugando = false;

        } // Fin if de la 4 jugada Columna1.
        if (b2 == "O" && b7 == "O" && b12 == "O") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la O la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            oConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton2.setBackground(Color.RED);
            jButton7.setBackground(Color.RED);
            jButton12.setBackground(Color.RED);
            EstamosJugando = false;

        } // Fin if 5 jugada Columna 2.
        if (b3 == "O" && b8 == "O" && b13 == "O") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la O la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            oConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton3.setBackground(Color.GREEN);
            jButton8.setBackground(Color.GREEN);
            jButton13.setBackground(Color.GREEN);
            EstamosJugando = false;

        }// Fin if 6 jugada columna 3.
        if (b1 == "O" && b7 == "O" && b13 == "O") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la O la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            oConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton1.setBackground(Color.CYAN);
            jButton7.setBackground(Color.CYAN);
            jButton13.setBackground(Color.CYAN);
            EstamosJugando = false;

        }// fin if  Jugada de  Diagonal 1.
        if (b11 == "O" && b7 == "O" && b3 == "O") {
            JOptionPane.showMessageDialog(this, "El Jugador que elegio la O la tiene Clara. ", "My Tateti", JOptionPane.INFORMATION_MESSAGE);
            oConteo++;
            puntajesDelJuego(); // LLamo al metodo puntajesDelJuego para darle valor a xConteo.
            jButton11.setBackground(Color.BLUE);
            jButton7.setBackground(Color.BLUE);
            jButton3.setBackground(Color.BLUE);
            EstamosJugando = false;
        }

    } // Fin del Metodo Jugadas Ganadoras
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        puntosPlayerX = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        puntosPlayerO = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        ResetButton = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MayTateti");
        setBackground(java.awt.Color.pink);

        jPanel2.setBackground(new java.awt.Color(204, 0, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 204), 2));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Snap ITC", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("My Ta Te Ti");
        jPanel2.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 51, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.GridLayout(3, 5, 2, 2));

        jPanel3.setBackground(new java.awt.Color(255, 51, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(new java.awt.Color(255, 0, 153));
        jButton1.setFont(new java.awt.Font("Snap ITC", 0, 48)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 51, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jButton2.setBackground(new java.awt.Color(255, 0, 153));
        jButton2.setFont(new java.awt.Font("Snap ITC", 0, 48)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 51, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton3.setBackground(new java.awt.Color(255, 0, 153));
        jButton3.setFont(new java.awt.Font("Snap ITC", 0, 48)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 51, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Snap ITC", 1, 18)); // NOI18N
        jLabel2.setText("Player X:");
        jPanel6.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 51, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new java.awt.BorderLayout());

        puntosPlayerX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(puntosPlayerX, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 51, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton6.setBackground(new java.awt.Color(255, 0, 153));
        jButton6.setFont(new java.awt.Font("Snap ITC", 0, 48)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 51, 102));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jButton7.setBackground(new java.awt.Color(255, 0, 153));
        jButton7.setFont(new java.awt.Font("Snap ITC", 0, 48)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 51, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jButton8.setBackground(new java.awt.Color(255, 0, 153));
        jButton8.setFont(new java.awt.Font("Snap ITC", 0, 48)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 51, 102));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Snap ITC", 1, 18)); // NOI18N
        jLabel4.setText("Player O:");
        jPanel11.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 51, 102));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setLayout(new java.awt.BorderLayout());

        puntosPlayerO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel12.add(puntosPlayerO, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 51, 102));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jButton11.setBackground(new java.awt.Color(255, 0, 153));
        jButton11.setFont(new java.awt.Font("Snap ITC", 0, 48)); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton11, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 51, 102));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jButton12.setBackground(new java.awt.Color(255, 0, 153));
        jButton12.setFont(new java.awt.Font("Snap ITC", 0, 48)); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton12, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 51, 102));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jButton13.setBackground(new java.awt.Color(255, 0, 153));
        jButton13.setFont(new java.awt.Font("Snap ITC", 0, 48)); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton13, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 51, 102));
        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setLayout(new java.awt.BorderLayout());

        ResetButton.setBackground(new java.awt.Color(255, 0, 153));
        ResetButton.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        ResetButton.setText("Otra Vez");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        jPanel16.add(ResetButton, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 51, 102));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setLayout(new java.awt.BorderLayout());

        ExitButton.setBackground(new java.awt.Color(255, 0, 153));
        ExitButton.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        ExitButton.setText("Me Cansé");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        jPanel17.add(ExitButton, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel17);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean SePudoJugar = RealizarJugada(0, 0, ComienzoDelJuego);
        if (SePudoJugar == true){
            DibujarBotones();
            ElegiTuJugador();
            JugadaGanadora();
            if (JuegaContraLaComputadora == true) {
                
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean SePudoJugar = RealizarJugada(0, 1, ComienzoDelJuego);
        if (SePudoJugar == true){
            DibujarBotones();
            ElegiTuJugador();
            JugadaGanadora();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private JFrame frame;
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        frame = new JFrame("Me Cansé!");
        if (JOptionPane.showConfirmDialog(frame, " ¿Querés dejar el Juego?", " My Ta Te Ti", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_NO_OPTION) {
            System.exit(0); // Finalizamos con la Partida o el Juego.

        }
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean SePudoJugar = RealizarJugada(0, 2, ComienzoDelJuego);
        if (SePudoJugar == true){
            DibujarBotones();
            ElegiTuJugador();
            JugadaGanadora();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        boolean SePudoJugar = RealizarJugada(1, 0, ComienzoDelJuego);
        if (SePudoJugar == true){
            DibujarBotones();
            ElegiTuJugador();
            JugadaGanadora();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        boolean SePudoJugar = RealizarJugada(1, 1, ComienzoDelJuego);
        if (SePudoJugar == true){
            DibujarBotones();
            ElegiTuJugador();
            JugadaGanadora();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        boolean SePudoJugar = RealizarJugada(1, 2, ComienzoDelJuego);
        if (SePudoJugar == true){
            DibujarBotones();
            ElegiTuJugador();
            JugadaGanadora();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        boolean SePudoJugar = RealizarJugada(2, 0, ComienzoDelJuego);
        if (SePudoJugar == true){
            DibujarBotones();
            ElegiTuJugador();
            JugadaGanadora();
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        boolean SePudoJugar = RealizarJugada(2, 1, ComienzoDelJuego);
        if (SePudoJugar == true){
            DibujarBotones();
            ElegiTuJugador();
            JugadaGanadora();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        boolean SePudoJugar = RealizarJugada(2, 2, ComienzoDelJuego);
        if (SePudoJugar == true){
            DibujarBotones();
            ElegiTuJugador();
            JugadaGanadora();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        jButton1.setText(null);
        jButton2.setText(null); // Esto Hace que todo el contenido de los botones sea iguale a cero otra vez, o vacio.
        jButton3.setText(null);

        jButton6.setText(null);
        jButton7.setText(null);
        jButton8.setText(null);

        jButton11.setText(null);
        jButton12.setText(null);
        jButton13.setText(null);

        jButton1.setBackground(Color.pink);
        jButton2.setBackground(Color.pink);
        jButton3.setBackground(Color.pink);
        jButton7.setBackground(Color.pink);
        jButton8.setBackground(Color.pink);
        jButton6.setBackground(Color.pink);
        jButton11.setBackground(Color.pink);
        jButton12.setBackground(Color.pink);
        jButton13.setBackground(Color.pink);

        ComienzoDelJuego = "X";
        EstamosJugando = true;
        VaciarTablero();
        String[] opciones = {"Humano", "Computadora"};
        int OpcionElegida = JOptionPane.showOptionDialog(null, "Desea jugar contra un humano o una computadora?", "Pregunta Muy Importante", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
        if (OpcionElegida == 1) {
            JuegaContraLaComputadora = true;
        } else {
            JuegaContraLaComputadora = false;
        }
    }//GEN-LAST:event_ResetButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FRAMETATETI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRAMETATETI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRAMETATETI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRAMETATETI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRAMETATETI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel puntosPlayerO;
    private javax.swing.JLabel puntosPlayerX;
    // End of variables declaration//GEN-END:variables
}
