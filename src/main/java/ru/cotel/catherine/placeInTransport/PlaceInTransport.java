package ru.cotel.catherine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceInTransport {
    private static List<Integer> places = new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1,1,1));

    public PlaceInTransport() {
    }

    public static List<Integer> getPlaces() {
        return places;
    }

    public static boolean placeFree(int numPlace){
        return places.get(numPlace) == 1;
    }
}
