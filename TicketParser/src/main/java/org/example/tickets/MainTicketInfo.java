package org.example.tickets;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class MainTicketInfo {
    private LocalDate departure_date;
    private LocalTime departure_time;
    private LocalDate arrival_date;
    private LocalTime arrival_time;
    private int price;
    private String carrier;
}
