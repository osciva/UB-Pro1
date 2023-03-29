import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class FlotaCorrecteBatallaNaval {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        while(!exit){
            int num_vaixells = input(sc, 0, 10, "Escriba un numero de barcos:\n");
            exit = num_vaixells == 0;
            if(!exit){
                int[] mida = new int[num_vaixells];

                for (int i = 0; i < num_vaixells; i++) {
                    mida[i] = input(sc, 1, 20, "Escriba la medida del barco numero " + (i+1) + ":\n");
                }

                int tamany_tauler = input(sc, 1, 20, "Escriba el tamaño del tablero: \n");
                int[][] matriu = new int[tamany_tauler][tamany_tauler];

                System.out.println("Escriba los valores del tablero:");
                for (int i = 0; i < tamany_tauler; i++) {
                    for (int j = 0; j < tamany_tauler; j++) {
                        matriu[i][j] = input(sc, 0, 1, "");
                    }
                    System.out.println();
                }
                for (int i = 0; i < tamany_tauler; i++) {
                    for (int j = 0; j < tamany_tauler; j++) {
                        System.out.print(matriu[i][j]);
                    }
                    System.out.println();
                }
                int counter = 0, temp, n_v = 0;
                int[] vaixells = new int[num_vaixells];
                boolean incorrecte = false;
                String positions = posicions(matriu);
                for (int i = 0; i < tamany_tauler && !incorrecte; i++) {
                    for (int j = 0; j < tamany_tauler && !incorrecte; j++) {
                        if (matriu[i][j] == 1) {
                            if (n_v < num_vaixells) {
                                temp = vaixell(matriu, i, j);
                                if (temp == -1) incorrecte = true;
                                vaixells[n_v] = temp;
                                n_v++;
                            } else {
                                incorrecte = true;
                            }
                        }
                    }
                }
                Arrays.sort(mida);
                Arrays.sort(vaixells);
                for(int i = 0; i < mida.length; i++){
                    if(mida[i] != vaixells[i]) incorrecte = true;
                }
                if(incorrecte){
                    System.out.println("El tauler NO és correcte");
                }else{
                    System.out.println("El tauler SI és correcte");
                }
                System.out.println(positions + "\n");
            }

        }
        System.out.println("S'acaba el joc");

    }

    public static int input(Scanner sc, int min, int max, String msg){
        System.out.print(msg);
        int in = sc.nextInt();
        while (in > max || in < min){
            System.out.println("Numero no valido:");
            in = sc.nextInt();
        }
        return in;
    }

    public static boolean comprobarUno(int[][] matriu, int pos1, int pos2){
        int[][] matriutemp = new int[matriu.length+2][matriu.length+2];
        for(int i = 1; i < matriutemp.length - 1; i++){
            for(int j = 1; j < matriutemp.length -1; j++){
                matriutemp[i][j] = matriu[i-1][j-1];
            }
        }

        if(matriutemp[(pos1+1)-1][(pos2+1)-1] == 1){
            return true;
        }else if(matriutemp[(pos1+1)-1][(pos2+1)+1] == 1){
            return true;
        }else if(matriutemp[(pos1+1)+1][(pos2+1)+1] == 1){
            return true;
        }else if(matriutemp[(pos1+1)+1][(pos2+1)-1] == 1){
            return true;
        }else{
            return false;
        }
    }

    public static int vaixell(int[][] matriu, int pos1, int pos2){
        boolean sentit = false; // false -> horizontal, true -> vertical
        if(pos1+1 < matriu.length) {
            if (matriu[pos1 + 1][pos2] == 1) {
                sentit = true;
            }
        }
        if(pos2 + 1 < matriu.length){
            if (matriu[pos1][pos2 + 1] == 1){
                sentit = false;
            }
        }
        int counter = 0;
        if(sentit){ // Vertical
            for(int i = pos1; i < matriu.length; i++){
                if(comprobarUno(matriu, i, pos2)) return -1;
                if(matriu[i][pos2] == 1) counter ++;
                else return counter;
                matriu[i][pos2] = 0;
            }
        }else{ // Horizontal
            for(int i = pos2; i < matriu.length; i++){
                if(comprobarUno(matriu, pos1, i)) return -1;
                if(matriu[pos1][i] == 1) counter ++;
                else return counter;
                matriu[pos1][i] = 0;
            }
        }
        return counter;
    }

    public static String posicions(int[][] matriu){
        String st = "";
        for(int i = 0; i < matriu.length; i++){
            for (int j = 0; j < matriu.length; j++){
                if(matriu[i][j] == 1){
                    st += "(" + i + "," + j + ")";
                }
            }
        }
        return st;
    }
}
