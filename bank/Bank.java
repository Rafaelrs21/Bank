package banco;

import banco.repository.UserRepository;
import banco.secure.AuthenticateSwitch;
import banco.secure.AuthenticateUser;

public class Bank {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        AuthenticateUser autenticaUser = new AuthenticateUser(repository);
        AuthenticateSwitch menu = new AuthenticateSwitch(autenticaUser);

        menu.executarMenuLogin();
    }
}