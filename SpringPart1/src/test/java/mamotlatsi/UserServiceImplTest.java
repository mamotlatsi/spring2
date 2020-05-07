package mamotlatsi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)



@TestComponent
class UserServiceImplTest {
    @LocalServerPort
    private int localServerPort;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserService userService;
    @Test
    void addUser() {
        assertEquals("mamotlatsi",UserService.addUser(1,"mamotlatsi", "makhate"));
    }

    @Test
    void remove() {
        //void

    }

    @Test
    void getUser() {
        UserService.addUser(1,"mamotlatsi","makhate");
        assertEquals(1,"mamotlatsi","hello");

    }
    @Test
    void testCache() {
        UserService.addUser(1, "mamotlats", "makhate");
        UserService.getUser(1);
        UserService.getUser(1);
        UserService.getUser(1);
        UserService.getUser(1);
    }

    private URL address;
    @BeforeEach
    public void createLink() throws Exception {
        this.address = new URL("http://127.0.0.1:" + localServerPort);
    }
    @Test
    void testSecurity(){
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth("mamotlatsi", "mathatha").getForEntity(address.toString(), String.class);
        assertEquals(HttpStatus.Series.CLIENT_ERROR, responseEntity.getStatusCode().series());

    }
}
