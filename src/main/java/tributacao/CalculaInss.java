/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributacao;
/**
 *
 * @author jenniffer
 */
public class CalculaInss {
    private double impostoInss;
    
    
    public double calculaDescontoInss(double salarioBruto)  {
        if(salarioBruto <= 1751.81) {
            impostoInss = salarioBruto * 0.08;
        }
        
        else if(salarioBruto > 1751.81 && salarioBruto <= 2919.72) {
            impostoInss = salarioBruto * 0.09;       
        }
        
        else if(salarioBruto > 2919.72 && salarioBruto <= 5839.45) {
            impostoInss = salarioBruto * 0.11; 
        }
        else 
            impostoInss = 642.34;
        
        
        return impostoInss;
    
    }



    
    public void mostraTaxas(double salarioBruto) {
        System.out.println("Salário bruto: "+salarioBruto);
        System.out.println("Valor da contribuição INSS: "+impostoInss);
    
    }

    
    
    
}
