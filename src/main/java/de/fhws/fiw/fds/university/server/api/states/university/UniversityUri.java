package de.fhws.fiw.fds.university.server.api.states.university;


import de.fhws.fiw.fds.university.Start;

public interface UniversityUri {

    String PATH_ELEMENT = "universities";
    String REL_PATH = Start.CONTEXT_PATH + "/api/" + PATH_ELEMENT;
    String REL_PATH_ID = REL_PATH + "/{id}";

}
