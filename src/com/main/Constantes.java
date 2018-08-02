package com.main;

import javax.swing.*;
import java.util.Objects;

public class Constantes {

    public static final int TAMANHO_QUADRADO = 16;

    public static final int MODO_FACIL = 0;

    public static final int FACIL_L_TAMANHO = (10 * (TAMANHO_QUADRADO));
    public static final int FACIL_A_TAMANHO = (13 * (TAMANHO_QUADRADO));

    public static final int FACIL_NUM_MINAS = 10;

    public static final ImageIcon[] ICONES = {
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/vazio0.png"))),
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/vazio1.png"))),
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/vazio2.png"))),
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/vazio3.png"))),
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/vazio4.png"))),
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/vazio5.png"))),
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/vazio6.png"))),
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/vazio7.png"))),
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/vazio8.png"))),
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/normal.png"))), //9
            new ImageIcon(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("sprites/bomba.png")))
    };

    public static boolean primeiroClique = true;
}
