package org.example;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.FileOutputStream;

public class ResumePdfGenerator {
    public static void main(String[] args) {
        try {
            Document doc = new Document(PageSize.A4, 36, 36, 54, 54);
            PdfWriter.getInstance(doc, new FileOutputStream("resume.pdf"));
            doc.open();

            Font titleFont = new Font(Font.HELVETICA, 20, Font.BOLD);
            Font h2 = new Font(Font.HELVETICA, 14, Font.BOLD);
            Font normal = new Font(Font.HELVETICA, 12);

            Paragraph title = new Paragraph("John Doe", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);
            doc.add(new Paragraph("Software Engineer", normal));
            doc.add(Chunk.NEWLINE);


            java.net.URL imgUrl = ResumePdfGenerator.class.getResource("/photo.jpg");
            if (imgUrl != null) {
                Image img = Image.getInstance(imgUrl);
                img.scaleToFit(110, 110);
                img.setAlignment(Image.ALIGN_RIGHT);
                doc.add(img);
            } else {
                doc.add(new Paragraph("[Add photo.jpg under src/main/resources/]", new Font(Font.HELVETICA, 10, Font.ITALIC)));
            }
            doc.add(Chunk.NEWLINE);

            doc.add(new Paragraph("Work Experience", h2));
            doc.add(new Paragraph("1. Senior Java Developer – AtlasTech (2023–2025)", normal));
            doc.add(new Paragraph("2. Software Developer – NexaSoft (2021–2023)", normal));
            doc.add(new Paragraph("3. Intern – Artemis Labs (2020)", normal));

            doc.close();
            System.out.println("✅ PDF created: resume.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

