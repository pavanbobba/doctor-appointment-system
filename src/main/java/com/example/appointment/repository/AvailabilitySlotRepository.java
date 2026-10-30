package com.example.appointment.repository;

import java.util.List;

import com.example.appointment.entity.AvailabilitySlot;
import com.example.appointment.entity.SlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlot, Long> {
    List<AvailabilitySlot> findByDoctorIdAndStatus(Long doctorId, SlotStatus status);
}
