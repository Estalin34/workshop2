package com.example.tallerBanco.Banco.Controlador;

import com.example.tallerBanco.Banco.Servicio.PdfServicio;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class PdfControlador {

    @Autowired
    private PdfServicio pdfServicio;

    @GetMapping("/generar-pdf")
    public ResponseEntity<Resource> generarPdf() {
        try {
            byte[] pdfBytes = pdfServicio.generarPdf();
            ByteArrayResource resource = new ByteArrayResource(pdfBytes);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formularios.pdf");
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException | DocumentException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
