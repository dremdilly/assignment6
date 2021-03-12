package com.company.builder;

public class House {
    private int numberOfWindows;
    private int numberOfRooms;
    private String typeOfMaterial;

    public House() {}

    public House(int numberOfWindows, int numberOfRooms, String typeOfMaterial) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfWindows = numberOfWindows;
        this.typeOfMaterial = typeOfMaterial;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }
}

class Design {
    private int numberOfWindows;
    private int numberOfRooms;
    private String typeOfMaterial;

    public Design() {}

    public Design(int numberOfWindows, int numberOfRooms, String typeOfMaterial) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfWindows = numberOfWindows;
        this.typeOfMaterial = typeOfMaterial;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }
}

interface Builder {
    public void reset();
    public void buildWalls();
    public void buildDoors();
    public void buildWindows();
    public void buildRoof();
    public void buildGarage();
}

class HouseBuilder implements Builder {
    private House house;
    public HouseBuilder() {
        this.reset();
    }

    public void reset() {
        this.house = new House();
    }

    public void buildWalls() {
        System.out.println("Build walls");
    }

    public void buildDoors() {
        System.out.println("Build doors");
    }

    public void buildWindows() {
        System.out.println("Build windows");
    }

    public void buildRoof() {
        System.out.println("Build roof");
    }

    public void buildGarage() {
        System.out.println("Build garage");
    }

    public House getResult() {
        House newHouse = this.house;
        this.reset();
        return newHouse;
    }
}

class HouseDesignBuilder implements Builder {
    private Design design;
    public HouseDesignBuilder() {
        this.reset();
    }

    public void reset() {
        this.design = new Design();
    }

    public void buildWalls() {
        System.out.println("Build walls");
    }

    public void buildDoors() {
        System.out.println("Build doors");
    }

    public void buildWindows() {
        System.out.println("Build windows");
    }

    public void buildRoof() {
        System.out.println("Build roof");
    }

    public void buildGarage() {
        System.out.println("Build garage");
    }

    public Design getResult() {
        Design newDesign = this.design;
        this.reset();
        return newDesign;
    }
}

class Director {
    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void constructWoodHouse(Builder builder) {
        builder.reset();
        builder.buildDoors();
        builder.buildRoof();
        builder.buildWindows();
        builder.buildGarage();
    }

    public void constructStoneHouse(Builder builder) {}
}

class Application {
    public void buildHouse() {
        Director director = new Director();

        HouseBuilder builder = new HouseBuilder();
        director.constructWoodHouse(builder);
        House house = builder.getResult();

        HouseDesignBuilder designBuilder = new HouseDesignBuilder();
        director.constructWoodHouse(designBuilder);

        Design design = designBuilder.getResult();
    }
}