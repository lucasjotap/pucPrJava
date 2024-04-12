package com.datastructuresandalgorithms.pucprjavaproject;

/**
 *
 * @author lucas
 */
public class Financiamento {
    // Classe Financiamento 
    private final double valorImovel;
    private final int prazoFinanciamento;
    private final double taxaDeJurosAnual;
    
    Financiamento(double valorImovel, 
            int prazoFinanciamento, 
            double taxaDeJurosAnual){
      // Construtor
      this.valorImovel = valorImovel;
      this.prazoFinanciamento = prazoFinanciamento;
      this.taxaDeJurosAnual = taxaDeJurosAnual;
    }
    
    
    public double getValorImovel(){ // Retorna o valor do imovél.
        return valorImovel;
    }
    
    public int getPrazoFinanciamento(){ // Retorna o prazo do financiamento.
        return prazoFinanciamento;
    }
        
    public double getTaxaDeJurosAnual(){ // Retorna o taxa de juros.
        return taxaDeJurosAnual;
    }
    
    public double getpagamentoMensal(){ // Retorna o pagamento mensal.
        return (this.valorImovel / this.prazoFinanciamento * 12) * (1 + (taxaDeJurosAnual/12));
    }
    
    public double getTotalDoPagamento(){ // Retorna o total do pagamento mensal.
        return (getpagamentoMensal() * prazoFinanciamento * 12);
    }
    
    public void printAll(){
        System.out.println(this.getValorImovel());
        System.out.print(getTotalDoPagamento());
    }
    
}
