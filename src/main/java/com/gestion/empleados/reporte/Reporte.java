package com.gestion.empleados.reporte;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.gestion.empleados.modelo.Persona;

public class Reporte {
	
	
	private List<Persona> listapersonas;
	
	public Reporte (List<Persona>listapersonas)
	{
		super();
		this.listapersonas = listapersonas;

	}
	
	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		
		
		PdfPCell celda = new PdfPCell();
		

		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("ID", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("NOMBRES", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("EMAIL", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("CONTRASEÑA", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("NOMBRE USUARIO", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("TIPO USUARIO", fuente));
		tabla.addCell(celda);
		
	}
	
	
	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Persona paciente : listapersonas) {
			tabla.addCell(String.valueOf(paciente.getId()));
			tabla.addCell(paciente.getName());
			tabla.addCell(paciente.getEmail());
			tabla.addCell(paciente.getPassword());
			tabla.addCell(paciente.getUsername());
			tabla.addCell(paciente.getTipousuario());
		}
	}
	
	
	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);
		Paragraph titulo = new Paragraph("Lista de Pacientes", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);
		
		PdfPTable tabla = new PdfPTable(6);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1f, 2.3f, 6f, 4f, 2.9f,2.3f});
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
	
	
	public void exportarpsicologo(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);
		Paragraph titulo = new Paragraph("Lista de Psicologos", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);
		
		PdfPTable tabla = new PdfPTable(6);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1f, 2.3f, 6f, 4f, 2.9f,2.3f});
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
	
	public void exportadmin(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);
		Paragraph titulo = new Paragraph("Lista de Administradores", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);
		
		PdfPTable tabla = new PdfPTable(6);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1f, 2.3f, 6f, 3f, 2.9f,3f});
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
	

}
