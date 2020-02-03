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
    private double salarioTotal;
    private double salarioDescontado;
    private double desconto;
    
    public CalculaInss(double salario) {
        this.salarioTotal = salario; 
    }
    
    public double calculaDescontoInss()  {
        if(salarioTotal <= 1751.81) {
            desconto = salarioTotal * 0.08;
        }
        
        //De 2.919,73 até 5.839,45*	11,00%	
        else if(salarioTotal > 1751.81 && salarioTotal <= 2919.72) {
            desconto = salarioTotal * 0.09;       
        }
        
        else if(salarioTotal > 2919.72 && salarioTotal <= 5839.45) {
            desconto = salarioTotal * 0.11; 
        }
        else 
            desconto = 642.34;
        
        salarioDescontado -= desconto; 
    
        return salarioDescontado;
    
    }


    public double getSalarioTotal() {
        return salarioTotal;
    }

    public double getSalarioDescontado() {
        return salarioDescontado;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }

    public void setSalarioDescontado(double salarioDescontado) {
        this.salarioDescontado = salarioDescontado;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
    public void mostraTaxas() {
        System.out.println("Salário bruto: "+salarioTotal);
        System.out.println("Valor da contribuição INSS: "+desconto);
    
    }

    
    
    
}
