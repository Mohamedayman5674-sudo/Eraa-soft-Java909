package item.service;

import item.model.User;

public interface UserService {
    boolean signup(User user);
    User login(String email, String password);
}
