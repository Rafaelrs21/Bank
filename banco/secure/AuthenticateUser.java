package banco.secure;

import banco.entity.User;
import banco.options.MainMenuSwitch;
import banco.repository.UserRepository;
import banco.repository.UserSection;

import java.util.Scanner;

public class AuthenticateUser {
    private final UserRepository repository;
    private final Scanner scanner = new Scanner(System.in);

    public AuthenticateUser(UserRepository repository) {
        this.repository = repository;
    }


    public void registrarUsuario() {
        System.out.print("Enter desired username: ");
        String nome = scanner.nextLine();
        if (repository.buscarUsuario(nome) != null) {
            System.out.println("Username already exists. Please choose another.");
            return;
        }
        System.out.print("Enter password: ");
        String senha = scanner.nextLine();

        User user = new User(nome, senha);
        repository.adicionarUsuario(user);
        System.out.println("Registration successful! " + user);
    }

    public void logarUsuario() {
        System.out.print("Enter username: ");
        String nome = scanner.nextLine();
        System.out.print("Enter password: ");
        String senha = scanner.nextLine();

        if (repository.autenticar(nome, senha)) {
            User user = repository.buscarUsuario(nome);
            UserSection.setUsuarioLogado(user);
            System.out.println("Login successful! Welcome, " + user.getNome() + ".");

            MainMenuSwitch mainMenu = new MainMenuSwitch(repository);
            mainMenu.executarMenuPrincipal();
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}