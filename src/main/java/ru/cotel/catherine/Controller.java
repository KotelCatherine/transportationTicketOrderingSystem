package ru.cotel.catherine;

import ru.cotel.catherine.reservationTicket.ReservationTicket;
import ru.cotel.catherine.reservationTicket.ReservationTicketOnTransport;
import ru.cotel.catherine.routList.RouteList;
import ru.cotel.catherine.transport.Transport;

import java.util.Scanner;

public class Controller {
    private ReservationTicketOnTransport reservationTicket = new ReservationTicket();
    int i;

    public void start() {
        while (true) {
            System.out.println("""
           
                    Выберите что хотите сделать:
                    1. Посмотреть доступные маршруты
                    2. Забронировать билет на маршрут
                    3. Отменить бронь
                    4. Вывести список всех бронированных мест
                    5. Выход из программы"""
            );

            Scanner scanner = new Scanner(System.in);
            try {
                int numMenu = Integer.parseInt(scanner.nextLine());
                switch (numMenu) {
                    case 1:
                        i = 1;
                        System.out.println("Доступные маршруты:");

                        for (Transport transport : RouteList.getRoutes()) {
                            System.out.println(i + ". " + transport);
                            i++;
                        }
                        i = 1;
                        break;
                    case 2:
                        i = 1;
                        System.out.println("Для бронирования введите Ваше ФИО: ");
                        String fullName = scanner.nextLine();

                        System.out.println("Выберите маршрут из списка:");
                        for (Transport transport : RouteList.getRoutes()) {
                            System.out.println(i + ". " + transport);
                            i++;
                        }
                        i = 1;

                        int numRout = Integer.parseInt(scanner.nextLine());
                        Transport transport = RouteList.getRouteByIndex(numRout-1);
                        reservationTicket = new ReservationTicket(transport);
                        reservationTicket.ticketReservation(reservationTicket, fullName);
                        System.out.println("Билет забронирован на имя: " + fullName);
                       /* placeInTransport.putInMap(transport);
                        System.out.println("Выберите свободное место");
                        for (String place : placeInTransport.getPlaces(transport)) {
                            System.out.println(i + ". " + place);
                            i++;
                        }
                        i = 1;
                        */


                       /* while (true) {
                            int numPlace = Integer.parseInt(scanner.nextLine());
                            if (placeInTransport.isPlaceFree(numPlace - 1, transport)) {
                                placeInTransport.setPlaces(numPlace-1,transport,"Занято");

                                break;
                            } else {
                                System.out.println("Это место уже занято, выберите другое!");
                            }
                        }*/
                        break;
                    case 3:
                        System.out.println("Для отмены бронирования введите Ваше ФИО: ");
                        String fullNamePerson = scanner.nextLine();
                        reservationTicket.cancelTicketReservation(fullNamePerson);
                        System.out.println("Бронь отменена!");
                        break;
                    case 4:
                        System.out.println("Всего броней: " + ReservationTicket.getCountReservedTickets());
                        for (ReservationTicketOnTransport ticket: ReservationTicket.getListReservationTicket()){
                            System.out.println(ticket);
                        }
                        break;
                    case 5:
                        System.out.println("Программа завершена!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неизвестная команда!");
                }
            } catch (Exception e) {
                System.err.println("Ошибка " + e.getMessage());
            }
        }
    }
}
