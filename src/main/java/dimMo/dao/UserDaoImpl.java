package dimMo.dao;


import dimMo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user ", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int userId) {
        User ent1 = entityManager.find(User.class, userId);
        if (ent1 == null) {
            throw new EntityNotFoundException("No this user!");
        } else {
            entityManager.remove(ent1);
        }
    }

    @Override
    public void updateUser(int userId, User userUpdate) {
        User ent1 = entityManager.find(User.class, userId);
        if (ent1 == null) {
            throw new EntityNotFoundException("No this user!");
        } else {
            User user = getUser(userId);
            user.setName(userUpdate.getName());
            user.setSurname(userUpdate.getSurname());
        }
    }

    @Override
    public User getUser(int userId) {
        User ent1 = entityManager.find(User.class, userId);
        if (ent1 == null) {
            throw new EntityNotFoundException();
        } else {
            return ent1;
        }
    }
}
