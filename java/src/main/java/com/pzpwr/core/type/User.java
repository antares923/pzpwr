package com.pzpwr.core.type;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.appenum.RightEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User extends Type {

    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private JobEnum job;
    private RightEnum rights;
    private List<Visit> medicalDocumentation = new ArrayList<>();

    public int getId() {
        return id;
    }

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

    public void setId(int id) {
        this.id = id;
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
        if (medicalDocumentation != null) {
            this.medicalDocumentation = medicalDocumentation;
        }
    }

    public void addVisitToDocumentation(Visit visit) {
        this.medicalDocumentation.add(visit);
    }

    @Override
    public boolean equals(Object o) {
        User other = (User) o;
        return o != null &&
                Objects.equals(this.getLogin(), other.getLogin()) &&
                Objects.equals(this.getPassword(), other.getPassword()) &&
                Objects.equals(this.getName(), other.getName()) &&
                Objects.equals(this.getSurname(), other.getSurname()) &&
                Objects.equals(this.getJob(), other.getJob()) &&
                Objects.equals(this.getRights(), other.getRights()) &&
                this.getMedicalDocumentation().containsAll(other.getMedicalDocumentation());
    }

    @Override
    public User clone() {
        User clone = new User();
        clone.setLogin(this.login);
        clone.setPassword(this.password);
        clone.setName(this.name);
        clone.setSurname(this.surname);
        clone.setJob(this.job);
        clone.setRights(this.rights);
        clone.setMedicalDocumentation(this.medicalDocumentation);
        return clone;
    }

    @Override
    public String toString() {
        return name + " " + surname + "(" + login + "); job: " + job + ", rights: " + rights;
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }
}
