package com.example.Medicare.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.Medicare.entity.Medicine;

public interface MedicineService {
	@Transactional
	
	public Medicine create(Medicine med);
	
	public Medicine update(int id,Medicine med);
	
	public String delete(int id);
	
	public List<Medicine> getMedicines();

	public Medicine getMedicine(int id);
}
