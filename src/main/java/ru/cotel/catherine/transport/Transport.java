package ru.cotel.catherine;

public abstract class Transport {
    private String routeName;
    private String modeTransportation;


    public Transport(String routeName, String modeTransportation) {
        this.routeName = routeName;
        this.modeTransportation = modeTransportation;
    }

    public String getRouteName() {
        return routeName;
    }

    public String getModeTransportation() {
        return modeTransportation;
    }

    @Override
    public String toString() {
        return "Маршрут: " + routeName;
    }
}
