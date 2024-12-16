package ru.cotel.catherine.transport;

public abstract class Transport {
    private final String routeName;
    private final String modeTransportation;

    public Transport(String routeName, String modeTransportation) {
        this.routeName = routeName;
        this.modeTransportation = modeTransportation;
    }

    @Override
    public String toString() {
        return routeName + ", вид транспорта: " + modeTransportation;
    }
}
