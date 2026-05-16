package ao.universidade.poo.banco;

public class ContaCorrente extends Conta {
    
    private double limite;
    
    public ContaCorrente(String numero, double saldoInicial, double limite) {
        super(numero, saldoInicial);
        if (limite < 0) {
            throw new IllegalArgumentException("Limite não pode ser negativo");
        }
        this.limite = limite;
    }
    
    public double getLimite() { 
        return limite; 
    }
    
    public void setLimite(double limite) {
        if (limite < 0) {
            throw new IllegalArgumentException("Limite não pode ser negativo");
        }
        this.limite = limite;
    }
    
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        if (saldo + limite < valor) {
            throw new SaldoInsuficienteException(
                "Saldo + limite insuficiente: saldo=" + saldo + 
                ", limite=" + limite + ", valor=" + valor
            );
        }
        saldo -= valor;
    }
    
    @Override
    public String toString() {
        return String.format("ContaCorrente %s - Saldo: %.2f - Limite: %.2f", 
            numero, saldo, limite);
    }
}
