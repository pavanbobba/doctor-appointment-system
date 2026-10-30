package com.example.appointment.controller;

import com.example.appointment.service.AvailabilitySlotService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.dto.SlotRequest;
import com.example.appointment.entity.AvailabilitySlot;
import java.util.List;

@RestController 
@RequestMapping ("/api/slots")
public class AvailabilitySlotController {
    
    private final AvailabilitySlotService slotService;

    public AvailabilitySlotController(AvailabilitySlotService slotService){
        this.slotService=slotService;
    }

    @PostMapping 
    public AvailabilitySlot createSlot(@RequestBody SlotRequest request){
        return slotService.createSlot(request);
    }

    @GetMapping("/doctor/{doctorId}") 
    public List<AvailabilitySlot> getAvailableSlots(@PathVariable  Long doctorId){
        return slotService.getAvailableSlots(doctorId);
    }
}
