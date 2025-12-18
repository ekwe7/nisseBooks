package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoriesImpl implements UserRepositories {

    private List<User> users = new ArrayList<>();
    private int count;

    @Override
    public long getCount() {
        return users.size();
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
    @Override
    public int findById(User user) {
        return user.getId();
    }

    @Override
    public User findUserById(int Id) {
        for(User user : users){
            if(user.getId() == Id){
                return user;
            }
        }
        return null;
    }

}
