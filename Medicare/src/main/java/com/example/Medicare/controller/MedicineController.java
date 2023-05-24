package com.example.Medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Medicare.entity.Medicine;
import com.example.Medicare.service.MedicineService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {
	@Autowired
	MedicineService medicineService;

	@PostMapping("/addMedicine")
	public Medicine createMedicine(@RequestBody Medicine med) {
		Medicine medicine = medicineService.create(med);
		return medicine;
	}

	@PostMapping("/updateMedicine/{id}")
	public Medicine updateMedicine(@RequestBody Medicine med, @PathVariable int id) {
		System.out.println("Id for the update" + id);
		Medicine medicine = medicineService.update(id, med);
		return medicine;
	}
	
	@DeleteMapping("/deleteMedicine/{id}")
	public String deleteMedicine(@PathVariable int id) {
		String message = medicineService.delete(id);
		return message;
	}
	
	@GetMapping("/getMedicine")
	public List<Medicine> getMedicine() {
		List<Medicine> medicines = medicineService.getMedicines();
		return medicines;
	}
}
