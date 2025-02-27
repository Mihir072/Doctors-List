package com.mihir.doctorlist.controller;

import com.mihir.doctorlist.entity.Doctor;
import com.mihir.doctorlist.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return service.getAllDoctors();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return service.addDoctor(doctor);
    }

    @GetMapping("/{name}")
    public Optional<Doctor> getDoctorByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @PutMapping("/{name}")
    public Doctor updateDoctor(@PathVariable String name, @RequestBody Doctor doctor) {
        return service.updateDoctor(name, doctor);
    }

    @DeleteMapping("/{name}")
    public void deleteDoctor(@PathVariable String name) {
        service.deleteDoctor(name);
    }
}
