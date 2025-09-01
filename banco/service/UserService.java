package banco.service;

import banco.entity.User;
import banco.error.ErroHandler;
import banco.interfaces.InvestimentInterface;
import banco.repository.UserRepository;
import banco.repository.UserSection;


public class UserService extends ErroHandler {
    private final User user;
    private final UserRepository usuarioRepository;

    public UserService(UserRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.user = UserSection.getUsuarioLogado();
    }

    public void deposito(double quantidade){
        if (quantidade <= 0){
            ErroHandler.saldoInsuficiente();
            return;
        }
        user.setSaldo(user.getSaldo() + quantidade);
        System.out.println("Deposito realizado: " + user);
    }

    public void saque(double quantidade){
        if (quantidade <= 0){
            ErroHandler.saldoInsuficiente();
            return;
        }

        if (quantidade > user.getSaldo()){
            ErroHandler.saldoInsuficiente();
            return;
        }
        user.setSaldo(user.getSaldo() - quantidade);
        System.out.println("Saque realizado: " + user);
    }

    public void emprestimo(double quantidade){
        if (quantidade <= 0){
            ErroHandler.emprestimoInvalido();
            return;
        }
        if(user.getSaldo() < quantidade){
            ErroHandler.emprestimoInvalido();
            return;
        }

        user.setSaldo(user.getSaldo() - quantidade);
        user.setEmprestimo(user.getEmprestimo() + quantidade);
        System.out.println("Emprestimo realizado: " + user);
    }

    public void investimento(double quantidade, int tipo){
        if (quantidade <= 0 || quantidade < 100){
            ErroHandler.saldoInsuficiente();
            return;
        }
        if(user.getSaldo() < quantidade){
            ErroHandler.investimentoInvalido();
            return;
        }

        user.setSaldo(user.getSaldo() - quantidade);

        InvestimentInterface investimentInterface = null;


        if (tipo == 1) {
            investimentInterface = new CDBService();
        } else if (tipo == 2) {
            investimentInterface = new SavingsService();
        }

        if (investimentInterface == null) {
            System.out.println("Tipo de investimento inválido!");
            return;
        }

        Double rendimento = investimentInterface.investimento(quantidade);
        user.setInvestimento(user.getInvestimento() + quantidade + rendimento);

        System.out.println("investimento realizado: " + user);
    }

    public void transferencia(String nomeDestinatario, double quantidade){
        if(user.getNome() == null){
            System.out.println("Nenhum usuário logado para realizar transferência.");
            return;
        }

        if (quantidade <= 0) {
            ErroHandler.investimentoInvalido();
            return;
        }

        if (user.getSaldo() < quantidade){
            ErroHandler.investimentoInvalido();
            return;
        }

        User destinatario = usuarioRepository.buscarUsuario(nomeDestinatario);
        if (destinatario == null){
            System.out.println("Destinatario inexistente.");
            return;
        }

        user.setSaldo(user.getSaldo() - quantidade);
        destinatario.setSaldo(destinatario.getSaldo() + quantidade);

        System.out.println("Transferência realizada com sucesso!");
        System.out.println("Remetente: " + user.getNome() + ", saldo: " + user.getSaldo());
        System.out.println("Destinatário: " + destinatario.getNome() + ", saldo: " + destinatario.getSaldo());

    }
}