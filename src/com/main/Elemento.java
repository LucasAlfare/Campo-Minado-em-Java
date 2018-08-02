package com.main;

import javax.swing.*;

public class Elemento extends JLabel {

    public ImageIcon icone;
    public int x;
    public int y;
    public boolean isBomba = false;

    public Elemento(int x, int y){
        definirIcone(9); //imagem "normal"
        this.x = x;
        this.y = y;
    }

    public void definirIcone(int valor){
        icone = Constantes.ICONES[valor];
        this.setIcon(icone);
    }

    public void setBomba(boolean bomba) {
        isBomba = bomba;
    }
}
