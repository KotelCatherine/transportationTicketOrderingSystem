package ru.cotel.catherine;

import java.util.Arrays;
import java.util.List;

public class RouteList {
    private static List<Transport> routes = Arrays.asList(
            new Bus("Абакан-Новосибирск", "автобус"),
            new Airplane("Абакан-Новосибирск", "самолёт"),
            new Bus("Красноярск-Иркутск", "автобус"),
            new Airplane("Красноярск-Иркутск", "самолёт")
    );


    public static List<Transport> getRoutes() {
        return routes;
    }
}
