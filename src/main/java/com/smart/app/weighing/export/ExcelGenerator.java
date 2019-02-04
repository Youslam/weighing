package com.smart.app.weighing.export;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.smart.app.weighing.model.Pesage;

public class ExcelGenerator {

	public static ByteArrayInputStream pesagesToExcel(List<Pesage> pesages) throws IOException {
		String[] COLUMNs = {"Immatricule", "Produit", "Client", "Fournisseur", "Numéro BL", "Poid Brut", "Poid Net", "Date"};
		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
			CreationHelper createHelper = workbook.getCreationHelper();
	 
			Sheet sheet = workbook.createSheet("Pesages");
	 
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
	 
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
	 
			// Row for Header
			Row headerRow = sheet.createRow(0);
	 
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
	 
			// CellStyle for Age
			CellStyle dateCellStyle = workbook.createCellStyle();
			dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
	 
			int rowIdx = 1;
			for (Pesage pesage : pesages) {
				Row row = sheet.createRow(rowIdx++);
	 
				row.createCell(0).setCellValue(pesage.getVehicle().getMatricule());
				row.createCell(1).setCellValue(pesage.getProduct().getName());
				row.createCell(2).setCellValue(pesage.getClient() != null ? pesage.getClient().getName() : "N/A");
				row.createCell(3).setCellValue(pesage.getSupplier() != null ? pesage.getSupplier().getName() : "N/A");
				row.createCell(4).setCellValue(pesage.getNumberBL());
				row.createCell(5).setCellValue(pesage.getFirstBalanceBrut());
				row.createCell(6).setCellValue(pesage.getFirstBalanceNet());
				
	 
				Cell ageCell = row.createCell(7);
				ageCell.setCellValue(pesage.getDateTime());
				ageCell.setCellStyle(dateCellStyle);
			}
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}
