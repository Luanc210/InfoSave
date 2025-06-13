package main;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.FileOutputStream;
import java.util.List;

public class PdfExporter {

    public static void exportarUsuariosParaPDF(List<User> users, String fileName) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            document.add(new Paragraph(Mensagens.getMensagem("menu.list_users") + "\n\n"));

            for (User user : users) {
                document.add(new Paragraph(user.toString()));
            }

            System.out.println(Mensagens.getMensagem("menu.success_export") + ": " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
