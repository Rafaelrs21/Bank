package banco.options;

import banco.entity.User;
import banco.repository.UserRepository;
import banco.repository.UserSection;
import banco.service.UserService;

import java.util.Scanner;

public class MainMenuSwitch {
    private final UserRepository repository;

    public MainMenuSwitch(UserRepository repository) {
        this.repository = repository;
    }
    public void executarMenuPrincipal() {
        User user = UserSection.getUsuarioLogado();

        if (user != null) {
            System.out.println("User: " + user.getNome());
            System.out.println("Balance: " + user.getSaldo());
        }else {
            System.out.println("User not found!" );
        }

        UserService userService = new UserService(repository);


        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Sake");
            System.out.println("3. Transfer");
            System.out.println("4. Loan");
            System.out.println("5. Investment");
            System.out.println("6. To go out");
            System.out.print("Choose an option: ");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1 ->{
                    System.out.println("Enter the deposit amount");
                    double valorDeposito = entrada.nextDouble();
                    userService.deposito(valorDeposito);
                }
                case 2 -> {
                    System.out.println("Enter the withdrawal amount");
                    double valorSaque = entrada.nextDouble();
                    userService.saque(valorSaque);
                }
                case 3 -> {
                    System.out.println("Enter sender name");
                    String nome = entrada.nextLine();
                    System.out.println("Enter the transfer amount");
                    double valorSaque = entrada.nextDouble();
                    userService.transferencia(nome,valorSaque);
                }
                case 4 ->{
                    System.out.println("Enter the loan amount");
                    double valorEmprestimo = entrada.nextDouble();
                    userService.emprestimo(valorEmprestimo);
                }
                case 5 ->{
                    System.out.println("Enter the Investment Amount");
                    double valorInvestimento = entrada.nextDouble();
                    System.out.println("Enter the type of investment: ");
                    System.out.println("1- CDB: ");
                    System.out.println("2- Savings: ");
                    int tipo = entrada.nextInt();
                    userService.investimento(valorInvestimento, tipo);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}