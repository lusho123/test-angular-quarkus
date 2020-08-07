package telcel.ti.user;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import telcel.ti.user.exceptions.UserNotFoundException;
import telcel.ti.user.model.entity.User;
import telcel.ti.user.model.entity.vo.UserVO;
import telcel.ti.user.service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class test {

    @Inject
    UserService userService;

    @GET
    public Response getUsers() throws UserNotFoundException {
        return Response.ok(userService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") ObjectId id) throws UserNotFoundException {
        return Response.ok(userService.findById(id, null)).build();
    }

    // @GET
    // @Path("/name/{name}")
    // public Response getUserByName(@PathParam("name") String name) throws UserNotFoundException {
    //     return Response.ok(userService.findBy(null, name)).build();
    // }

    @POST
    public Response addUser(User user) throws UserNotFoundException {
        return Response.ok(userService.createUser(user)).build();
    }

    @PUT
    public Response updateUser(UserVO user) throws UserNotFoundException {
        return Response.ok(userService.updateUser(user)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") ObjectId id) throws UserNotFoundException {
        return Response.ok(userService.deleteUser(id)).build();
    }

    @GET
    @Path("/profiles")
    public Response getProfiles() throws UserNotFoundException {
        return Response.ok(userService.getProfiles()).build();
    }

}