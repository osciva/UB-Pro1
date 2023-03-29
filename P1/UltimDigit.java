import java.util.*;
public class UltimDigit{
    public static void main(String [] args){
    Scanner teclado = new Scanner(System.in);
    int num, ultimdigit;
    System.out.println("Dona'm un enter:");
    num = teclado.nextInt();
    ultimdigit = num % 10;
    System.out.println("L'últim dígit de " + num + " es " + ultimdigit);
 }
}