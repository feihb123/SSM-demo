package SpringMVC.service;



import SpringMVC.entity.User;

import java.util.List;

public interface RestService {
    List<User> getUsers();

    User get(int id);

    boolean update(String name,int id);

    boolean delete(int id);

    boolean inert(User user);
}
