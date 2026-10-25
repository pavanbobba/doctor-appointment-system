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
}
