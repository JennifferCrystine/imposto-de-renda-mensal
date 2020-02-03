/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributacao;
import java.util.Scanner;

/**
 *
 * @author jenniffer
 */
public class Interface {
    Scanner teclado = new Scanner(System.in);
    
        public static double leiaDouble(String frase) {
        System.out.println(frase);
        Scanner teclado = new Scanner(System.in);
        double valor = teclado.nextInt();
        return valor;       
    
    }
    
        
    public static int leiaInteiro(String frase) {
        System.out.println(frase);
        Scanner teclado = new Scanner(System.in);
        int valor = teclado.nextInt();
        return valor;       
    
    }
    
    
      public static byte leiaByte(String frase) {
        System.out.println(frase);
        Scanner teclado = new Scanner(System.in);
        byte valor = teclado.nextByte();
        return valor;       
    
    }
     
    public static float leiaFloat(String frase) {
        System.out.println(frase);
        Scanner teclado = new Scanner(System.in);
        float valor = teclado.nextFloat();
        return valor;  
    }
     
     public static String leiaString(String frase) {
        System.out.println(frase);
        Scanner teclado = new Scanner(System.in);
        String opcao = teclado.next();
        return opcao; 
    } 
     
    public static char leiaChar(String frase) {
        System.out.println(frase);
        Scanner teclado = new Scanner(System.in);
        char opcao = teclado.next().charAt(0);
        return opcao;  
    } 

    
    public static void main(String[] args) {
        CalculaIrpf salario = new CalculaIrpf(leiaByte("Informe o número de dependentes: ")
        ,leiaDouble("Informe seu salário: "));
        salario.calculaIrpf();
        salario.exibeSalarioLiquido();
    }
    
}
