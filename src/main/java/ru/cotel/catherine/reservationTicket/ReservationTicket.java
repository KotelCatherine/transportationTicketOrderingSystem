package ru.cotel.catherine.reservationTicket;

import java.util.HashMap;
import java.util.Map;

public class ReservationTicket implements ReservationTicketRepository{
    protected static Map<String, ReservationService> tickets = new HashMap<>();

    @Override
    public void addInReservationTicketRepository(String fullName, ReservationService reservationService) {
        tickets.put(fullName, reservationService);
    }

    @Override
    public boolean removeReservationTicketFromRepository(String fullName) {

        if (!tickets.containsKey(fullName)) {
            return false;
        } else {
            tickets.remove(fullName);
            return true;
        }
    }
}
