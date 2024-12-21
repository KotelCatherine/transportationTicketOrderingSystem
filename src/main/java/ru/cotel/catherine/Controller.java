package ru.cotel.catherine;

import ru.cotel.catherine.reservationTicket.ReservationManager;
import ru.cotel.catherine.reservationTicket.ReservationService;
import ru.cotel.catherine.routList.RouteRepository;
import ru.cotel.catherine.transport.Transport;

import java.util.Scanner;

public class Controller {
    int i;
    private final RouteRepository routeRepository;
    private ReservationService reservationService;

    public Controller(RouteRepository routeRepository, ReservationService reservationService) {
        this.routeRepository = routeRepository;
        this.reservationService = reservationService;
    }

    public void start() {
        while (true) {
            System.out.println("""
                    
                    Выберите пункт:
                    1. Посмотреть доступные маршруты
                    2. Забронировать билет на маршрут
                    3. Отменить бронь
                    4. Вывести список всех бронированных мест
                    5. Выход из программы
                    """
            );
            Scanner scanner = new Scanner(System.in);
            try {
                int numMenu = Integer.parseInt(scanner.nextLine());
                switch (numMenu) {
                    case 1:
                        i = 1;
                        System.out.println("Доступные маршруты:");

                        for (Transport transport : routeRepository.getRoutes()) {
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
                        for (Transport transport : routeRepository.getRoutes()) {
                            System.out.println(i + ". " + transport);
                            i++;
                        }
                        i = 1;

                        int numRout = Integer.parseInt(scanner.nextLine());
                        Transport transport = routeRepository.getRouteByIndex(numRout - 1);
                        reservationService = new ReservationManager(transport);
                        reservationService.ticketReservation(reservationService, fullName);
                        System.out.println("Билет забронирован на имя: " + fullName);
                        break;
                    case 3:
                        System.out.println("Для отмены бронирования введите Ваше ФИО: ");
                        String fullNamePerson = scanner.nextLine();
                        reservationService.cancelTicketReservation(fullNamePerson);
                        System.out.println("Бронь отменена!");
                        break;
                    case 4:
                        System.out.println("Всего броней: " + reservationService.getCountReservedTickets());
                        for (ReservationService ticket : reservationService.getListReservationTicket()) {
                            System.out.println(ticket.toString());
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
