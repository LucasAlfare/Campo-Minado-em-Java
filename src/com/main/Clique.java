package com.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Clique extends MouseAdapter {

    private Elemento elemento;

    Clique(Elemento elemento) {
        this.elemento = elemento;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        if (Constantes.primeiroClique){
            Constantes.primeiroClique = false;
            elemento.definirIcone(0);
            TelaJogo.jogo.iniciarBombas(elemento.x, elemento.y);
            TelaJogo.jogo.revelarElementos(elemento.x, elemento.y, new boolean[13][10]);
        } else {
            if (elemento.isBomba){
                TelaJogo.jogo.revelarBombas();
            } else {
                int x = elemento.x;
                int y = elemento.y;
                elemento.definirIcone(TelaJogo.jogo.numBombasAdjacentes(x, y));
                TelaJogo.jogo.revelarElementos(x, y, new boolean[13][10]);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        //System.out.println(elemento.x + ", " + elemento.y);
    }
}
