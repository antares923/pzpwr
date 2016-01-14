package type;

public class PatientQuery extends Type {

    int patientId;
    String description;

    public int getPatientId() {
        return patientId;
    }

    public String getDescription() {
        return description;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public PatientQuery clone() {
        PatientQuery clone = new PatientQuery();
        clone.setPatientId(this.getPatientId());
        clone.setDescription(this.getDescription());
        return clone;
    }

    @Override
    public String toString() {
        return patientId + ": " + description;
    }
}
