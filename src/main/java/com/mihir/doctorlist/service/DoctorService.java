package com.mihir.doctorlist.service;

import com.mihir.doctorlist.entity.Doctor;
import com.mihir.doctorlist.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }
    public Optional<Doctor> findByName(String name) {
        return repository.findByName();
    }

    public Doctor addDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public Doctor updateDoctor(String name, Doctor doctorDetails) {
        return repository.findByName().map(doctor -> {
            doctor.setSpecialty(doctorDetails.getSpecialty());
            doctor.setRank(doctorDetails.getRank());
            doctor.setFee(doctorDetails.getFee());
            doctor.setDescription(doctorDetails.getDescription());
            doctor.setNumber(doctorDetails.getNumber());
            return repository.save(doctor);
        }).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public void deleteDoctor(String name) {
        repository.deleteByName(name);
    }
}
