import java.util.*;
public class MinRectangle {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int x1, x2, x3, x4, x5, x6, y1, y2, y3, y4, y5, y6;
        System.out.println("Dona'm dos punts (x,y) per a crear un rectangle");
        System.out.println("x = ");
        x1 = entrada.nextInt();
        System.out.println("y = ");
        y1 = entrada.nextInt();
        
        System.out.println("Dona'm uns altres dos punts (x,y) per a crear el rectangle");
        System.out.println("x = ");
        x2 = entrada.nextInt();
        System.out.println("y = ");
        y2 = entrada.nextInt();
        
        System.out.println("Dona'm dos punts (x,y) per a crear un segon rectangle");
        System.out.println("x = ");
        x3 = entrada.nextInt();
        System.out.println("y = ");
        y3 = entrada.nextInt();
        
        System.out.println("Dona'm uns altres dos punts (x,y) per a crear el segon rectangle");
        System.out.println("x = ");
        x4 = entrada.nextInt();
        System.out.println("y = ");
        y4 = entrada.nextInt();
        
        if (((((x2 > x4) && (y2 > y4)) || ((x2 < x4) && (y2 < y4))))
                || (((x1 < x3) && (y1 < y3)) || ((x1 > x3) && (y1 > y3)))){
            System.out.println("No intersequen, no hi ha rectangle mÃ­nim");
        }else{
                if (x1 > x3){
                    x5 = x1;
                }else{
                    x5 = x3;               
                }
                if (y1 > y3){
                    y5 = y1;
                }else{
                    y5 = y3;
                }
                if (x2 < x4){
                    x6 = x2;
                }else{
                    x6 = x4;
                }
                if (y2 < y4){
                    y6 = y2;
                }else{
                    y6 = y4;
                }
                System.out.println(" El rectangle mí­nim que els conté és : " + 
                        " ( " + x5 + " , " + y5 + " ) " + " ( " + x6 + " , " + 
                        y6 + " ) ");
                }
    }
}