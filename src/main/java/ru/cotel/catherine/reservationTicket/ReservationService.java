package ru.cotel.catherine.reservationTicket;

import java.util.List;

public interface ReservationService {
    void ticketReservation(ReservationService reservationService, String fullNamePerson);
    void cancelTicketReservation(String fullNamePerson);
    List<ReservationService> getListReservationTicket();
    int getCountReservedTickets();
}
