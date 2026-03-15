package ie.atu.sem2.week9.Service;

import ie.atu.sem2.week9.Model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private List<Reservation> reservations = new ArrayList<>();
    private Long nextId = 1;

    public Reservation addReservation(Reservation reservation) {
        reservation.setReservationId(nextId++);

        for(Reservation exsiting : reservations) {
            if(exsiting.getEquipmentTag().equals(reservation.getEquipmentTag()) &&
            existing.getReservationDate().equals(reservation.getReservationDate())) {

                int existingStart = existing.startHour();
                int existingEnd = existingStart + exsiting.getDurationHours();

                int newStart = reservation.getStartHour();
                int newEnd = newStart + reservation.getDurationHours();

                if(existingStart < newEnd && newStart < existingEnd) {
                    reservation.setReservationId(nextId--);
                    throw new ReservationConflictException("Time Slot Already Booked.");
                }
            }
        }
        reservations.add(reservation);
        return reservation;
    }
    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public Reservation getReservationById(Long Id) {
        for(Reservation reservation : reservations) {
            if(reservation.getReservationById().equals(id)) {
                return reservation;
            }
        }
        throw new ReservationNotFoundException("Reservation Not Found.");
    }
}
