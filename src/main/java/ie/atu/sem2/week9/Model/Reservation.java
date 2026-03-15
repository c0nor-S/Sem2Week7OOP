package ie.atu.sem2.week9.Model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Reservation {
    private Long reservationId;

    @NotBlank(message = "Equipment Tag Is Required.")
    private String equipmentTag;

    @NotBlank(message = "Student Email Is Required.")
    @Email(message = "Student Email Must Be A Valid Email Address.")
    private String studentEmail;

    @NotNull(message = "Reservation Date Is Required.")
    private LocalDate reservationDate;

    @Min(value = 0, message = "Start Hour Must Be Between 0 & 23.")
    @Max(value = 23, message = "Start Hour Must Be Between 0 & 23.")
    private int startHour;

    @Min(value = 1, message = "Duration Hours Must Be Between 1 & 24.")
    @Max(value = 24, message = "Duration Hours Must Be Between 1 & 24.")
    private int durationHours;
}
