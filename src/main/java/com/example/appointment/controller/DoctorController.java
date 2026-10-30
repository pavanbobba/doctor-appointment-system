package com.example.appointment.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.entity.Doctor;
import com.example.appointment.service.DoctorService;
import java.util.List;

@RestController 
@RequestMapping ("/api/Doctors")
public class DoctorController {
    
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    @PostMapping 
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @GetMapping 
    public List<Doctor> getDoctor(){
        return doctorService.getDoctor();
    }

    @GetMapping ("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    @PutMapping ("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor updated){
        return doctorService.updateDoctor(id, updated);
    }

    @DeleteMapping ("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }
}
