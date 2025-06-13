package main;

import java.io.*;
import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;
    private static final String FILE_NAME = "users.txt";

    public UserManager() {
        users = new ArrayList<>();
        loadFromFile();
    }

    public void adicionarUser(User user) {
        users.add(user);
        saveToFile();
    }

    public void listarUsers() {
        if (users.isEmpty()) {
            System.out.println(Mensagens.getMensagem("nenhum_usuario_cadastrado"));
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public void removerUser(String nome) {
        boolean removido = users.removeIf(u -> u.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println(Mensagens.getMensagem("usuario_removido"));
        } else {
            System.out.println(Mensagens.getMensagem("usuario_nao_encontrado"));
        }
        saveToFile();
    }

    public void removerTodos() {
        users.clear();
        System.out.println(Mensagens.getMensagem("menu.remove_all_users") + "!");
        saveToFile();
    }

    public void exportarParaPDF(String fileName) {
        PdfExporter.exportarUsuariosParaPDF(users, fileName);
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                writer.write(user.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(Mensagens.getMensagem("erro_salvar_usuarios"));
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    User user = User.fromFileString(line);
                    if (user != null) {
                        users.add(user);
                    }
                }
            } catch (IOException e) {
                System.out.println(Mensagens.getMensagem("erro_carregar_usuarios"));
            }
        }
    }
}
