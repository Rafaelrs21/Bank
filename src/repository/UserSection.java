package src.repository;

import src.entity.User;

public class UserSection {
    private static User userLogado;

    public static void setUsuarioLogado(User user){
        UserSection.userLogado = user;
    }

    public static User getUsuarioLogado(){
        return userLogado;
    }

    public static void limparSessao(){
        userLogado = null;
    }
}
