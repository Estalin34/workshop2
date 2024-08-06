package com.example.tallerBanco.Banco.Servicio;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.example.tallerBanco.Banco.Entidad.Formulario;
import com.example.tallerBanco.Banco.Repositorio.FormularioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfServicio {

    @Autowired
    private FormularioRepositorio formularioRepositorio;

    public byte[] generarPdf() throws DocumentException, IOException {
        // Recupera los formularios de la base de datos
        List<Formulario> formularios = formularioRepositorio.findAll();
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
        document.add(new Paragraph("Listado de Formularios", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14))); // Título
        PdfPTable table = new PdfPTable(5); // Crea una tabla con 5 columnas
        table.setWidthPercentage(100);
        table.addCell(new PdfPCell(new Phrase("Nombre", FontFactory.getFont(FontFactory.HELVETICA, 12))));
        table.addCell(new PdfPCell(new Phrase("Apellido", FontFactory.getFont(FontFactory.HELVETICA, 12))));
        table.addCell(new PdfPCell(new Phrase("Cédula", FontFactory.getFont(FontFactory.HELVETICA, 12))));
        table.addCell(new PdfPCell(new Phrase("Número de Cuenta", FontFactory.getFont(FontFactory.HELVETICA, 12))));
        table.addCell(new PdfPCell(new Phrase("Correo Electrónico", FontFactory.getFont(FontFactory.HELVETICA, 12))));

        for (Formulario formulario : formularios) {
            table.addCell(new PdfPCell(new Phrase(formulario.getNombre(), FontFactory.getFont(FontFactory.HELVETICA, 12))));
            table.addCell(new PdfPCell(new Phrase(formulario.getApellido(), FontFactory.getFont(FontFactory.HELVETICA, 12))));
            table.addCell(new PdfPCell(new Phrase(formulario.getCedula(), FontFactory.getFont(FontFactory.HELVETICA, 12))));
            table.addCell(new PdfPCell(new Phrase(formulario.getNumeroCuenta(), FontFactory.getFont(FontFactory.HELVETICA, 12))));
            table.addCell(new PdfPCell(new Phrase(formulario.getCorreoElectronico(), FontFactory.getFont(FontFactory.HELVETICA, 12))));
        }

        document.add(table);
        document.close();
        return baos.toByteArray();
    }
}
