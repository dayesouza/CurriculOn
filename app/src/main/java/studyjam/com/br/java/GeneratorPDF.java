package studyjam.com.br.java;
import android.os.Environment;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GeneratorPDF {

    public void criar () {
        // criação do documento
        Document document = new Document();
        try {

            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            File file = new File(path, "/PDF_Curriculo");
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            // adicionando um parágrafo no documento
            document.add(new Paragraph("Gerando PDF - Java"));
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
    }
}
