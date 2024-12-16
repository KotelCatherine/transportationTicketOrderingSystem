package ru.cotel.catherine;

import java.util.ArrayList;
import java.util.List;

public class ReservationTicket {
    private boolean reserved;
    private int numRout;
    private int numPlace;
    private List<ReservationTicket> tickets = new ArrayList<>();

    private String fullNamePerson;

    ReservationTicket(int numRout, int numPlace, String fullNamePerson) {
        this.numRout = numRout;
        this.numPlace = numPlace;
        this.fullNamePerson = fullNamePerson;
    }

    public String ticketReservation(ReservationTicket reservationTicket) {

        if (PlaceInTransport.placeFree(numPlace)) {
            reserved = true;
            tickets.add(reservationTicket);
            return "Забронировано";
        }else {
            return "Место уже занято";
        }
    }

    public void cancelTicketReservation() {
        reserved = false;
    }

    @Override
    public String toString() {
        return "ReservationTicket{" +
                "reserved=" + reserved +
                ", numRout=" + numRout +
                ", numPlace=" + numPlace +
                ", person='" + fullNamePerson + '\'' +
                '}';
    }
}
