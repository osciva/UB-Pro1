import java.util.*;

public class Concat{
    
    public static void main(String [] args){
        
        StringBuffer s1 = new StringBuffer(), s2 = new StringBuffer();
        Scanner teclat = new Scanner (System.in);
        
        System.out.println("Cadena 1:");
        String cad1 = teclat.nextLine();
        System.out.println("Cadena 2:");
        String cad2 = teclat.nextLine();
        
        s1.append(cad1);
        s1.append(cad2);
        
        System.out.print("La cadena concatenada es: ");
        System.out.println(s1);
        
        
    }
}
