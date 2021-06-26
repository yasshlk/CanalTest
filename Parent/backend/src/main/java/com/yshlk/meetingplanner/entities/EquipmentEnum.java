package com.yshlk.meetingplanner.entities;

public enum EquipmentEnum {

    ECRAN( "ecran"),
    NEANT("neant"),
    PIEUVRE("pieuvre"),
    TABLEAU("tableau"),
    WEBCAM("webcam");

    public final String label;

    private EquipmentEnum(String label) {
        this.label = label;
    }
}
