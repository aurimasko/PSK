package lt.vu.rest;

import lombok.*;
import lt.vu.entities.Group;
import lt.vu.persistence.GroupsDAO;
import lt.vu.rest.contracts.GroupDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/groups")
public class GroupsController {

    @Inject
    @Setter @Getter
    private GroupsDAO groupsDAO;

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(GroupDTO group) {
        Group newGroup = new Group();
        newGroup.setName(group.getName());
        newGroup.setCity(group.getCity());

        groupsDAO.persist(newGroup);
        return Response.ok(group).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Group group = groupsDAO.findOne(id);
        if (group == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName(group.getName());
        groupDTO.setCity(group.getCity());

        return Response.ok(groupDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer groupId,
            GroupDTO groupData) {
        try {
            Group existingGroup = groupsDAO.findOne(groupId);
            if (existingGroup == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            if(groupData.getName() != null)
                existingGroup.setName(groupData.getName());

            if(groupData.getCity() != null)
                existingGroup.setCity(groupData.getCity());

            groupsDAO.update(existingGroup);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
