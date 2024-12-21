package ru.cotel.catherine.routList;

import ru.cotel.catherine.transport.TransportType;
import ru.cotel.catherine.transport.Airplane;
import ru.cotel.catherine.transport.Bus;
import ru.cotel.catherine.transport.Transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteList implements RoutListService {
    private List<Transport> routes = new ArrayList<>(Arrays.asList(
            new Bus("Абакан-Новосибирск", TransportType.BUS),
            new Airplane("Абакан-Новосибирск", TransportType.AIRPLANE),
            new Bus("Красноярск-Иркутск", TransportType.BUS),
            new Airplane("Красноярск-Иркутск", TransportType.AIRPLANE))
    );

    @Override
    public List<Transport> getRoutes() {
        return routes;
    }
}
