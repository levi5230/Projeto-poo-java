package ao.universidade.poo.banco;

public class ContaPoupanca extends Conta {
    
    private double taxaRendimento;
    
    public ContaPoupanca(String numero, double saldoInicial, double taxaRendimento) {
        super(numero, saldoInicial);
        if (taxaRendimento < 0) {
            throw new IllegalArgumentException("Taxa de rendimento não pode ser negativa");
        }
        this.taxaRendimento = taxaRendimento;
    }
    
    public double getTaxaRendimento() { 
        return taxaRendimento; 
    }
    
    public void setTaxaRendimento(double taxaRendimento) {
        if (taxaRendimento < 0) {
            throw new IllegalArgumentException("Taxa de rendimento não pode ser negativa");
        }
        this.taxaRendimento = taxaRendimento;
    }
    
    public void aplicarRendimento() {
        saldo += saldo * taxaRendimento;
    }
    
    @Override
    public String toString() {
        return String.format("ContaPoupanca %s - Saldo: %.2f - Taxa: %.4f", 
            numero, saldo, taxaRendimento);
    }
}
