package org.launchcode.the_bar_helper.models;

public enum Position {

    GENERAL_MANAGER("General Manager"),
    ASSISTANT_MANAGER("Assistant Manager"),
    BARTENDER("Bartender"),
    SERVER("Server"),
    BAR_BACK("Bar Back"),
    COOK("Cook");

    private final String positionDisplayName;

    Position(String positionDisplayName) {
        this.positionDisplayName = positionDisplayName;
    }

    public String getPositionDisplayName() {
        return positionDisplayName;
    }
}
