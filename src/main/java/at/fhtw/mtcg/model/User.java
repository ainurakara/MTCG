package at.fhtw.mtcg.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class User {
    @JsonAlias({"id"})
    private Integer id = 0;
    @JsonAlias({"username"})
    private String username;

    private int coins;


    @JsonAlias({"password"})
    private String password;

    // Jackson needs the default constructor
    public User() {}

    public User(String username, String password) {
      this.id++;
      setUsername(username);
      setPassword(password);
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
