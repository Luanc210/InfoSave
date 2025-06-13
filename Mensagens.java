package main;

import java.util.Locale;
import java.util.ResourceBundle;

public class Mensagens {
    private static ResourceBundle mensagens;

    public static void setIdioma(String idioma) {
        Locale locale;
        if (idioma.equalsIgnoreCase("pt")) {
            locale = Locale.forLanguageTag("pt-BR");
        } else {
            locale = Locale.forLanguageTag("en-US");
        }
        mensagens = ResourceBundle.getBundle("main.messages", locale);
    }

    public static String getMensagem(String chave) {
        return mensagens.getString(chave);
    }
}
