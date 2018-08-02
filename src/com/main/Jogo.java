package com.main;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {

    private Elemento[][] elementos;

    public Jogo(Elemento[][] elementos) {
        this.elementos = elementos;
    }

    //TODO: às vezes põe bomba no lugar do primeiro clique
    public void iniciarBombas(int primeiroX, int primeiroY){
        Random r = new Random();
        ArrayList<int[]> coordenadasBombas = new ArrayList<>();

        for (int i = 0; i < Constantes.FACIL_NUM_MINAS; i++) {
            int x, y;

            do {
                x = r.nextInt(13 - 1);
                y = r.nextInt(10 - 1);
            } while (jaFoiSorteado(coordenadasBombas, x, y) && (x == primeiroX && y == primeiroY));

            coordenadasBombas.add(new int[]{x, y});
            elementos[x][y].setBomba(true);
        }
    }

    public void revelarBombas(){
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos[i].length; j++) {
                if (elementos[i][j].isBomba){
                    elementos[i][j].definirIcone(10);
                }
            }
        }
    }

    public void revelarElementos(int x, int y, boolean[][] visitados) {
        if (x >= 0 && y >= 0 && x < 13 && y < 10) {
            if (visitados[x][y]) {
                return;
            }

            elementos[x][y].definirIcone(numBombasAdjacentes(x, y));

            if (numBombasAdjacentes(x, y) > 0) {
                return;
            }

            visitados[x][y] = true;

            revelarElementos(x - 1, y, visitados);
            revelarElementos(x + 1, y, visitados);
            revelarElementos(x, y - 1, visitados);
            revelarElementos(x, y + 1, visitados);
        }
    }

    /*
    x-1,y-1    x-1,y      x-1,y+1

    x  ,y-1    (x,y)      x  ,y+1

    x+1,y-1    x+1,y      x+1,y+1
     */
    public int numBombasAdjacentes(int x, int y){
        int numBombas = 0;

        if (isBombaEm(x-1,y-1)) numBombas++;
        if (isBombaEm(x-1,y)) numBombas++;
        if (isBombaEm(x-1,y+1)) numBombas++;
        if (isBombaEm(x  ,y-1)) numBombas++;
        if (isBombaEm(x  ,y+1)) numBombas++;
        if (isBombaEm(x+1,y-1)) numBombas++;
        if (isBombaEm(x+1,y)) numBombas++;
        if (isBombaEm(x+1,y+1)) numBombas++;

        return numBombas;
    }

    public boolean isBombaEm(int x, int y) {
        return x >= 0 && y >= 0 && x < 13 && y < 10 && elementos[x][y].isBomba;
    }

    private boolean jaFoiSorteado(ArrayList<int[]> fonte, int x, int y){
        for (int[] par : fonte){
            if (par[0] == x && par[1] == y){
                return true;
            }
        }
        return false;
    }
}
