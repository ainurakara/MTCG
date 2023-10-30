package at.fhtw.mtcg.persistence.repository;

import at.fhtw.mtcg.model.User;

import java.util.Collection;

public interface UserRepository {

    User findById(int id);
    Collection<User> findAllUser();

}
