package com.Rx.ReactJswBootProject;

import com.Rx.ReactJswBootProject.model.User;
import com.Rx.ReactJswBootProject.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser(){
        User user = new User("Ramazan","Ozcan","ozcn.ramazan@gmail.com","ramm","ramm123");
        userRepository.save(user);
        userRepository.findById(Long.valueOf(1))
                .map(newUser ->{
                    Assert.assertEquals("Ramazan",newUser.getName());
                    return true;
                });
    }

    @Test
    public void getUser(){
        User user = new User("Ramazan","Ozcan","ozcn.ramazan@gmail.com","ramm","ramm123");
        User user2 = new User("Osman","Keten","ok@ok.com","ok","okpass");
        userRepository.save(user);

        userRepository.save(user2);

        userRepository.findById(Long.valueOf(1))
                .map(newUser ->{
                    Assert.assertEquals("ram",newUser.getUsername());
                    return true;
                });

    }

    @Test
    public void getUsers(){
        User user = new User("Ramazan","Doe","john.doe@email.com","johhny","strong-password");
        User user2 = new User("Osman","Keten","ok@ok.com","ok","okpass");
        userRepository.save(user);
        userRepository.save(user2);

        Assert.assertNotNull(userRepository.findAll());
    }

    @Test
    public void deleteUser(){
        User user = new User("John","Doe","john.doe@email.com","johhny","strong-password");
        userRepository.save(user);
        userRepository.delete(user);
        Assert.assertTrue(userRepository.findAll().isEmpty());
    }


}
