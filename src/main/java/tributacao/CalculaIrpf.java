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
public class CalculaIrpf {
    private double impostoIrpf;
    private final double DESCONTO_DEPENDENTE = 189.59; //taxa de desconto por dependente
    private int numeroDeDependentes;
  
    public CalculaIrpf(int numeroDeDependentes) {
        this.numeroDeDependentes = numeroDeDependentes;
    }
    
    
    public double calculaDescontoPorDependente() {
        return numeroDeDependentes * DESCONTO_DEPENDENTE;
    }
    

    public double calculaInss(double salarioBruto) {
        CalculaInss salario = new CalculaInss();
        double impostoInss = salario.calculaDescontoInss(salarioBruto);
        return impostoInss;
    }
    
    public double calculaIrpf(double salarioBruto) {
        double salarioLiquido, impostoInss;
        impostoInss = calculaInss(salarioBruto);
        salarioLiquido = salarioBruto - impostoInss;
       
        
        if(salarioBruto < 1903.98) impostoIrpf = 0;
        
        else if(salarioBruto >= 1903.99 && salarioBruto <= 2826.65) {
            impostoIrpf = salarioBruto * 0.075;
            if(numeroDeDependentes > 0) impostoIrpf -= calculaDescontoPorDependente();
            salarioLiquido = salarioBruto - impostoIrpf;            
        
        }else if(salarioBruto >= 2826.65 && salarioBruto <= 3751.05) {
            impostoIrpf = salarioBruto * 0.15;
            if(numeroDeDependentes > 0) impostoIrpf -= calculaDescontoPorDependente();
             salarioLiquido = salarioBruto - impostoIrpf;
            
        }else if(salarioBruto >= 3751.05 && salarioBruto <= 4664.68) {
            impostoIrpf = salarioBruto * 0.225;
            if(numeroDeDependentes > 0) impostoIrpf -= calculaDescontoPorDependente();
             salarioLiquido = salarioBruto - impostoIrpf;
             
        } else {
            impostoIrpf = salarioBruto * 0.275;
            if(numeroDeDependentes > 0) impostoIrpf -= calculaDescontoPorDependente();
             salarioLiquido = salarioBruto - impostoIrpf;
        }
         
        return salarioLiquido;        
    }  
    
    public void exibeImpostoDeRenda(double salarioBruto) {
        double salarioLiquido = calculaIrpf(salarioBruto);
        double descontoTotal = impostoIrpf + calculaInss(salarioBruto);
        System.out.println("Imposto IRPF: "+impostoIrpf);
        System.out.println("Desconto total: "+descontoTotal);
        System.out.println("Salário  bruto: "+salarioBruto);
        System.out.println("Valor da contribuição INSS: "+calculaInss(salarioBruto));
        System.out.println("Salário líquido: "+salarioLiquido);
    }
}
