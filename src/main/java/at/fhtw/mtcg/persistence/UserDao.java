package at.fhtw.mtcg.persistence;

import at.fhtw.mtcg.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> userData;

    public UserDao() {
        userData = new ArrayList<>();
        userData.add(new User(1,"Ainura","123"));
        userData.add(new User(2,"Daria","456"));
        userData.add(new User(3,"Monica","789"));
    }

    // GET /weather/:id
    public User getUser(Integer ID) {
      User foundUser = userData.stream()
                .filter(user -> ID == user.getId())
                .findAny()
                .orElse(null);

        return foundUser;
    }

    // GET /user
    public List<User> getUser() {
        return userData;
    }

    // POST /user
    public void addUser(User user) {
        userData.add(user);
    }
}
