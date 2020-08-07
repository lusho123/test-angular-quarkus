package telcel.ti.user.exceptions.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import telcel.ti.user.exceptions.UserNotFoundException;

@Provider
public class GlobalHandlerException implements ExceptionMapper<UserNotFoundException> {

    @Override
    public Response toResponse(UserNotFoundException exception) {
        return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
    
}