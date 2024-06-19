package de.fhws.fiw.fds.university.server.api.states.modules;


import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.post.AbstractPostState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.university.server.api.models.Modules;
import de.fhws.fiw.fds.university.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;

public class PostNewModule extends AbstractPostState<Response, Modules>
{
	public PostNewModule(ServiceContext serviceContext, Modules modelToStore) {
		super(serviceContext, modelToStore);
	}


	@Override protected NoContentResult saveModel( )
	{
		return DaoFactory.getInstance( ).getModuleDao( ).create( this.modelToStore );
	}

	@Override protected void defineTransitionLinks( )
	{

	}
}
