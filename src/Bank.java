package src;

import src.repository.UserRepository;
import src.secure.AuthenticateSwitch;
import src.secure.AuthenticateUser;

public class Bank {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        AuthenticateUser autenticaUser = new AuthenticateUser(repository);
        AuthenticateSwitch menu = new AuthenticateSwitch(autenticaUser);

        menu.executarMenuLogin();
    }
}