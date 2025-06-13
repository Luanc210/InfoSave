package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    private String nome;
    private int idade;
    private LocalDateTime dataCadastro;

    public User(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.dataCadastro = LocalDateTime.now();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        return Mensagens.getMensagem("user.name") + ": " + nome + ", "
             + Mensagens.getMensagem("user.age") + ": " + idade + ", "
             + Mensagens.getMensagem("user.registered") + ": " + dataCadastro.format(formatter);
    }

    public String toFileString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        return nome + "," + idade + "," + dataCadastro.format(formatter);
    }

    public static User fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            String nome = parts[0];
            int idade = Integer.parseInt(parts[1]);
            LocalDateTime data;

            try {
                // tenta novo formato
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                data = LocalDateTime.parse(parts[2], formatter);
            } catch (Exception e) {
                // se falhar, tenta ISO antigo
                data = LocalDateTime.parse(parts[2]);
            }

            User user = new User(nome, idade);
            user.dataCadastro = data;
            return user;
        }
        return null;
    }


}
