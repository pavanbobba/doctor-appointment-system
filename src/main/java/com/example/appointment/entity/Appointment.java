package com.example.appointment.entity;

import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table(name="appointment")
@NoArgsConstructor 
@Getter 
@Setter 
@Data 
@AllArgsConstructor 
@Builder 



public class Appointment{
    
    @Id 
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "patient_id", nullable = false)
    private User patient;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name= "slot_id", nullable = false)
    private AvailabilitySlot slot;

    @Enumerated (EnumType.STRING)
    @Column(nullable=false)
    private AppointmentStatus status;

    @Column (nullable = false)
    private LocalDateTime createdAt;
        
    
}

