/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salario.salario;

/**
 *
 * @author jenniffer
 */
public class CalculaInss {
    private double salario;
    private double desconto;
    
    public CalculaInss(double salario) {
        this.salario = salario; 
    }
    
    public double calculaDescontoInss()  {
        if(salario <= 1751.81) {
            desconto = salario * 0.08;
        }
        
        //De 2.919,73 até 5.839,45*	11,00%	
        else if(salario > 1751.81 && salario <= 2919.72) {
            desconto = salario * 0.09;       
        }
        
        else if(salario > 2919.72 && salario <= 5839.45) {
            desconto = salario * 0.11; 
        }
        else 
            desconto = 642.34;
        
        salario -= desconto; 
    
        return salario;
    
    }

    public double getSalario() {
        return salario;
    }

    public double getDesconto() {
        return desconto;
    }
    
    
    
    public static void main(String[] args) {
        CalculaInss salario = new CalculaInss(1000);
        salario.calculaDescontoInss();
        System.out.println("desconto: "+salario.getDesconto());
        System.out.println("salario: "+salario.getSalario());
    }
    
    
}
