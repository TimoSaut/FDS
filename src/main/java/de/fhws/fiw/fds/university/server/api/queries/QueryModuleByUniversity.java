package de.fhws.fiw.fds.university.server.api.queries;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractRelationQuery;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.university.server.api.models.Modules;
import de.fhws.fiw.fds.university.server.database.DaoFactory;


public class QueryModuleByUniversity<R> extends AbstractRelationQuery<R, Modules> {



    public QueryModuleByUniversity(long primaryId, int offset, int size) {
        super(primaryId);
        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
    }


    @Override
    protected CollectionModelResult<Modules> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
        return DaoFactory.getInstance().getUniversityModuleDao().readAllLinked(this.primaryId, searchParameter);
    }
}
