package dimMo.dao;


import dimMo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int userId);

    void updateUser(int id, User user);

    User getUser(int userId);

}