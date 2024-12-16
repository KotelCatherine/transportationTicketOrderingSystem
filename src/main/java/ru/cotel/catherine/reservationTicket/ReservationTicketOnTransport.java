package ru.cotel.catherine.reservationTicket;


public interface ReservationTicketOnTransport {
    void ticketReservation(ReservationTicketOnTransport reservationTicket, String fullNamePerson);
    void cancelTicketReservation(String fullNamePerson);
}
