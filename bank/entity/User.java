package banco.entity;

public class User {
    private static int contador = 1;
    private Integer Id;
    private String nome;
    private String senha;
    private double saldo;
    private double emprestimo;
    private double investimento;

    public User() {}


    public User(String nome, String senha) {
        Id = contador++;
        this.nome = nome;
        this.senha = senha;
        this.saldo = 0.0;
        this.emprestimo = 0.0;
        this.investimento= 0.0;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(double emprestimo) {
        this.emprestimo = emprestimo;
    }

    public double getInvestimento() {
        return investimento;
    }

    public void setInvestimento(double investimento) {
        this.investimento = investimento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", emprestimo=" + emprestimo +
                ", investimento=" + investimento +
                '}';
    }
}