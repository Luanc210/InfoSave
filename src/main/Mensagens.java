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
        mensagens = ResourceBundle.getBundle("messages", locale);
    }

    public static String getMensagem(String chave) {
        if (mensagens == null) {
            // fallback seguro, se tentarem antes de setIdioma
            setIdioma("pt");
        }
        return mensagens.getString(chave);
    }
}
