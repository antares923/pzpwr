package type;

import java.util.List;

public class Person extends Type {

    private String login;
    private String password;
    private String name;
    private String surname;
    private String job;
    private String rights;
    private int risk;
    private List<Visit> medicalDocumentation;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getJob() {
        return job;
    }

    public String getRights() {
        return rights;
    }

    public int getRisk() {
        return risk;
    }

    public List<Visit> getMedicalDocumentation() {
        return medicalDocumentation;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public void setMedicalDocumentation(List<Visit> medicalDocumentation) {
        this.medicalDocumentation = medicalDocumentation;
    }

    @Override
    public Person clone() {
        Person clone = new Person();
        clone.setLogin(this.login);
        clone.setPassword(this.password);
        clone.setName(this.name);
        clone.setSurname(this.surname);
        clone.setJob(this.job);
        clone.setRights(this.rights);
        clone.setRisk(this.risk);
        clone.setMedicalDocumentation(this.medicalDocumentation);
        return clone;
    }
}
