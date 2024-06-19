package de.fhws.fiw.fds.university.server.database;

import de.fhws.fiw.fds.sutton.server.database.IDatabaseAccessObject;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.university.server.api.models.University;


public interface UniversityDao extends IDatabaseAccessObject<University> {

    CollectionModelResult<University> readByNameAndCountry(String name, String country,
                                                                 SearchParameter searchParameter);

    void resetDatabase();
}
