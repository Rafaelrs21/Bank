package banco.secure;

import java.util.Scanner;

public class AuthenticateSwitch {
    private final AuthenticateUser autenticaUser;

    public AuthenticateSwitch(AuthenticateUser autenticaUser) {
        this.autenticaUser = autenticaUser;
    }

    public void executarMenuLogin() {
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Registrar");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1 -> autenticaUser.registrarUsuario();
                case 2 -> autenticaUser.logarUsuario();
                case 3 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
