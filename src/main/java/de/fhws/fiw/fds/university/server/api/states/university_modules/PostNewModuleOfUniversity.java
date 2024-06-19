package de.fhws.fiw.fds.university.server.api.states.university_modules;

import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.post.AbstractPostRelationState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.university.server.api.models.Modules;
import de.fhws.fiw.fds.university.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;

public class PostNewModuleOfUniversity extends AbstractPostRelationState<Response, Modules> {

    public PostNewModuleOfUniversity(ServiceContext serviceContext, long primaryId, Modules modelToStore) {
        super(serviceContext, primaryId, modelToStore);
        this.suttonResponse = new JerseyResponse<>();
    }


    @Override protected NoContentResult saveModel( )
    {
        return DaoFactory.getInstance( ).getUniversityModuleDao( ).create( this.primaryId, this.modelToStore );
    }

    @Override protected void defineTransitionLinks( )
    {
    addLink(UniversityModuleUri.REL_PATH_ID, UniversityModuleRelTypes.GET_SINGLE_MODULE);
    }
}
