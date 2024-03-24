package hiber.service;

import hiber.model.*;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    User getUserByCar(String model, int series);

}
