package de.fhws.fiw.fds.university.server.database.inmemory;

import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.inmemory.AbstractInMemoryStorage;
import de.fhws.fiw.fds.sutton.server.database.inmemory.InMemoryPaging;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.university.server.api.models.University;
import de.fhws.fiw.fds.university.server.database.UniversityDao;

import java.util.function.Predicate;

public class UniversityStorage extends AbstractInMemoryStorage<University> implements UniversityDao {
    @Override
    public CollectionModelResult<University> readByNameAndCountry(String name, String country, SearchParameter searchParameter) {
        return InMemoryPaging.page(this.readAllByPredicate(
                byNameAndCountry(name, country),
                searchParameter
        ), searchParameter.getOffset(), searchParameter.getSize());
    }

    public void resetDatabase() {
        this.storage.clear();
    }

    private Predicate<University> byNameAndCountry(String name, String country) {
        return p -> (name.isEmpty() || p.getName().contains(name) ) && ( country.isEmpty() || p.getCountry().contains(country));
    }

}
