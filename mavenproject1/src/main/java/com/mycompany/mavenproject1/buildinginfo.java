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
    /**
     * A description of the entire Java function.
     *
     * @return         description of return value
     */
    @Override
    public String getInfo() {
        return "East Campus: Comprising buildings 510 Turnpike Street the headquarters for all things computer science.";
    }
}

class ComputerScienceProgram implements BuildingInfo{
        /**
         * Returns a string containing information about the computer science program and its staff.
         *
         * @return          a string containing information about the computer science program and its staff
         */
    @Override
    public String getInfo(){
        return "Let's find out more about the computer science program and it's staff!";
    }
}
// Decorator class
class BuildingInfoDecorator implements BuildingInfo {
    private final BuildingInfo buildingInfo;

    public BuildingInfoDecorator(BuildingInfo buildingInfo) {
        this.buildingInfo = buildingInfo;
    }

        /**
         * Retrieves the information from the decorated BuildingInfo object.
         *
         * @return the information from the decorated BuildingInfo object
         */
    @Override
    public String getInfo() {
        return buildingInfo.getInfo();
    }
}