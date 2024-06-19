// Copyright 2022 Peter Braun
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package de.fhws.fiw.fds.university.client.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.fhws.fiw.fds.sutton.client.converters.ClientLinkJsonConverter;
import de.fhws.fiw.fds.sutton.client.model.AbstractClientModel;
import de.fhws.fiw.fds.sutton.client.utils.Link;



public class UniversityClientModel extends AbstractClientModel {

    private String name;
    private String country;

    private String departmentName;
    private String departmentUrl;
    private String contactPerson;
    private int possibleStudentsToSend;
    private int possibleStudentsToReceive;
    private String springSemesterStart;
    private String autumnSemesterStart;

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private Link selfLink;

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private Link modules;

    public UniversityClientModel() {
    }

    public UniversityClientModel(String name, String country, String departmentName, String departmentUrl, String contactPerson, int possibleStudentsToSend, int possibleStudentsToReceive, String springSemesterStart, String autumnSemesterStart, Link selfLink, Link location) {
        this.name = name;
        this.country = country;
        this.departmentName = departmentName;
        this.departmentUrl = departmentUrl;
        this.contactPerson = contactPerson;
        this.possibleStudentsToSend = possibleStudentsToSend;
        this.possibleStudentsToReceive = possibleStudentsToReceive;
        this.springSemesterStart = springSemesterStart;
        this.autumnSemesterStart = autumnSemesterStart;
        this.selfLink = selfLink;
        this.modules = location;
    }

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

    public void setSelfLink(Link selfLink) {
        this.selfLink = selfLink;
    }

    public Link getModules() {
        return modules;
    }

    public void setModules(Link modules) {
        this.modules = modules;
    }

    @JsonIgnore
    public Link getSelfLink() {
        return selfLink;
    }

    @JsonIgnore
    public Link getLocation() {
        return modules;
    }

    @Override
    public String toString() {
        return "UniversityClientModel{" +
                "location=" + modules +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentUrl='" + departmentUrl + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", possibleStudentsToSend=" + possibleStudentsToSend +
                ", possibleStudentsToReceive=" + possibleStudentsToReceive +
                ", springSemesterStart='" + springSemesterStart + '\'' +
                ", autumnSemesterStart='" + autumnSemesterStart + '\'' +
                ", selfLink=" + selfLink +
                '}';
    }
}
