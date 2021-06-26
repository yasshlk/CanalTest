package com.yshlk.meetingplanner.entities;

public enum TypeReunionEnum {

    VC( "visio Conference"),
    SPEC("seance de partage et d'etudee cas "),
    RS("reunion simple"),
    RC("reunion couplees");

    public final String label;

    private TypeReunionEnum(String label) {
        this.label = label;
    }
}
