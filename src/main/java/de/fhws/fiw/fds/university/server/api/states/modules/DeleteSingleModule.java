package de.fhws.fiw.fds.university.server.api.states.modules;

import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.delete.AbstractDeleteState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;
import de.fhws.fiw.fds.university.server.api.models.Modules;
import de.fhws.fiw.fds.university.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;

public class DeleteSingleModule extends AbstractDeleteState<Response, Modules> {

    public DeleteSingleModule(ServiceContext serviceContext, long modelIdToDelete) {
        super(serviceContext, modelIdToDelete);
    }


    @Override protected SingleModelResult<Modules> loadModel( )
    {
        return DaoFactory.getInstance( ).getModuleDao( ).readById( this.modelIdToDelete );
    }

    @Override protected NoContentResult deleteModel( )
    {
        DaoFactory.getInstance( ).getUniversityModuleDao( ).deleteRelationsToSecondary( this.modelIdToDelete );
        return DaoFactory.getInstance( ).getUniversityDao( ).delete( this.modelIdToDelete );
    }

    @Override protected void defineTransitionLinks( )
    {
        addLink( ModulesUri.REL_PATH, ModulesRelTypes.GET_ALL_MODULE, getAcceptRequestHeader( ) );
    }
}
