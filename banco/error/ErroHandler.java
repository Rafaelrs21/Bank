package banco.error;

public class ErroHandler{
    public static void saldoInsuficiente() {
        System.err.println("Saldo insuficiente!");
    }

    public static void emprestimoInvalido() {
        System.err.println("Impossível realizar empréstimo!");
    }

    public static void investimentoInvalido() {
        System.err.println("Impossível realizar investimento!");
    }
}
