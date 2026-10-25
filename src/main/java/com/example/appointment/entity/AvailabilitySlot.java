package com.example.appointment.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name="availability_slot")
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter 
@Builder

public class AvailabilitySlot {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="doctor_id" , nullable=false)
    private Doctor doctor;

    @Column(name="start_time" ,nullable=false)
    private LocalDateTime startTime;

    @Column(name="end_time" , nullable=false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SlotStatus status;

    @Version 
    private Long version;
}
