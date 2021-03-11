package com.company.factory;

public abstract class Logistics {

    public void planDelivery() {
        Transport t = createTransport();
        t.deliver();
    }

    public abstract Transport createTransport();
}

class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

interface Transport {
    public String deliver();
}

class Truck implements Transport {
    @Override
    public String deliver() {
        return "Deliver by land in a box";
    }
}

class Ship implements Transport {
    @Override
    public String deliver() {
        return "Deliver by sea in a container";
    }
}
