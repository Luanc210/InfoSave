# 📋 InfoSave — Java Desktop User Manager

Sistema desktop simples desenvolvido em **Java 21** para cadastro de usuários, gerenciamento via console e exportação de lista para PDF.  
✅ Suporte a **multi-idioma (Português/Inglês)** via `ResourceBundle`.

A simple desktop system developed in **Java 21** for user registration, console management, and exporting user list to PDF.  
✅ Supports **multi-language (Portuguese/English)** via `ResourceBundle`.

---

## 📸 Demonstração / Demo

![Demonstração do projeto / Project Demo](assets/demo.gif)

---

## 📌 Tecnologias / Technologies

- Java 21
- Eclipse IDE
- iTextPDF (PDF export)
- ResourceBundle (multi-language)
- Open Broadcaster Software (OBS recording)

---

## 🌐 Idiomas / Languages Supported

🇧🇷 **Português (pt-BR)**  
🇺🇸 **English (en-US)**  

O idioma é escolhido no início da execução:  
The language is chosen at program start:

```
Escolha o idioma (pt/en):
Choose the language (pt/en):
```

---

## 📥 Funcionalidades / Features

- 📥 Adicionar usuário / Add user
- 📜 Listar usuários / List users
- ❌ Remover usuário / Remove user
- 🗑️ Remover todos os usuários / Remove all users
- 📄 Exportar lista para PDF / Export list to PDF
- 🌐 Multi-idioma via ResourceBundle / Multi-language support via ResourceBundle

---

## 🚀 Como executar / How to Run

**Compilar / Compile:**

```bash
javac -d bin src/main/*.java
```

**Executar / Run:**

```bash
java -cp bin main.Main
```

---

## 🖥️ Exportação para PDF / Export to PDF

Um arquivo chamado `usuarios.pdf` será gerado na pasta do projeto.  
A file named `usuarios.pdf` will be generated in the project directory.

---

## 📦 Estrutura / Project Structure

```
/src/
  /main/
    Main.java
    User.java
    UserManager.java
    PdfExporter.java
    Mensagens.java
/assets/
  demo.gif
messages_en_US.properties
messages_pt_BR.properties
README.md
```

---

## 📈 Status

✅ **Projeto finalizado e funcional / Project completed and working**

---

## ✍️ Autor / Author

**Luanc210**  
[GitHub](https://github.com/Luanc210)
