package com.example.appointment.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;

@Entity
@Table(name="doctor")
@NoArgsConstructor
@Getter 
@Setter 
@Builder
@AllArgsConstructor

public class Doctor {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column (nullable=false)
    private String name;

    @Column(nullable=false)
    private String specialization;

    private String bio;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
