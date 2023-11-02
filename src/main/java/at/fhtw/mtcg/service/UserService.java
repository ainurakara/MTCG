package at.fhtw.mtcg.service;

import at.fhtw.httpserver.http.ContentType;
import at.fhtw.httpserver.http.HttpStatus;
import at.fhtw.httpserver.server.Request;
import at.fhtw.httpserver.server.Response;
import at.fhtw.mtcg.model.User;
import at.fhtw.mtcg.persistence.UnitOfWork;
import at.fhtw.mtcg.persistence.repository.UserRepository;
import at.fhtw.mtcg.persistence.repository.UserRepositoryImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class UserService extends AbstractService {

    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepositoryImpl(new UnitOfWork());
    }

    // GET /user(:id
    public Response getUser(String id)
    {
        System.out.println("get user for id: " + id);
        User user = userRepository.findById(Integer.parseInt(id));
        String json = null;
        try {
            json = this.getObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new Response(HttpStatus.OK, ContentType.JSON, json);
    }

    // POST /user
    public Response addUser(Request request) {

        System.out.println("add " + request.getParams() + "to  database");
        if (this.userRepository.addUser(request))
        {
            return new Response(HttpStatus.OK);
        }
        else
        {
            return new Response(HttpStatus.CONFLICT);
        }
    }

    // GET /user
    public Response getUserPerRepository() {
        System.out.println("getUserPerRepository");
        User user = new User("Ainura", "123");
        String json = null;
        try {
            json = this.getObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new Response(HttpStatus.OK, ContentType.JSON, json);
    }
}
