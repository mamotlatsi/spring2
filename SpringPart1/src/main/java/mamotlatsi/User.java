package mamotlatsi;

public class User {
    private long id;
    private String name;
    private String surname;
    // add constructor, getter and setter

    public User(long id , String name , String surname ){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setId()
    {
        id= id;
    }

    public void setName() {
        name = name ;
    }

    public String setSurname() {
        return surname;
    }
}


