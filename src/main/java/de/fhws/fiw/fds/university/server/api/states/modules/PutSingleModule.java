package de.fhws.fiw.fds.university.server.api.states.modules;

import de.fhws.fiw.fds.sutton.server.api.caching.CachingUtils;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.put.AbstractPutState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;
import de.fhws.fiw.fds.sutton.server.models.AbstractModel;

import de.fhws.fiw.fds.university.server.api.models.Modules;
import de.fhws.fiw.fds.university.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;

public class PutSingleModule extends AbstractPutState<Response, Modules> {

    public PutSingleModule(ServiceContext serviceContext, long requestedId, Modules modelToUpdate) {
        super(serviceContext, requestedId, modelToUpdate);
    }


    @Override
    protected boolean clientDoesNotKnowCurrentModelState(AbstractModel modelFromDatabase) {
        return this.suttonRequest.clientKnowsCurrentModel(modelFromDatabase);
    }

    @Override
    protected void defineHttpCaching() {
        this.suttonResponse.cacheControl(CachingUtils.create30SecondsPublicCaching());
    }

    @Override protected SingleModelResult<Modules> loadModel( )
    {
        return DaoFactory.getInstance( ).getModuleDao( ).readById( this.modelToUpdate.getId( ) );
    }

    @Override protected NoContentResult updateModel( )
    {
        return DaoFactory.getInstance( ).getModuleDao( ).update( this.modelToUpdate );
    }

    @Override protected void defineTransitionLinks( )
    {
        addLink( ModulesUri.REL_PATH_ID, ModulesRelTypes.GET_SINGLE_MODULE, getAcceptRequestHeader( ),
                this.modelToUpdate.getId( ) );
    }
}
