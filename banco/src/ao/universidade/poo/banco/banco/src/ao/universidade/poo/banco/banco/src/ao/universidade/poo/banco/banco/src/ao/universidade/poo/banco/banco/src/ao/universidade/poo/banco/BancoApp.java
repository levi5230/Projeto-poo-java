package ao.universidade.poo.banco;

import java.util.ArrayList;
import java.util.List;

public class BancoApp {
    
    public static void main(String[] args) {
        
        ContaCorrente cc1 = new ContaCorrente("001", 500.0, 300.0);
        ContaPoupanca cp1 = new ContaPoupanca("002", 1000.0, 0.01);
        
        List<Conta> contas = new ArrayList<>();
        contas.add(cc1);
        contas.add(cp1);
        
        System.out.println("Estado inicial das contas:");
        imprimirContas(contas);
        System.out.println();
        
        System.out.println("Depositando 200 em todas as contas:");
        for (Conta c : contas) {
            c.depositar(200);
        }
        imprimirContas(contas);
        System.out.println();
        
        try {
            System.out.println("Tentando sacar 1000 da conta corrente (deve usar limite):");
            cc1.sacar(1000);
            System.out.println("Saque efetuado.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        imprimirContas(contas);
        System.out.println();
        
        try {
            System.out.println("Tentando sacar 5000 da poupança (deve falhar):");
            cp1.sacar(5000);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        imprimirContas(contas);
        System.out.println();
        
        try {
            System.out.println("Transferindo 300 da poupança para a conta corrente:");
            cp1.transferir(cc1, 300);
            System.out.println("Transferência efetuada.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        imprimirContas(contas);
        System.out.println();
        
        for (Conta c : contas) {
            if (c instanceof ContaPoupanca) {
                ContaPoupanca cp = (ContaPoupanca) c;
                cp.aplicarRendimento();
                System.out.println("Rendimento aplicado em " + cp.getNumero());
            }
        }
        imprimirContas(contas);
    }
    
    private static void imprimirContas(List<Conta> contas) {
        for (Conta c : contas) {
            System.out.println(c);
        }
    }
}
