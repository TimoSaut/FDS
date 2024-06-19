package de.fhws.fiw.fds.university.server.api.states.modules;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetCollectionState;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.university.server.api.models.Modules;
import de.fhws.fiw.fds.university.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;

public class GetAllModules extends AbstractGetCollectionState<Response, Modules> {
    public GetAllModules(ServiceContext serviceContext, AbstractQuery<Response, Modules> query) {
        super(serviceContext, query);
    }


    @Override
    protected void defineTransitionLinks() {
        addLink(ModulesUri.REL_PATH, ModulesRelTypes.CREATE_MODULE, getAcceptRequestHeader());
    }

    public static class AllLocations<R> extends AbstractQuery<R, Modules> {
        @Override
        protected CollectionModelResult<Modules> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
            return DaoFactory.getInstance().getModuleDao().readAll();
        }
    }
}
