package ao.universidade.poo.banco;

public class Conta {
    
    protected String numero;
    protected double saldo;
    
    public Conta(String numero, double saldoInicial) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número da conta inválido");
        }
        this.numero = numero;
        this.saldo = saldoInicial;
    }
    
    public String getNumero() { 
        return numero; 
    }
    
    public double getSaldo() { 
        return saldo; 
    }
    
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        saldo += valor;
    }
    
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        if (saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente: saldo=" + saldo + ", valor=" + valor);
        }
        saldo -= valor;
    }
    
    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException {
        if (destino == null) {
            throw new IllegalArgumentException("Conta destino nula");
        }
        sacar(valor);
        destino.depositar(valor);
    }
    
    @Override
    public String toString() {
        return String.format("Conta %s - Saldo: %.2f", numero, saldo);
    }
}
