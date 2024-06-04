import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Operacao {
    ADICIONAR, LISTAR, SAIR
}

class Heroi {
    private final String nome;
    private final String superpower;
    private int idade;

    public Heroi(String nome, String superpoder, int idade) {
        this.nome = nome;
        this.superpower = superpoder;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Heroi heroi = (Heroi) obj;
        return nome.equalsIgnoreCase(heroi.nome);
    }

    @Override
    public int hashCode() {
        return nome.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Herói: " + nome + ", Superpoder: " + superpower + ", Idade: " + idade;
    }
}

public class DevHeroiAplicacao {
    private final List<Heroi> herois = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            System.out.println("Escolha uma operação: ADICIONAR, LISTAR, SAIR");
            String opcao = scanner.nextLine().toUpperCase();
            Operacao operacao;
            try {
                operacao = Operacao.valueOf(opcao);
            } catch (IllegalArgumentException e) {
                System.out.println("Operação inválida!");
                continue;
            }

            switch (operacao) {
                case ADICIONAR -> adicionarHeroi();
                case LISTAR -> listarHerois();
                case SAIR -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Operação inválida!");
            }
        }
    }

    private void adicionarHeroi() {
        System.out.println("Nome do Herói:");
        String nome = scanner.nextLine();
        System.out.println("Superpoder do Herói:");
        String superpoder = scanner.nextLine();
        System.out.println("Idade do Herói:");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline restante

        Heroi heroi = new Heroi(nome, superpoder, idade);
        if (herois.contains(heroi)) {
            System.out.println("Herói já cadastrado. Não é possível adicionar heróis duplicados.");
        } else {
            herois.add(heroi);
            System.out.println("Herói adicionado com sucesso!");
        }
    }

    private void listarHerois() {
        if (herois.isEmpty()) {
            System.out.println("Nenhum herói cadastrado!");
            return;
        }
        System.out.println("Lista de Heróis:");
        for (Heroi heroi : herois) {
            System.out.println(heroi);
        }
    }

    public static void main(String[] args) {
        new DevHeroiAplicacao().iniciar();
    }

    public void executar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executar'");
    }
}
