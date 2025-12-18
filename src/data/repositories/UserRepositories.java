package data.repositories;

import data.models.User;

public interface UserRepositories {


    long getCount();

    void save(User user);

    int findById(User user);

    User findUserById(int Id);

}
