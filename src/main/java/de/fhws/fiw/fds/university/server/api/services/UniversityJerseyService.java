package de.fhws.fiw.fds.university.server.api.services;

import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.Exceptions.SuttonWebAppException;
import de.fhws.fiw.fds.sutton.server.api.services.AbstractJerseyService;
import de.fhws.fiw.fds.university.server.api.models.Modules;
import de.fhws.fiw.fds.university.server.api.queries.QueryModuleByUniversity;
import de.fhws.fiw.fds.university.server.api.queries.QueryByNameAndCountry;
import de.fhws.fiw.fds.university.server.api.states.university.*;
import de.fhws.fiw.fds.university.server.api.states.university_modules.*;
import de.fhws.fiw.fds.university.server.database.inmemory.UniversityStorage;
import de.fhws.fiw.fds.university.server.api.models.University;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/universities")
public class UniversityJerseyService extends AbstractJerseyService {
    private UniversityStorage universityStorage = new UniversityStorage();


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllUniversities(
            @DefaultValue("") @QueryParam("name") final String name,
            @DefaultValue("") @QueryParam("lastname") final String country,
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("size") int size) {
        try {
            final var info = new GetAllUniversities(
                    this.serviceContext,
                    new QueryByNameAndCountry<>(name, country, offset, size)
            ).execute();
            return info;
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(e.getExceptionMessage(), e.getStatus().getCode());
        }
    }

    @GET
    @Path("{universityId: \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSingleUniversity(@PathParam("universityId") final long universityId) {
        try {
            return new GetSingleUniversity(this.serviceContext, universityId).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response
                    .status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build()
            );
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createSingleUniversity(final University universityModel) {
        try {
            return new PostNewUniversity(this.serviceContext, universityModel).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }


    @PUT
    @Path("{universityId: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateSingleUniversity(@PathParam("universityId") final long universityId, final University universityModel) {
        try {
            return new PutSingleUniversity(this.serviceContext, universityId, universityModel).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @DELETE
    @Path("{universityId: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deleteSingleUniversity(@PathParam("universityId") final long universityId) {
        try {
            return new DeleteSingleUniversity(this.serviceContext, universityId).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }



    @GET
    @Path("{universityId: \\d+}/module")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getModulesOfUniversity(@PathParam("universityId") final long universityId,
                                         @DefaultValue("0") @QueryParam("offset") int offset,
                                         @DefaultValue("20") @QueryParam("size") int size) {
        try {
            return new GetAllModelsOfUniversity(this.serviceContext, universityId,
                    new QueryModuleByUniversity<>(universityId, offset, size)).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }


    // fehler dataType
    @GET
    @Path("{universityId: \\d+}/module/{moduleId: \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getModuleByIdOfUniversity(@PathParam("universityId") final long universityId,
                                            @PathParam("moduleId") final long moduleId) {
        try {
            return new GetSingleModuleOfUniversity( this.serviceContext, universityId, moduleId ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @POST
    @Path("{universityId: \\d+}/module")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createNewModuleOfUniversity(@PathParam("universityId") final long universityId, final Modules module) {
        try {
            return new PostNewModuleOfUniversity( this.serviceContext, universityId, module ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @PUT
    @Path("{universityId: \\d+}/module/{moduleId: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateNewModuleOfUniversity(@PathParam("universityId") final long universityId,
                                              @PathParam("moduleId") final long moduleId, final Modules module) {
        try {
            return new PutSingleModuleOfUniversity( this.serviceContext, universityId, moduleId, module ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }


    @DELETE
    @Path("{universityId: \\d+}/module/{moduleId: \\d+}")
    public Response deleteModuleOfUniversity(@PathParam("universityId") final long universityId,
                                           @PathParam("moduleId") final long moduleId) {
        try {
            return new DeleteSingleModuleOfUniversity( this.serviceContext, moduleId, universityId ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

}