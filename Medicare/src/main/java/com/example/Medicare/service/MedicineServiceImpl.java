package com.example.Medicare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Medicare.entity.Medicine;

import com.example.Medicare.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineRepository medicineRepository;

	@Override
	public Medicine create(Medicine med) {
		Medicine medicine = medicineRepository.save(med);
		return medicine;
	}

	@Override
	public Medicine update(int id, Medicine med) {
		Optional<Medicine> medecine = medicineRepository.findById(id);
		Medicine medicare = medecine.get();
		medicare.setName(med.getName());
		medicare.setPrice(med.getPrice());
		medicare.setOffers(med.getOffers());
		medicare.setProductDescription(med.getProductDescription());
		medicare.setSeller(med.getSeller());
		medicineRepository.save(medicare);
		return medicare;
	}

	@Override
	public String delete(int id) {
		if (medicineRepository.existsById(id)) {
			medicineRepository.deleteById(id);
			return "deleted";
		} else {
			return "medicine does not exist";
		}

	}

	@Override
	public List<Medicine> getMedicines() {
		List<Medicine> medicines = (List<Medicine>) medicineRepository.findAll();
		if (medicines.size() > 0) {
			return medicines;
		} else {
			return null;
		}

	}

	@Override
	public Medicine getMedicine(int id) {
		Optional<Medicine> medicine = medicineRepository.findById(id);

		Medicine med = medicine.get();
		return med;
	}

}
