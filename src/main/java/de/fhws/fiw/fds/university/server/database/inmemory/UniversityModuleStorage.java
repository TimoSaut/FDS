package de.fhws.fiw.fds.university.server.database.inmemory;

import de.fhws.fiw.fds.sutton.server.database.IDatabaseAccessObject;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.inmemory.AbstractInMemoryRelationStorage;
import de.fhws.fiw.fds.sutton.server.database.inmemory.InMemoryPaging;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.university.server.api.models.Modules;
import de.fhws.fiw.fds.university.server.database.ModuleDao;
import de.fhws.fiw.fds.university.server.database.UniversityModuleDao;


public class UniversityModuleStorage extends AbstractInMemoryRelationStorage<Modules> implements UniversityModuleDao {
    final private ModuleDao locationStorage;

    public UniversityModuleStorage(ModuleDao locationStorage) {
        this.locationStorage = locationStorage;
    }

    @Override
    protected IDatabaseAccessObject<Modules> getSecondaryStorage() {
        return this.locationStorage;
    }

    @Override
    public CollectionModelResult<Modules> readByName(long primaryId, String name, SearchParameter searchParameter) {
        return InMemoryPaging.page(
                this.readAllLinkedByPredicate(primaryId, (p) -> name.isEmpty() || p.getName().equals(name)),
                searchParameter.getOffset(), searchParameter.getSize()
        );
    }

    @Override
    public CollectionModelResult<Modules> readAllLinked(long primaryId, SearchParameter searchParameter) {
        return InMemoryPaging.page(
                this.readAllLinkedByPredicate(primaryId, (p) -> true),
                searchParameter.getOffset(), searchParameter.getSize()
        );
    }

    @Override
    public void resetDatabase() {

    }

    @Override
    public void initializeDatabase() {

    }
}
