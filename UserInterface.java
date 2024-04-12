package com.datastructuresandalgorithms.pucprjavaproject;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class UserInterface {
    //
    double imovel;
    int financiamento;
    double juros;
    double valorImovel;
    int prazoFinanciamento;
    double taxaDeJurosAnual;
    boolean criarFinanciamentos = true;
    int increment = 0;    
    Scanner getInputFromUser = new Scanner(System.in);
    
    
    
    public double pegarValorImovel() {        
        boolean checkInput = true;
        while (checkInput) {
        System.out.println("Por favor insira o valor do imóvel: " + "\n");
        try {
            
            String imovel = this.getInputFromUser.nextLine();
            if (!imovel.matches("\\d+")){
                throw new IllegalArgumentException("Entrada invalída de dados.");
            }
            
            double value = Double.parseDouble(imovel);
            if (value < 0){
                throw new IllegalArgumentException("Entrada invalída de dados.");
            }
            
            checkInput = false;
            this.valorImovel = value;
            return value;
            
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
      }
        return 0; // Retorno padrão, embora inacessível devido ao while loop.
    }
    
    
    public int pegarPrazoFinanciamento() {
        boolean checkInput = true;
        while (checkInput) {       
        System.out.println("Por favor insira o valor financiamento: " + "\n");
        try {
            
            String prazoFinanc = this.getInputFromUser.nextLine();
            if (!prazoFinanc.matches("\\d+")){
                throw new IllegalArgumentException("Entrada invalída de dados.");
            }
            
            int value = Integer.parseInt(prazoFinanc);
            if (value < 0){
                throw new IllegalArgumentException("Entrada invalída de dados.");
            }
            
            checkInput = false;
            this.prazoFinanciamento = value;
            return value;
        } catch(IllegalArgumentException e){
            return 0;
        }
      }
        return 0; // Retorno padrão, embora inacessível devido ao while loop.
    }
    
    
    public double pegarTaxaDeJuros() {
        boolean checkInput = true;
        while (checkInput) { 
        System.out.println("Por favor insira o valor da taxa de juros: " + "\n");
        try {
            String taxaDeJuros = this.getInputFromUser.nextLine();
            if (!taxaDeJuros.matches("\\d+")){ // Checa se o input é numérico.
                // Excessão para entrada de dados invaĺida.
                throw new IllegalArgumentException("Entrada invalída de dados.");
            }
            
            double value = Double.parseDouble(taxaDeJuros);
            if (value < 0){ // Checa se o input é maior que 0.
                // Excessão para entrada de dados invaĺida.
                throw new IllegalArgumentException("Entrada invalída de dados.");
            }
            this.taxaDeJurosAnual = value;
            return value;
        } catch(IllegalArgumentException e){
            return 0;
            }        
        }
        return 0;
    }

    
    public ArrayList criarArrayDeFinanciamentos(){
        ArrayList<Financiamento> arrayDeFinanciamentos = new ArrayList();
            while (criarFinanciamentos){
                Financiamento fin = new Financiamento(
                        this.pegarPrazoFinanciamento(), 
                                    (int) this.pegarTaxaDeJuros(),
                        this.pegarValorImovel());
               
                arrayDeFinanciamentos.add(fin);
                   
                try {
                System.out.println("Gostaria de inserir novos financiamentos, digite sim ou nao: ");
                String userInput = getInputFromUser.nextLine();
                
                if ("nao".equals(userInput)){
                    criarFinanciamentos = false;
                    return arrayDeFinanciamentos;
                }
                }
                catch (IllegalArgumentException e){
                    System.out.print(e.getMessage());
            }                       
        }
        return arrayDeFinanciamentos;
    }
    
    
    public void printArrayDeFinanciamenetos(){
        ArrayList<Financiamento> arrayDeFinanciamentos = this.criarArrayDeFinanciamentos();
        for (Financiamento f : arrayDeFinanciamentos){
            System.out.printf("\nFinanciamento %d", increment);
            System.out.printf("; Valor do financiamento: %f", f.getTotalDoPagamento());
            System.out.printf("; Valor do imovél: %f \n", f.getValorImovel());
            increment++;
        }
    }    
}
