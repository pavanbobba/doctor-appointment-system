package com.example.appointment.service;

import org.springframework.stereotype.Service;

import com.example.appointment.dto.SlotRequest;
import com.example.appointment.repository.AvailabilitySlotRepository;
import com.example.appointment.repository.DoctorRepository;
import com.example.appointment.entity.AvailabilitySlot;
import com.example.appointment.entity.Doctor;
import com.example.appointment.entity.SlotStatus;
import java.util.List;

@Service 
public class AvailabilitySlotService {

    public final DoctorRepository doctorRepository;
    public final AvailabilitySlotRepository slotRepository;
    
    public AvailabilitySlotService(DoctorRepository doctorRepository, AvailabilitySlotRepository slotRepository){
        this.slotRepository=slotRepository;
        this.doctorRepository=doctorRepository;
    }

    public AvailabilitySlot createSlot(SlotRequest request){
        if(!request.getEndTime().isAfter(request.getStartTime())){
            throw new RuntimeException("End time must be after the Start time");
        }

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with Id" + request.getDoctorId()));
        
        AvailabilitySlot slot=AvailabilitySlot.builder()
                            .doctor(doctor)
                            .startTime(request.getStartTime())
                            .endTime(request.getEndTime())
                            .status(SlotStatus.AVAILABLE)
                            .build();
        
        return slotRepository.save(slot);
    }

    public List<AvailabilitySlot> getAvailableSlots(Long doctorId){
        return slotRepository.findByDoctorIdAndStatus(doctorId, SlotStatus.AVAILABLE);
    }

}

