package com.example.appointment.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data 
public class SlotRequest {
    private Long doctorId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
