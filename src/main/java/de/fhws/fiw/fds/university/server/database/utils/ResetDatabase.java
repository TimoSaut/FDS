package de.fhws.fiw.fds.university.server.database.utils;


import de.fhws.fiw.fds.university.server.database.DaoFactory;

public class ResetDatabase {

    public static void resetAll() {
        DaoFactory.getInstance().getUniversityDao().resetDatabase();
    }

}
