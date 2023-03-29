import java.util.*;
// author: Marcos Palomino Vivar
// En el tablero el simbolo "*" indica que no hay ninguna ficha puesta

public class TresEnRatlla {
    private static Scanner sc; 

    public static void main(String[] args) {
        String[][] tablero = new String[3][3];
        int contador =0 ;
        System.out.println("Bienvenidos al tres en ralla !");
        inicializarTablero(tablero);
        mostrarTablero(tablero);
        int quienJuega = 0;

        if(quienEmpieza() == 1){
            System.out.println("Empieza el ordenador !");
            quienJuega = 1;
        }
        else{
            System.out.println("Empiezas tú! ");
            quienJuega = 0;
        }


        while(juegoFinalizado(tablero) == false){
            ponerFicha(tablero, quienJuega);
            System.out.println("El tablero se encuentra así");
            mostrarTablero(tablero);

            for(int i = 0; i < tablero.length ; i++){
                for(int j = 0; j < tablero.length ; j++){
                    if(tablero[i][j] == "U" || tablero[i][j] == "O"){
                        contador++;
                    }
                }   
            }
            if(contador == 9){
                System.out.println("El juego ha terminado en empate!");
                break;
            }
            if(quienJuega == 1){
                quienJuega = 0;
            }
            else{
                quienJuega = 1;
            }  
         
            contador = 0;
        }
    }

    static int quienEmpieza(){
        return (int) (Math.random()*2+1);
    }

    static void inicializarTablero(String[][] tablero){
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0; j < tablero.length ; j++){
                tablero[i][j] = "*";
            }   
        }      
    }

    static void mostrarTablero(String[][] tablero){
        for(int i = 0; i < tablero.length ; i++){
            System.out.println("");
            for(int j = 0; j < tablero.length ; j++){
                System.out.print(tablero[i][j]);
            }   
        }
        System.out.println("");
    }

    static void ponerFicha(String[][] tablero, int quienJuega){
        sc = new Scanner(System.in);
        int posicionY; 
        int posicionX;

        // Si juega el ordenador
        if(quienJuega == 1){
            posicionY = (int) (Math.random()*3+1);
            posicionX = (int) (Math.random()*3+1);

            while(tablero[posicionY-1][posicionX-1].equals("U") || tablero[posicionY-1][posicionX-1].equals("O")){
                posicionY = (int) (Math.random()*3+1);
                posicionX = (int) (Math.random()*3+1);
            }
            tablero[posicionY-1][posicionX-1] = "O";
            System.out.println("El ordenador ha puesta una ficha en la posicion: "+ posicionY + " " + posicionX);
        }

        // En caso que te toque a ti
        else{
            System.out.println("Escoge la posicion donde quieres poner una ficha");
            posicionY = sc.nextInt();
            posicionX = sc.nextInt();

            while( (posicionX > 3 || posicionX < 0) || (posicionY > 3 || posicionY < 0) ||tablero[posicionY-1][posicionX-1].equals("U") || tablero[posicionY-1][posicionX-1].equals("O") ){
                System.out.println("Esta posición es incorrecta, vuelve a escoger");
                posicionY = sc.nextInt();
                posicionX = sc.nextInt();
            }
            tablero[posicionY-1][posicionX-1] = "U";
            System.out.println("El usuario ha puesta una ficha en la posicion: "+ posicionY + " " + posicionX);
            
        }
    }


    static boolean juegoFinalizado(String[][] tablero){
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0; j < tablero.length ; j++){
                if(i == 1 && j == 1){
                    if(tablero[i][j].equals("U") && tablero[i+1][j+1].equals("U") && tablero[i-1][j-1].equals("U")){
                        System.out.println("Ha guanyat l'usuari");
                        return true;
                    }
                    if(tablero[i][j].equals("O") && tablero[i+1][j+1].equals("O") && tablero[i-1][j-1].equals("O")){
                        System.out.println("Ha guanyat l'ordinador");
                        return true;
                    }
                }
                if(j == 1){
                    if(tablero[i][j].equals("U") && tablero[i][j+1].equals("U") && tablero[i][j-1].equals("U")){
                        System.out.println("Ha guanyat l'usuari");
                        return true;
                    }
                    if(tablero[i][j].equals("O") && tablero[i][j+1].equals("O") && tablero[i][j-1].equals("O")){
                        System.out.println("Ha guanyat l'ordinador");
                        return true;
                    }
                }
                if(i == 1){
                    if(tablero[i][j].equals("U") && tablero[i+1][j].equals("U") && tablero[i-1][j].equals("U")){
                        System.out.println("Ha guanyat l'usuari");
                        return true;
                    }
                    if(tablero[i][j].equals("O") && tablero[i+1][j].equals("O") && tablero[i-1][j].equals("O")){
                        System.out.println("Ha guanyat l'ordinador");
                        return true;
                    }
                }
            }   
        }   
        return false;   
    }


    
}
