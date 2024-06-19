package de.fhws.fiw.fds.university.server.database;

import de.fhws.fiw.fds.sutton.server.database.IDatabaseRelationAccessObject;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.university.server.api.models.Modules;

public interface UniversityModuleDao extends IDatabaseRelationAccessObject<Modules> {

    CollectionModelResult<Modules> readByName(long primaryId, String name, SearchParameter searchParameter);

    void initializeDatabase();

    void resetDatabase();

}
