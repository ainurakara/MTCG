package at.fhtw.mtcg.persistence.repository;

import at.fhtw.httpserver.server.Request;
import at.fhtw.mtcg.persistence.DataAccessException;
import at.fhtw.mtcg.persistence.UnitOfWork;
import at.fhtw.mtcg.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UserRepositoryImpl implements UserRepository {
    private UnitOfWork unitOfWork;

    public UserRepositoryImpl(UnitOfWork unitOfWork)
    {

        this.unitOfWork = unitOfWork;
    }

    @Override
    public User findById(int id) {
        try (PreparedStatement preparedStatement =
                     this.unitOfWork.prepareStatement("""
                    select * from public.user
                    where id = 1
                """))
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while(resultSet.next())
            {
                user = new User(
                        resultSet.getString(2),
                        resultSet.getString(3));
            };
            return user;
        } catch (SQLException e) {
            throw new DataAccessException("Select nicht erfolgreich", e);
        }
    }

    @Override
    public Collection<User> findAllUser() {
        try (PreparedStatement preparedStatement =
                     this.unitOfWork.prepareStatement("""
                    select * from user
                    where username = ?
                """))
        {
            preparedStatement.setString(1, "Europe");
            ResultSet resultSet = preparedStatement.executeQuery();
            Collection<User> userRows = new ArrayList<>();
            while(resultSet.next())
            {
                User user = new User(
                        resultSet.getString(2),
                        resultSet.getString(3));
                userRows.add(user);
            }

            return userRows;
        } catch (SQLException e) {
            throw new DataAccessException("Select nicht erfolgreich", e);
        }
    }

    @Override
    public boolean addUser (Request request){

        String username = request.getParams();
        String pwd = request.getParams();

        try (PreparedStatement preparedStatement = this.unitOfWork.prepareStatement("insert into user (username, password) values (?,?)")) {
            preparedStatement.setString(1, username );
            preparedStatement.setString(2, pwd);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
