package de.fhws.fiw.fds.university.server.api.states.modules;

import de.fhws.fiw.fds.university.Start;

public interface ModulesUri
{
	String PATH_ELEMENT = "modules";
	String REL_PATH = Start.CONTEXT_PATH + "/api/" + PATH_ELEMENT;
	String REL_PATH_ID = REL_PATH + "/{id}";
}
