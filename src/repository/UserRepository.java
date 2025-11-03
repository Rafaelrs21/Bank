package src.repository;

import src.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<String, User> usuarios = new HashMap<>();

    public boolean adicionarUsuario(User user) {
        if (usuarios.containsKey(user.getNome())) {
            return false;
        } else {
            usuarios.put(user.getNome(), user);
            return true;
        }
    }

    public User buscarUsuario(String nome) {
        return usuarios.get(nome);
    }

    public boolean autenticar(String nome, String senha){
        User user = usuarios.get(nome);
        return user != null && user.getSenha().equals(senha);
    }
}