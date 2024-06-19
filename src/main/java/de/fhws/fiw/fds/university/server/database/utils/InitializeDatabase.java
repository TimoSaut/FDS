package de.fhws.fiw.fds.university.server.database.utils;


import de.fhws.fiw.fds.university.server.database.DaoFactory;

public class InitializeDatabase {

    public static void initializeDBWithRelations() {
        DaoFactory.getInstance().getUniversityModuleDao().initializeDatabase();
    }
}
