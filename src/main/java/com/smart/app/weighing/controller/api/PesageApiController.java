package com.smart.app.weighing.controller.api;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart.app.weighing.export.ExcelGenerator;
import com.smart.app.weighing.export.PdfGenerator;
import com.smart.app.weighing.model.Pesage;
import com.smart.app.weighing.service.PesageService;

@RestController
@RequestMapping("/api/pesage")
public class PesageApiController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PesageService pesageService;
	
	@Autowired
	PdfGenerator pdfGeneator;
	
	@PostMapping("/save")
	public void save(Pesage pesage) {
		pesage.setDateTime(new Date());
		pesageService.save(pesage);
	}
	
	@GetMapping(value = "/download/excel")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<Pesage> customers = pesageService.findAll();
		
		ByteArrayInputStream in = ExcelGenerator.pesagesToExcel(customers);
		// return IOUtils.toByteArray(in);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=pesages.xlsx");
		
		 return ResponseEntity
	                .ok()
	                .headers(headers)
	                .body(new InputStreamResource(in));
    }
	
	@GetMapping(value = "/download/pdf")
	public ResponseEntity<InputStreamResource>  pdfTicket(@RequestParam(value="id") Long id) throws Exception{
		Pesage pesage = pesageService.findById(id);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		if(pesage != null) {			
			Map<String,String> data = new HashMap<String,String>();
			data.put("vehicle", pesage.getVehicle().getMatricule());
			data.put("product", pesage.getProduct().getName());
			data.put("numberBL", pesage.getNumberBL());
			String holder = "";
			if(pesage.getClient() != null) {
				holder = pesage.getClient().getName();
			} else if(pesage.getSupplier() != null){
				holder = pesage.getSupplier().getName();
			}
			data.put("holder", holder);
			
			data.put("datetime", sdf.format(pesage.getDateTime()));
			data.put("balanceBrut", String.valueOf(pesage.getFirstBalanceBrut()));
			data.put("balanceNet", String.valueOf(pesage.getFirstBalanceNet()));
			FileInputStream in = pdfGeneator.createPdf("ticket",data);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=ticket.pdf");
			
			return ResponseEntity
					.ok()
					.headers(headers)
					.body(new InputStreamResource(in));
		}
		return null;
	}
	
}
