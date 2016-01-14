package type;

import appenum.JobEnum;
import appenum.RightEnum;

import java.util.List;

public class Person extends Type {

    private String login;
    private String password;
    private String name;
    private String surname;
    private JobEnum job;
    private RightEnum rights;
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

    public JobEnum getJob() {
        return job;
    }

    public RightEnum getRights() {
        return rights;
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

    public void setJob(JobEnum job) {
        this.job = job;
    }

    public void setRights(RightEnum rights) {
        this.rights = rights;
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
        clone.setMedicalDocumentation(this.medicalDocumentation);
        return clone;
    }
}
