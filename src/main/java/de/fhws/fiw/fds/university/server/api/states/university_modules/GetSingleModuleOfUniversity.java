package de.fhws.fiw.fds.university.server.api.states.university_modules;


import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetRelationState;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;
import de.fhws.fiw.fds.university.server.api.models.Modules;

import de.fhws.fiw.fds.university.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;

public class GetSingleModuleOfUniversity extends AbstractGetRelationState<Response, Modules> {

    public GetSingleModuleOfUniversity(ServiceContext serviceContext, long primaryId, long universityId) {
        super(serviceContext, primaryId, universityId);
        this.suttonResponse = new JerseyResponse<>();
    }

    @Override
    protected SingleModelResult<Modules> loadModel() {
        SingleModelResult<Modules> location = DaoFactory.getInstance( ).getModuleDao( ).readById( this.requestedId );
        if(isUniversityLinkedToThisModule()) {
            location.getResult().setPrimaryId(this.primaryId);
        }
        return location;
    }

    private boolean isUniversityLinkedToThisModule() {
        return !DaoFactory.getInstance( )
                .getUniversityModuleDao( )
                .readById( this.primaryId, this.requestedId )
                .isEmpty( );
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
    }
//
//    @Override
//    protected void defineTransitionLinks() {
//        addLink(UniversityModuleUri.REL_PATH,
//                UniversityModuleRelTypes.CREATE_MODULE,
//        getAcceptRequestHeader(),
//                this.primaryId);
//
//
//        addLink(UniversityModuleUri.REL_PATH_SHOW_ALL,
//                UniversityModuleRelTypes.GET_ALL_MODULES,
//                getAcceptRequestHeader(),
//                this.primaryId);
//
//    }

}