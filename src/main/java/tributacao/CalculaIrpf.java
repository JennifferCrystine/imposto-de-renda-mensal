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
    private CalculaInss impostoInss;
    private double impostoIrpf; 
    private double descontoIrpf;
    private byte numeroDependentes; //número de dependentes do contribuidor
    private double descontoDependentes; //desconto efetivo de acordo com o número de dependentes
    private final double DESCONTO_DEPENDENTE = 189.59; //taxa de desconto por dependente
    
    public CalculaIrpf(byte dependentes, double salario) {
        this.impostoInss.setSalarioTotal(salario);       
        double aux = this.impostoInss.calculaDescontoInss();
        this.impostoInss.setDesconto(aux);
        this.impostoInss.calculaDescontoInss();
        this.numeroDependentes = dependentes;
    
    }
    
    public double calculaIrpf() {
        if(impostoInss.getSalarioTotal() < 1903.98) impostoIrpf = 0;
        
        else if(impostoInss.getSalarioTotal() >= 1903.99 && impostoInss.getSalarioTotal() <= 2826.65) {
            impostoIrpf = impostoInss.getSalarioTotal() * 0.075;
            if(numeroDependentes > 0) { 
                descontoDependentes = numeroDependentes * DESCONTO_DEPENDENTE;
                impostoIrpf -= descontoDependentes;
            }
            descontoIrpf = impostoInss.getSalarioTotal() - impostoIrpf;            
        
        }else if(impostoInss.getSalarioTotal() >= 2826.65 && impostoInss.getSalarioTotal() <= 3751.05) {
            impostoIrpf = impostoInss.getSalarioTotal() * 0.15;
            if(numeroDependentes > 0){ 
                descontoDependentes = numeroDependentes * DESCONTO_DEPENDENTE;
                impostoIrpf -= descontoDependentes;
            }
            descontoIrpf = impostoInss.getSalarioTotal() - impostoIrpf;          
        
        }else if(impostoInss.getSalarioTotal() >= 3751.05 && impostoInss.getSalarioTotal() <= 4664.68) {
            impostoIrpf = impostoInss.getSalarioTotal() * 0.225;
            if(numeroDependentes > 0){ 
                descontoDependentes = numeroDependentes * DESCONTO_DEPENDENTE;
                impostoIrpf -= descontoDependentes;
            }
            descontoIrpf = impostoInss.getSalarioTotal() - impostoIrpf; 
            
        }else {
            impostoIrpf = impostoInss.getSalarioTotal() * 0.275;
            if(numeroDependentes > 0){ 
                descontoDependentes = numeroDependentes * DESCONTO_DEPENDENTE;
                impostoIrpf -= descontoDependentes;
            }
            descontoIrpf = impostoInss.getSalarioTotal() - impostoIrpf;             

        }
        
        impostoInss.setSalarioTotal(descontoIrpf);
        return impostoInss.getSalarioDescontado();
    }

    public CalculaInss getSalario() {
        return impostoInss;
    }

    public double getImpostoIrpf() {
        return impostoIrpf;
    }

    public byte getNumeroDependentes() {
        return numeroDependentes;
    }

    public double getDescontoDependentes() {
        return descontoDependentes;
    }

    public double getDESCONTO_DEPENDENTE() {
        return DESCONTO_DEPENDENTE;
    }
  
    public double descontoTotal() {
        return impostoIrpf + impostoInss.getDesconto();
    }
    
    public void exibeSalarioLiquido() {
        impostoInss.mostraTaxas();
        System.out.println("salario bruto: "+impostoInss.getSalarioTotal());
        System.out.println("IRPF: "+impostoIrpf);
        System.out.println("Desconto total: "+descontoTotal());
        System.out.println("Salário final: "+impostoInss.getSalarioDescontado());
    }
}
