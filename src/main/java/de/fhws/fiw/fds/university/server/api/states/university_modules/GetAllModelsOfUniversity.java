package de.fhws.fiw.fds.university.server.api.states.university_modules;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractRelationQuery;
import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetCollectionRelationState;
import de.fhws.fiw.fds.university.server.api.models.Modules;
import jakarta.ws.rs.core.Response;

public class GetAllModelsOfUniversity extends AbstractGetCollectionRelationState<Response, Modules> {

    public GetAllModelsOfUniversity(ServiceContext serviceContext, long primaryId, AbstractRelationQuery<Response, Modules> query) {
        super(serviceContext, primaryId, query);
        this.suttonResponse = new JerseyResponse<>();
    }

    @Override
    protected void defineTransitionLinks() {
        addLink(UniversityModuleUri.REL_PATH,
                UniversityModuleRelTypes.CREATE_MODULE,
                getAcceptRequestHeader(),
                this.primaryId);


        addLink(UniversityModuleUri.REL_PATH_SHOW_ALL,
                UniversityModuleRelTypes.GET_ALL_MODULES,
                getAcceptRequestHeader(),
                this.primaryId);

        addLink(UniversityModuleUri.REL_PATH_ID, UniversityModuleRelTypes.GET_SINGLE_MODULE, getAcceptRequestHeader());
    }
}
