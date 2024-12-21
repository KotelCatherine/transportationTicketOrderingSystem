package ru.cotel.catherine.reservationTicket;

public interface ReservationTicketRepository {
    void addInReservationTicketRepository(String fullName, ReservationService reservationService);
    boolean removeReservationTicketFromRepository(String fullName);
}
