package com.example.appointment.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.appointment.entity.Doctor;
import com.example.appointment.repository.DoctorRepository;

@Service 
public class DoctorService {
    
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctor(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id){
        return doctorRepository.findById(id) 
                .orElseThrow(() -> new RuntimeException("Doctor Not Found with id " + id));
    }

    public Doctor updateDoctor(Long id , Doctor updated){
        Doctor existing=doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor Not Found with Id " + id));

        existing.setName(updated.getName());
        existing.setSpecialization(updated.getSpecialization());
        existing.setBio(updated.getBio());

        return  doctorRepository.save(existing);
    }

    public void deleteDoctor(Long id){
        if(!doctorRepository.existsById(id)){
            throw new RuntimeException("Doctor not found by this Id" + id);
        }    

        doctorRepository.deleteById(id);
    }
}
