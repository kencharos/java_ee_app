package jp.co.ulsystems.app.rs.login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.ulsystems.app.rs.ListWrapper;

/**
 *
 */
@Path("notifications")
@RequestScoped
public class WelcomeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ListWrapper notifications() {
        return new ListWrapper(Arrays.asList("This is JAX-RS app", "note.."));
    }
    
}
