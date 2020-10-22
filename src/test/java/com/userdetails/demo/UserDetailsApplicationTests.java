package com.userdetails.demo;

import com.userdetails.demo.dataaccess.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;


@SpringBootTest(classes = UserDetailsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserDetailsApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    void contextLoads() {
    }
    @Test
    public void testGetAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
                HttpMethod.GET, entity, String.class);
        Assert.notNull(response.getBody());

       // Assert.assertNotNull(response.getBody());
    }
    @Test
    public void testGetUserById() {
        User user = restTemplate.getForObject(getRootUrl() + "/users/0123456", User.class);
        System.out.println(user.getFirstName());
        Assert.notNull(user);
    }
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setCity("city");
        user.setUserId("7");
        user.setFirstName("Raghavan");
        user.setLastName("karanam");
        user.setGender("Male");
        ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, User.class);
        Assert.notNull(postResponse);
        Assert.notNull(postResponse.getBody());

    }
    @Test
    public void testUpdatePost() {
        String id = "9";
        User user = new User();
        //user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        user.setFirstName("admin1");
        user.setLastName("admin2");


        restTemplate.put(getRootUrl() + "/users/" + id, user);

        User updatedUser = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        Assert.notNull(updatedUser);
    }
}
