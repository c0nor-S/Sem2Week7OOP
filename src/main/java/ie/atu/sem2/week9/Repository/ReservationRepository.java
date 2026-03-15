package ie.atu.sem2.week9.Repository;

import ie.atu.sem2.week9.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByReservationDate(LocalDate reservationDate);
    List<Reservation> findByReservationDateBetween(LocalDate startDate, LocalDate endDate);
    List<Reservation> findByEquipmentTagAndReservationDate(String tag, LocalDate reservationDate);
}
