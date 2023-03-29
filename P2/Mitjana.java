import java.util.Scanner;
/**
 *
 * @author oscar
 */
public class Mitjana{
    public static void main(String []arg){
        
        float mitjana;
        
        mitjana = mitjanaParells();
        
        

        
        
        System.out.println("la mitjana dels nombres parells és de: " + mitjana);
                
    }

    static float mitjanaParells(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Dona'm una seqüència d'enters "
                + "( introdueix -1 per finalitzar): ");
        int num = sc.nextInt();
        float mitjana = num;
        float acumuladorParells = 0;
        float comptaNumeros = 0;
         
        while(num != -1){
            if (num%2 == 0){
                acumuladorParells += num;
                mitjana += num / comptaNumeros;
                comptaNumeros++;
            }
            
            num = sc.nextInt();
        }
        mitjana = (acumuladorParells) / (comptaNumeros);    
        return mitjana;
    }
}