import java.util.Scanner;

public class HeroiCLI {

    // Método para exibir o menu da aplicação
    public void exibirMenu() {
        System.out.println("===================================");
        System.out.println("         MENU DE OPERAÇÕES         ");
        System.out.println("===================================");
        System.out.println("1. Listar Heróis");
        System.out.println("2. Adicionar Herói");
        System.out.println("3. Remover Herói");
        System.out.println("4. Atualizar Herói");
        System.out.println("5. Sair");
        System.out.println("===================================");
        System.out.print("Escolha uma opção: ");
    }

    // Método para solicitar e retornar a opção escolhida pelo usuário
    public int obterOpcao() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao = -1;
            boolean opcaoValida = false;

            while (!opcaoValida) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    if (opcao >= 1 && opcao <= 5) {
                        opcaoValida = true;
                    } else {
                        System.out.print("Opção inválida. Por favor, escolha uma opção entre 1 e 5: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Entrada inválida. Por favor, insira um número entre 1 e 5: ");
                }
            }

            return opcao;
        }
    }
}
