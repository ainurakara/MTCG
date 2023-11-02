package at.fhtw.mtcg.persistence.repository;

import at.fhtw.httpserver.server.Request;
import at.fhtw.mtcg.model.User;

import java.util.Collection;

public interface UserRepository {

    User findById(int id);
    Collection<User> findAllUser();

    boolean addUser(Request request);

}
