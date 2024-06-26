package de.fhws.fiw.fds.university.server.api.states.dispatcher;

import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetDispatcherState;
import de.fhws.fiw.fds.university.server.api.states.university.UniversityRelTypes;
import de.fhws.fiw.fds.university.server.api.states.university.UniversityUri;
import jakarta.ws.rs.core.Response;

public class GetDispatcher extends AbstractGetDispatcherState<Response> {

    public GetDispatcher(ServiceContext serviceContext) {
        super(serviceContext);
        this.suttonResponse = new JerseyResponse<>();
    }

    @Override
    protected void defineTransitionLinks() {
        addLink(UniversityUri.REL_PATH, UniversityRelTypes.GET_ALL_UNIVERSITIES, getAcceptRequestHeader());
        addLink(UniversityUri.REL_PATH, UniversityRelTypes.CREATE_UNIVERSITY, getAcceptRequestHeader());
    }
}
