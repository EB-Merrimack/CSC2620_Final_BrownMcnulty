package com.mycompany.mavenproject1;

// Decorator Interface
interface BuildingInfo {
    String getInfo();
}

// Concrete Decorator for Main Campus
class MainCampusInfo implements BuildingInfo {
    @Override
    public String getInfo() {
        return "Main Campus: Located at the heart of the university.";
    }
}

// Concrete Decorator for East Campus
class EastCampusInfo implements BuildingInfo {
    @Override
    public String getInfo() {
        return "East Campus: Comprising buildings 510 and 530 Turnpike Street.";
    }
}

// Decorator class
class BuildingInfoDecorator implements BuildingInfo {
    private final BuildingInfo buildingInfo;

    public BuildingInfoDecorator(BuildingInfo buildingInfo) {
        this.buildingInfo = buildingInfo;
    }

    @Override
    public String getInfo() {
        return buildingInfo.getInfo();
    }
}
