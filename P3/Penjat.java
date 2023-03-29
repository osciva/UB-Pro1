/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
import java.util.*;

public class Penjat{
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        String paraulaEndevinar;
        String [] llistaParaules  = new String[10];
        int numero_intents = 0;
        boolean acertado = false;
        initLlistaDeParaules(llistaParaules);
        paraulaEndevinar = novaPartida(llistaParaules);
        boolean [] lletresEncertades = new boolean[paraulaEndevinar.length()];
        initLletrasEncertades(lletresEncertades, paraulaEndevinar);

        System.out.println("Comen�a el joc!");
        System.out.println(mostraParaula(paraulaEndevinar,lletresEncertades)); 

        while(numero_intents < 6){
            System.out.println("Escull una lletra");
            char c = sc.next().charAt(0);   

            for(int i = 0; i < paraulaEndevinar.length(); i++){
                if(lletraEncertada(paraulaEndevinar, i, c, lletresEncertades)){
                    acertado = true;
                }
            }
            if(acertado == false){
                System.out.println("has fallat");
                acertado = false;
                numero_intents++;
            }
            System.out.println("La paraula es troba acutalment així: ");
            System.out.println(mostraParaula(paraulaEndevinar,lletresEncertades)); 
            
            if(jocAcabat(lletresEncertades) == true){
                System.out.println("Felicitats has guanyat!!!");
                System.exit(1);
            } 
            System.out.println("Et queden " + (6-numero_intents) + " intents" );  
            acertado = false;
        }
        System.out.println("Has comés masses errors, has perdut...");
    }

    static void initLlistaDeParaules(String [] llistaParaules){
        llistaParaules[0] = "universitat";
        llistaParaules[1] = "biblioteca";
        llistaParaules[2] = "daltonisme";
        llistaParaules[3] = "darwinisme";
        llistaParaules[4] = "decoratius";
        llistaParaules[5] = "caciquisme";
        llistaParaules[6] = "bioquimica";
        llistaParaules[7] = "calefactor";
        llistaParaules[8] = "vocabulari";
        llistaParaules[9] = "brutalisme";
    }

    public static String novaPartida(String [] llistaParaules){
        int randomWord = (int) (Math.random()*10+1);
        return llistaParaules[randomWord];
    }

    public static void initLletrasEncertades(boolean [] lletresEncertades,String paraulaEsbrinar){
        for(int i = 0; i < paraulaEsbrinar.length(); i++){     
            lletresEncertades[i] = false;
        }
    }

    public static boolean lletraEncertada (String paraulaEsbrinar, int pos,char c, boolean [] lletresEncertades){    
        if(paraulaEsbrinar.charAt(pos) == c){
            lletresEncertades[pos] = true;
            return true;
        }
        return false;
    }

    public static String mostraParaula(String paraulaEsbrinar,  boolean [] lletresEncertades){
        StringBuffer palabra = new StringBuffer();
        for(int i =0 ; i < lletresEncertades.length; i++){
            if(lletresEncertades[i] == true){
                palabra.append(paraulaEsbrinar.charAt(i));
            }
            else{
                palabra.append("?");
            }
            
        }
        return palabra.toString();
    }


    public static boolean jocAcabat(boolean [] lletresEncertades){
        for(int i = 0; i < lletresEncertades.length ; i++){
            if(lletresEncertades[i] == false){
                return false;
            }
        }
        return true;
    }


 

}