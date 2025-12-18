package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserRepositoriesImplTest {
    UserRepositories repositories;
    private User user1;
    private User user2;

    @BeforeEach
    public void setUp() {
        repositories = new UserRepositoriesImpl();
        user1 = new User();

        user1.setName("Ekwe");
        user1.setAddress("234 Semicolon Street");
        user1.setPhone(545234);

        user2 = new User();
        user2.setName("charlie");
        user2.setAddress("234 Semicolon Street");
        user2.setPhone(34234);

    }

    @Test
    public void user_repository_is_empty() {
        assertEquals(0, repositories.getCount());
    }

    @Test
    public void saveUser_countIsOne_test() {
        repositories.save(user1);
        assertEquals(1, repositories.getCount());
    }

    @Test
    public void saveUser_assignIdToUser_test() {
        repositories.save(user1);
        user1.setId(1);

        assertEquals(1, user1.getId());
        assertEquals(1, repositories.getCount());

    }

    @Test
    public void saveTwoUsers_assignIdToUser_test() {
        repositories.save(user1);
        repositories.save(user2);
        user1.setId(1);
        user2.setId(2);

        assertEquals(1, user1.getId());
        assertEquals(2, user2.getId());

        assertEquals(2, repositories.getCount());
    }

    @Test
    public void saveUser_findUserById_test(){
        repositories.save(user1);
        repositories.save(user2);
        user1.setId(1);
        user2.setId(2);

        User foundUser = repositories.findUserById(1);
        assertEquals(1, foundUser.getId());
        assertEquals("Ekwe", foundUser.getName());
    }
    @Test
    public void saveUser_findUserBy_invalidId_test(){
        repositories.save(user1);
        repositories.save(user2);

        user1.setId(1);
        user2.setId(2);

        User foundUser = repositories.findUserById(8);
        assertNull(foundUser);
    }



}