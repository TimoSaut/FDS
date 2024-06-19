package de.fhws.fiw.fds.university;



import de.fhws.fiw.fds.sutton.server.api.AbstractJerseyApplication;
import de.fhws.fiw.fds.university.server.api.services.DispatcherJerseyService;
import de.fhws.fiw.fds.university.server.api.services.UniversityJerseyService;
import jakarta.ws.rs.ApplicationPath;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class SuttonUniversityJerseyApplication extends AbstractJerseyApplication {

    @Override
    protected Set<Class<?>> getServiceClasses() {
        final Set<Class<?>> returnValue = new HashSet<>();


        returnValue.add(UniversityJerseyService.class);
        returnValue.add(DispatcherJerseyService.class);

        return returnValue;
    }

}
