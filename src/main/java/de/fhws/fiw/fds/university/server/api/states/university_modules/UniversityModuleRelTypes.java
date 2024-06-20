package de.fhws.fiw.fds.university.server.api.states.university_modules;

public interface UniversityModuleRelTypes {
	String CREATE_MODULE = "createModuleOfUniversity";
	String GET_ALL_MODULES = "getAllModulesOfUniversity";
	String UPDATE_SINGLE_MODULE = "updateModuleOfUniversity";
	String CREATE_LINK_FROM_UNIVERSITY_TO_MODULE = "linkUniversityToModule";
	String DELETE_LINK_FROM_UNIVERSITY_TO_MODULE = "unlinkUniversityToModule";
	String GET_SINGLE_MODULE = "getModuleByIdOfUniversity";
	String GET_SINGLE_UNIVERSITY = "getSingleUniversity";
	String DELETE_MODULE = "deleteModuleOfUniversity";

}
