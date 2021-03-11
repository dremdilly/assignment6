package com.company.afactory;

public class FurnitureClient {
    private FurnitureFactory factory;

    public FurnitureClient(FurnitureFactory factory) {
        this.factory = factory;
    }

    public Sofa createSofa() {
        Sofa sofa = factory.createSofa();
        return sofa;
    }
}

interface Chair {
    public boolean hasLegs();
    public boolean sitOn();
}

class VictorianChair implements Chair {
    private String style = "victorian";

    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public boolean sitOn() {
        return true;
    }
}

class ModernChair implements Chair {
    private String style = "modern";

    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public boolean sitOn() {
        return true;
    }
}

interface CoffeeTable {
    public boolean hasLegs();
    public boolean sitOn();
}

class VictorianCoffeeTable implements CoffeeTable{
    private String style = "victorian";

    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public boolean sitOn() {
        return false;
    }
}

class ModernCoffeeTable implements CoffeeTable {
    private String style = "modern";

    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public boolean sitOn() {
        return false;
    }
}

interface Sofa {
    public boolean hasLegs();
    public boolean sitOn();
}

class VictorianSofa implements Sofa {
    private String style = "victorian";

    @Override
    public boolean hasLegs() {
        return false;
    }

    @Override
    public boolean sitOn() {
        return true;
    }
}

class ModernSofa implements Sofa {
    private String style = "modern";

    @Override
    public boolean hasLegs() {
        return false;
    }

    @Override
    public boolean sitOn() {
        return true;
    }
}

interface FurnitureFactory {
    public Chair createChair();
    public CoffeeTable createCoffeeTable();
    public Sofa createSofa();
}

class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
