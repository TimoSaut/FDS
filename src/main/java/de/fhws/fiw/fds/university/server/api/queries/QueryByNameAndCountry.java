package de.fhws.fiw.fds.university.server.api.queries;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.university.server.api.models.University;
import de.fhws.fiw.fds.university.server.database.DaoFactory;


public class QueryByNameAndCountry<R> extends AbstractQuery<R, University> {

    private String name;
    private String country;

    public QueryByNameAndCountry(String name, String country, int offset, int size) {
        this.name = name;
        this.country = country;
        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    protected CollectionModelResult<University> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
        return DaoFactory.getInstance().getUniversityDao().readByNameAndCountry(
                this.name,
                this.country,
                searchParameter);
    }

}
