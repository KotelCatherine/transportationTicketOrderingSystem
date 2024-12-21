package ru.cotel.catherine;

import ru.cotel.catherine.reservationTicket.ReservationManager;
import ru.cotel.catherine.reservationTicket.ReservationService;
import ru.cotel.catherine.routList.InMemoryRoutRepository;
import ru.cotel.catherine.routList.RouteRepository;

public class Main {
    public static void main(String[] args) {
        RouteRepository routeRepository = new InMemoryRoutRepository();
        ReservationService reservationService = new ReservationManager();
        new Controller(routeRepository, reservationService).start();
    }
}