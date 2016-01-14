package com.pzpwr.core.type;

import com.pzpwr.core.appenum.VisitTypeEnum;

public class PatientRegistration extends Type {

    private int patientId;
    private int risk;
    private VisitTypeEnum type;

    public int getPatientId() {
        return patientId;
    }

    public int getRisk() {
        return risk;
    }

    public VisitTypeEnum getType() {
        return type;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public void setType(VisitTypeEnum type) {
        this.type = type;
    }

    @Override
    public PatientRegistration clone() {
        PatientRegistration clone = new PatientRegistration();
        clone.setPatientId(this.getPatientId());
        clone.setRisk(this.getRisk());
        clone.setType(this.getType());
        return clone;
    }

    @Override
    public String toString() {
        return "Registration: " + patientId + "( " + "risk: " + risk + ", visit com.pzpwr.core.type: " + type + ")";
    }
}
