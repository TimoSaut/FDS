package de.fhws.fiw.fds.university.server.api.states.university;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetCollectionState;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;
import de.fhws.fiw.fds.university.server.api.models.University;
import de.fhws.fiw.fds.university.server.api.states.university_modules.UniversityModuleRelTypes;
import de.fhws.fiw.fds.university.server.api.states.university_modules.UniversityModuleUri;
import de.fhws.fiw.fds.university.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;

public class GetAllUniversities extends AbstractGetCollectionState<Response, University> {

    public GetAllUniversities(ServiceContext serviceContext, AbstractQuery<Response, University> query) {
        super(serviceContext, query);
        this.suttonResponse = new JerseyResponse<>();
    }
//    @Override
//    protected SingleModelResult<University> loadModel() {
//        return DaoFactory.getInstance().getUniversityDao().readById(this.requestedId);
//    }

    @Override
    protected void defineTransitionLinks() {
        addLink(UniversityUri.REL_PATH, UniversityRelTypes.CREATE_UNIVERSITY, getAcceptRequestHeader());
        addLink( UniversityUri.REL_PATH, UniversityRelTypes.GET_FILTERED_UNIVERSITIES, getAcceptRequestHeader());
    }
}
