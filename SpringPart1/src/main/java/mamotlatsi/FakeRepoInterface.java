package mamotlatsi;

public interface FakeRepoInterface {
    int insertUser(long id, String name, String surname);
    User  findUserById(long id);
    String  deleteUser(long id);
}
