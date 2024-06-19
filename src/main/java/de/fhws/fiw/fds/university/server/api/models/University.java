package de.fhws.fiw.fds.university.server.api.models;

import de.fhws.fiw.fds.sutton.server.api.hyperlinks.Link;
import de.fhws.fiw.fds.sutton.server.api.hyperlinks.annotations.SuttonLink;
import de.fhws.fiw.fds.sutton.server.models.AbstractModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class University extends AbstractModel {
    private String name;
    private String country;
    private String departmentName;
    private String departmentUrl;
    private String contactPerson;
    private int possibleStudentsToSend;
    private int possibleStudentsToReceive;
    private String springSemesterStart;
    private String autumnSemesterStart;


    @SuttonLink(
            value = "universities/${id}",
            rel = "self"
    )
    private transient Link selfLink;

    @SuttonLink(
            value = "universities/${id}/module",
            rel = "getModuleOfPerson"
    )
    private transient Link modules;

    // Getter und Setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentUrl() {
        return departmentUrl;
    }

    public void setDepartmentUrl(String departmentUrl) {
        this.departmentUrl = departmentUrl;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getPossibleStudentsToSend() {
        return possibleStudentsToSend;
    }

    public void setPossibleStudentsToSend(int possibleStudentsToSend) {
        this.possibleStudentsToSend = possibleStudentsToSend;
    }

    public int getPossibleStudentsToReceive() {
        return possibleStudentsToReceive;
    }

    public void setPossibleStudentsToReceive(int possibleStudentsToReceive) {
        this.possibleStudentsToReceive = possibleStudentsToReceive;
    }

    public String getSpringSemesterStart() {
        return springSemesterStart;
    }

    public void setSpringSemesterStart(String springSemesterStart) {
        this.springSemesterStart = springSemesterStart;
    }

    public String getAutumnSemesterStart() {
        return autumnSemesterStart;
    }

    public void setAutumnSemesterStart(String autumnSemesterStart) {
        this.autumnSemesterStart = autumnSemesterStart;
    }

    public Link getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(Link selfLink) {
        this.selfLink = selfLink;
    }

    public Link getModules() {
        return modules;
    }

    public void setModules(Link modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", modules=" + modules +
                ", selfLink=" + selfLink +
                ", autumnSemesterStart='" + autumnSemesterStart + '\'' +
                ", springSemesterStart='" + springSemesterStart + '\'' +
                ", possibleStudentsToReceive=" + possibleStudentsToReceive +
                ", possibleStudentsToSend=" + possibleStudentsToSend +
                ", contactPerson='" + contactPerson + '\'' +
                ", departmentUrl='" + departmentUrl + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
