package ru.cotel.catherine.reservationTicket;

import ru.cotel.catherine.transport.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReservationManager implements ReservationService {
    private ReservationTicketRepository ticket = new ReservationTicket();
    private static int countReservedTickets = 0;
    private Transport transport;

    public ReservationManager(Transport transport) {
        this.transport = transport;
    }

    public ReservationManager() {

    }

    @Override
    public void ticketReservation(ReservationService reservationService, String fullNamePerson) {
        ticket.addInReservationTicketRepository(fullNamePerson, reservationService);
        countReservedTickets++;
    }

    @Override
    public void cancelTicketReservation(String fullNamePerson) {
        if (ticket.removeReservationTicketFromRepository(fullNamePerson)) {
            countReservedTickets--;
        } else {
            System.out.println("Бронь не найдена");
        }
    }

    @Override
    public List<ReservationService> getListReservationTicket() {
        List<ReservationService> listReservationTickets = new ArrayList<>();
        for (Map.Entry<String, ReservationService> ticket : ReservationTicket.tickets.entrySet()) {
            listReservationTickets.add(ticket.getValue());
        }
        return listReservationTickets;
    }

    @Override
    public int getCountReservedTickets() {
        return countReservedTickets;
    }

    @Override
    public String toString() {
        return "ReservationManager{" +
                "ticket=" + transport +
                '}';
    }
}
