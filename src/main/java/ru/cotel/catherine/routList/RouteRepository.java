package ru.cotel.catherine.routList;

import ru.cotel.catherine.transport.Transport;

import java.util.List;

public interface RouteRepository {
    Transport getRouteByIndex(int numRoute);
    List<Transport> getRoutes();
}
