package ie.atu.sem2.week9.Service;

import ie.atu.sem2.week9.Model.Reservation;
import ie.atu.sem2.week9.Repository.ReservationRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private List<Reservation> reservations;
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Reservation reservation) {

        reservations = reservationRepository.findAll();

        for(Reservation existing : reservations) {
            if(existing.getEquipmentTag().equals(reservation.getEquipmentTag()) &&
            existing.getReservationDate().equals(reservation.getReservationDate())) {

                int existingStart = existing.startHour();
                int existingEnd = existingStart + existing.getDurationHours();

                int newStart = reservation.getStartHour();
                int newEnd = newStart + reservation.getDurationHours();

                if(existingStart < newEnd && newStart < existingEnd) {
                    throw new ReservationConflictException("Time Slot Already Booked.");
                }
            }
        }
        reservationRepository.save(reservation);
        return reservation;
    }
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long Id) {
        return reservationRepository.findById(Id).orElseThrow(() -> new ReservationNotFoundException("Reservation Not Found."));
    }

    public List<Reservation> getAllReservationsByDate(LocalDate reservationDate) {
        return reservationRepository.findByReservationDate(reservationDate);
    }
}
