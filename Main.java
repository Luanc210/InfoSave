package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();

        // Escolher idioma
        System.out.print("Escolha o idioma (pt/en): ");
        String idioma = sc.nextLine();
        Mensagens.setIdioma(idioma);

        int opcao;
        do {
            System.out.println("\n1. " + Mensagens.getMensagem("menu.add_user"));
            System.out.println("2. " + Mensagens.getMensagem("menu.list_users"));
            System.out.println("3. " + Mensagens.getMensagem("menu.remove_user"));
            System.out.println("4. " + Mensagens.getMensagem("menu.remove_all_users"));
            System.out.println("5. " + Mensagens.getMensagem("menu.export_pdf"));
            System.out.println("6. " + Mensagens.getMensagem("menu.exit"));
            System.out.print(Mensagens.getMensagem("menu.choose_option") + " ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                	System.out.print(Mensagens.getMensagem("user.name") + ": ");
                    String nome = sc.nextLine();
                    System.out.print(Mensagens.getMensagem("user.age") + ": ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    userManager.adicionarUser(new User(nome, idade));
                    break;

                case 2:
                    userManager.listarUsers();
                    break;

                case 3:
                    System.out.print("Nome do usuário a remover: ");
                    String nomeRemover = sc.nextLine();
                    userManager.removerUser(nomeRemover);
                    break;

                case 4:
                    userManager.removerTodos();
                    break;

                case 5:
                    userManager.exportarParaPDF("usuarios.pdf");
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println(Mensagens.getMensagem("menu.invalid_option"));
            }
        } while (opcao != 6);

        sc.close();
    }
}
