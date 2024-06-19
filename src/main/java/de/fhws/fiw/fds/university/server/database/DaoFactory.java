package de.fhws.fiw.fds.university.server.database;


import de.fhws.fiw.fds.university.server.database.inmemory.ModuleStorage;
import de.fhws.fiw.fds.university.server.database.inmemory.UniversityModuleStorage;
import de.fhws.fiw.fds.university.server.database.inmemory.UniversityStorage;

public class DaoFactory {

    private static DaoFactory INSTANCE;

    public static DaoFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DaoFactory();
        }

        return INSTANCE;
    }

    private final UniversityDao universityDao;

    private final ModuleDao moduleDao;

    private final UniversityModuleDao universityModuleDao;

    private DaoFactory() {
        this.universityDao = new UniversityStorage();
        this.moduleDao = new ModuleStorage();
        this.universityModuleDao = new UniversityModuleStorage(this.moduleDao);
    }

    public UniversityDao getUniversityDao() {
        return this.universityDao;
    }

    public ModuleDao getModuleDao() { return this.moduleDao;
    }

    public UniversityModuleDao getUniversityModuleDao() {
        return universityModuleDao;
    }
}
