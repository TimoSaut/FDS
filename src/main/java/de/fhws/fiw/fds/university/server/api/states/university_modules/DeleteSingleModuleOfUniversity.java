package de.fhws.fiw.fds.university.server.api.states.university_modules;

import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.delete.AbstractDeleteRelationState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;
import de.fhws.fiw.fds.university.server.api.models.Modules;
import de.fhws.fiw.fds.university.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;

public class DeleteSingleModuleOfUniversity extends AbstractDeleteRelationState<Response, Modules> {

    public DeleteSingleModuleOfUniversity(ServiceContext serviceContext, long modelIdToDelete, long primaryId) {
        super(serviceContext, modelIdToDelete, primaryId);
        this.suttonResponse = new JerseyResponse<>();
    }


    @Override
    protected SingleModelResult<Modules> loadModel() {
        return DaoFactory.getInstance().getUniversityModuleDao().readById(this.primaryId, this.modelIdToDelete);
    }

    @Override
    protected NoContentResult deleteModel() {
        return DaoFactory.getInstance().getUniversityModuleDao().deleteRelation(this.primaryId, this.modelIdToDelete);
    }

    @Override
    protected void defineTransitionLinks() {
        addLink(UniversityModuleUri.REL_PATH,
                UniversityModuleRelTypes.GET_ALL_LINKED_MODULES,
                getAcceptRequestHeader(),
                this.primaryId);
    }
}
