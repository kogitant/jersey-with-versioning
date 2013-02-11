package com.ricardoborillo.test.services.rest.v1;

import java.util.Collections;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ricardoborillo.test.db.UserDTO;
import com.ricardoborillo.test.services.UsersService;
import com.ricardoborillo.test.services.common.RestResponse;
import com.sun.jersey.api.core.InjectParam;

@Path("/v1/users")
public class UsersResourceV1
{
    @InjectParam
    private UsersService usersService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse getAll()
    {
        return new RestResponse(1, true, UserConverter.convert(usersService.getUsuarios()));
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse remove(@PathParam("id") String id)
    {
        usersService.removeUser(Integer.parseInt(id));
        return new RestResponse(1, true);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse add(User user)
    {
        UserDTO newUser = usersService.addUser(UserConverter.convert(user));
        return new RestResponse(1, true, Collections.singletonList(UserConverter.convert(newUser)));
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse update(User user)
    {
        UserDTO currentUser = usersService.find(user.getId());
        UserDTO updatedUser = UserConverter.convert(user);
        // This would be lost in the update if we don't explicitly preserve it
        updatedUser.setAddress(currentUser.getAddress());
        usersService.updateUser(updatedUser);
        return new RestResponse(1, true, Collections.singletonList(UserConverter.convert(updatedUser)));
    }    
}
