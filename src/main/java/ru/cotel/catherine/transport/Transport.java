package ru.cotel.catherine.transport;

public abstract class Transport {
    private final String routeName;
    private final TransportType modeTransportation;

    public Transport(String routeName, TransportType modeTransportation) {
        this.routeName = routeName;
        this.modeTransportation = modeTransportation;
    }

    @Override
    public String toString() {
        return routeName + ", вид транспорта: " + modeTransportation;
    }
}
