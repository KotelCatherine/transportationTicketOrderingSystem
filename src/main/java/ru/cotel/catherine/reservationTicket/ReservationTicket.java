package ru.cotel.catherine.reservationTicket;

import ru.cotel.catherine.transport.Transport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationTicket implements ReservationTicketOnTransport{
    private Transport nameRout;
    private static Map<String, ReservationTicketOnTransport> tickets = new HashMap<>();
    private static int countReservedTickets = 0;

    public ReservationTicket(Transport nameRout) {
        this.nameRout = nameRout;
    }

    public ReservationTicket() {
    }

    public void ticketReservation(ReservationTicketOnTransport reservationTicket, String fullNamePerson) {
        tickets.put(fullNamePerson, reservationTicket);
        countReservedTickets++;
    }

    public void cancelTicketReservation(String fullNamePerson) {
        if (!tickets.containsKey(fullNamePerson)) {
            System.out.println("Бронь не найдена");
        } else {
            //placeInTransport.setPlaces(numPlace, nameRout, "Свободно");
            tickets.remove(fullNamePerson);
            countReservedTickets--;
        }
    }

    public static List<ReservationTicketOnTransport> getListReservationTicket(){
        List<ReservationTicketOnTransport> listReservationTickets = new ArrayList<>();
        for (Map.Entry<String, ReservationTicketOnTransport> ticket: tickets.entrySet()){
            listReservationTickets.add(ticket.getValue());
        }
        return listReservationTickets;
    }

    public static int getCountReservedTickets() {
        return countReservedTickets;
    }

    @Override
    public String toString() {
        return "Бронь на маршрут: " +
                nameRout;
    }
}
