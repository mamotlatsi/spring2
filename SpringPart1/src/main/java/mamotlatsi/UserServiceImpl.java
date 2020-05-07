package mamotlatsi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;


@Service

public class UserServiceImpl implements UserService {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(UserServiceImpl.class);
    UserServiceImpl UserService = ctx.getBean("UserServiceImpl", UserServiceImpl.class);
    private FakeRepo fakeRepo;

    @Autowired
    public UserServiceImpl(@Qualifier("FakeRepo") FakeRepo fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    public String addUser(int id, String name, String surname) {
        return null;
    }

    @Override
    public void remove(long id) {

    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Cacheable
    public int getUser(long id) {
            String change = String.format("hello [%s]", fakeRepo.findUserById(id));
            System.out.println(change);
            System.out.println();

            try {
                System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 1;
        }
    }
