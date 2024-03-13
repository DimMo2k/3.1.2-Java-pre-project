package dimMo.dao;


import dimMo.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void addUser(User user);

    public void deleteUser(int userId);

    public void updateUser(int id, User user);

    public User getUser(int userId);

}