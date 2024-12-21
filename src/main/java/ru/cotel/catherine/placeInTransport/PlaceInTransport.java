package ru.cotel.catherine.placeInTransport;

import ru.cotel.catherine.transport.Transport;

import java.util.*;
//TODO подключить после разбора основной темы
public class PlaceInTransport {
    private Map<Transport, List<String>> placesInTransport = new HashMap<>();
    private List<String> places = new ArrayList<>(Arrays.asList(
            "Свободно", "Свободно", "Свободно",
            "Свободно", "Свободно", "Свободно",
            "Свободно", "Свободно", "Свободно"));

    public PlaceInTransport() {
    }

    public List<String> getPlaces(Transport transport) {
        return placesInTransport.get(transport);
    }

    public void putInMap(Transport transport) {
        if (!placesInTransport.containsKey(transport)) {
            placesInTransport.put(transport, places);
        }
    }

    public void setPlaces(int numPlace, Transport transport, String placeInformation) {
        List<String> newPlaceInformation = new ArrayList<>(placesInTransport.get(transport));
        newPlaceInformation.set(numPlace, placeInformation);
        placesInTransport.put(transport, newPlaceInformation);
    }

    public boolean isPlaceFree(int numPlace, Transport transport) {
        List<String> placesInformation = new ArrayList<>(placesInTransport.get(transport));
        if (placesInformation.get(numPlace).equalsIgnoreCase("свободно")){
            return true;
        }
        return false;
    }
}
