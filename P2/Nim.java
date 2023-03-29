import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class Nim {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numFitxes = numFitxesAleatori(30, 20);
        System.out.println("Juguem amb " + numFitxes + " fitxes.");
        String tirador = quiTiraPrimer();
        String guanyador = "";
        int fitxesRetirades = 0;
        System.out.println("Comença: " + tirador);
       
        while (numFitxes > 0) {
           
            if (tirador.equals("Ordinador")) {
               
                if (numFitxes > 2){
                    fitxesRetirades = (int) (Math.random()*2)+1;
                    System.out.println("L'ordinador agafa " + fitxesRetirades);
                    numFitxes -= fitxesRetirades;
                    
                    if (numFitxes != 1){
                        System.out.println("Queden "+ numFitxes +" fitxes");
                    }
                    
                }
                else if (numFitxes < 0){
                    numFitxes = 0;
                }
                else if (numFitxes == 0) {
                    guanyador = "Jugador";    
                }
                else if (numFitxes == 1){
                    System.out.println("Queda "+ numFitxes +" fitxa");
                    fitxesRetirades = 1;
                    System.out.println("L'ordinador agafa " + fitxesRetirades);
                    guanyador = "Ordinador";
                    numFitxes -= fitxesRetirades;
                    
                }
                else if (numFitxes == 2){
                    fitxesRetirades = (int) (Math.random()*2)+1;
                    System.out.println("L'ordinador agafa " + fitxesRetirades);
                    numFitxes -= fitxesRetirades;   
                    if (fitxesRetirades == 2){
                        System.out.println("Queden "+ numFitxes +" fitxes");
                        guanyador = "Ordinador";
                    }
                                                                              
                    
                }
                
               
                tirador = "Jugador";
               
            }else if (tirador.equals("Jugador")) {
               
                
                if (numFitxes > 2){
                    System.out.println("Quantes fitxes agafes (1 or 2)?");
                    fitxesRetirades = sc.nextInt();
                    while (fitxesRetirades > 2 || fitxesRetirades < 1) {        
                        System.out.println("Has d'escollir un nombre entre 1 i 2!");
                        System.out.println("Quantes fitxes agafes (1 or 2)?");
                        fitxesRetirades = sc.nextInt();
                    
                    }
                    
                    numFitxes -= fitxesRetirades;
                    if (numFitxes != 1){
                        System.out.println("Queden "+ numFitxes +" fitxes");
                    }
                    
                }
                    
                else if (numFitxes < 0){
                    numFitxes = 0;
                }
                else if (numFitxes == 0) {
                    guanyador = "Ordinador";
                }   
                else if (numFitxes == 1){
                    System.out.println("Queda "+ numFitxes +" fitxa");
                    System.out.println("Quantes fitxes agafes (1 or 2)?");
                    fitxesRetirades = sc.nextInt();
                    while (fitxesRetirades != 1){
                        System.out.println("Recorda que no pots retirar més "
                                + "fitxes de les que n'hi ha");
                        fitxesRetirades = sc.nextInt();
                    }
                    numFitxes -= fitxesRetirades;
                    System.out.println("Queden "+ numFitxes +" fitxes");
                    guanyador = "Jugador";
                }
                else if (numFitxes == 2){
                    System.out.println("Quantes fitxes agafes (1 or 2)?");
                    fitxesRetirades = sc.nextInt();
                    if (fitxesRetirades == 2){
                        numFitxes -= fitxesRetirades;
                        System.out.println("Queden "+ numFitxes +" fitxes");
                        guanyador = "Jugador";
                    }
                    else{
                        numFitxes -= fitxesRetirades;
                                                                                 
                    } 
                }
                tirador = "Ordinador";
                
            }
        }
        System.out.println("El guanyador és: " + guanyador);
    

    }
    static String quiTiraPrimer(){
        int x = (int) (Math.random()*2);
        String tirador = "";
        if (x == 0) {
            tirador += "Ordinador";
        }
        if (x == 1) {
            tirador += "Jugador";
        }
        return tirador;
    }
    static int numFitxesAleatori(int max, int min){
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
