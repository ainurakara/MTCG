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

    // GET /weather(:id
    public Response getUser(String id)
    {
        System.out.println("get weather for id: " + id);
        User user = userRepository.findById(Integer.parseInt(id));
        String json = null;
        try {
            json = this.getObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new Response(HttpStatus.OK, ContentType.JSON, json);
    }
    // GET /weather
    public Response getUser() {
        return new Response(HttpStatus.NOT_IMPLEMENTED);
    }

    // POST /weather
    public Response addUser(Request request) {
        return new Response(HttpStatus.NOT_IMPLEMENTED);
    }

    // GET /weather
    public Response getUserPerRepository() {
        System.out.println("getUserPerRepository");
        User user = new User(1, "Ainura", "123");
        String json = null;
        try {
            json = this.getObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new Response(HttpStatus.OK, ContentType.JSON, json);
    }
}
