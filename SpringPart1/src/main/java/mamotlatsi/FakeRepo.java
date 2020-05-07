package mamotlatsi;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository

public class FakeRepo implements FakeRepoInterface {
    //Create an object array of type User
    private final ArrayList<User> User = new ArrayList<>();

    @Override
    public int insertUser(long id, String name, String surname) {
        User.add(new User(id, name, surname));
        return 1;
    }

    @Override
    public User findUserById(long id) {

        return null;
    }

    @Override
    public String  deleteUser(long id) {
        for (User value : User) {
            if (value.getId() == id) {
                return value.getName();
            }
        }
        return null;
    }}