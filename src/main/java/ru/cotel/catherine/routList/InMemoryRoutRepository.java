package ru.cotel.catherine.routList;

import ru.cotel.catherine.transport.Transport;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRoutRepository implements RouteRepository{
    RoutListService routListService = new RouteList();

    @Override
    public Transport getRouteByIndex(int numRoute) {
        List<Transport> routs = new ArrayList<>(routListService.getRoutes());
        return routs.get(numRoute);
    }

    @Override
    public List<Transport> getRoutes() {
        return routListService.getRoutes();
    }
}
