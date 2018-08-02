package com.main;

import javax.swing.*;

import java.awt.*;

import static com.main.Constantes.*;

public class TelaJogo extends JFrame{

    public Elemento[][] elementos;
    public static Jogo jogo;

    public TelaJogo() {
        iniciarGui();
        iniciarGrade(MODO_FACIL);

        jogo = new Jogo(elementos);
    }

    private void iniciarGui(){
        setSize(FACIL_L_TAMANHO, FACIL_A_TAMANHO);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new GridLayout(13, 10, 0, 0));
    }

    private void iniciarGrade(int modoDeJogo){
        switch (modoDeJogo){
            case MODO_FACIL:
                elementos = new Elemento[13][10];

                for (int x = 0; x < elementos.length; x++) {
                    for (int y = 0; y < elementos[x].length; y++) {
                        if (elementos[x][y] == null){
                            elementos[x][y] = new Elemento(x, y);
                            elementos[x][y].addMouseListener(new Clique(elementos[x][y]));
                            add(elementos[x][y]);
                        }
                    }
                }
        }
    }
}
