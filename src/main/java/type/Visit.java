package type;

import converter.TimeConverter;

import java.time.LocalDateTime;
import java.util.List;

public class Visit extends Type {

    private int roomNumber;
    private List<Integer> doctorIdList;
    private LocalDateTime dateTime;
    private int patientId;
    private String type;

    public int getRoomNumber() {
        return roomNumber;
    }

    public List<Integer> getDoctorIdList() {
        return doctorIdList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getType() {
        return type;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setDoctorIdList(List<Integer> doctorIdList) {
        this.doctorIdList = doctorIdList;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = TimeConverter.applyFormatter(dateTime);
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Visit clone() {
        Visit clone = new Visit();
        clone.setRoomNumber(this.getRoomNumber());
        clone.setDoctorIdList(this.getDoctorIdList());
        clone.setDateTime(this.getDateTime());
        clone.setPatientId(this.getPatientId());
        clone.setType(this.getType());
        return clone;
    }
}
