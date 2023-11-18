package com.visualflow.webapp.repoTest;

import com.visualflow.webapp.model.User;
import com.visualflow.webapp.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

/*
1. @DataJpaTest: In order to use data JPA test we need to use the following annotation.
2. @AutoConfigureTestDatabase: In order to run test against to real database we need to use the following annotation.
3. replace = AutoConfigureTestDatabase.Replace.NONE: Means Test will be executed against to real database instead of the default in memory database.
4. @Rollback(value = false) = We want to keep the data that will be committed to the database, so we need to use the following annotation.
*/
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired private UserRepository userRepository;

    @Test
    public void addNewUserTest(){
        User user = new User();
        user.setEmail("Hinata@gmail.com");
        user.setFirstName("Hinata");
        user.setLastName("Yagami");
        user.setPassword("kof97");

        User saved = userRepository.save(user);

        Assertions.assertThat(saved).isNotNull();
        Assertions.assertThat(saved.getId()).isGreaterThan(0);
    }

    @Test
    public void AllListTest(){
        Iterable<User> users = userRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user:
             users) {
            System.out.println(user);
        }
    }

    @Test
    public void updateUserInfoTest(){
        Integer id = 3;
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        user.setFirstName("Kio");
        user.setLastName("Kushanagi");
        user.setPassword("kof2002");
        userRepository.save(user);

        User updateUser = userRepository.findById(id).get();
        Assertions.assertThat(updateUser.getFirstName()).isEqualTo("Kio");
        Assertions.assertThat(updateUser.getLastName()).isEqualTo("Kushanagi");
    }

    @Test
    public void getTheUserTest(){
        Integer id = 2;
        Optional<User> user = userRepository.findById(id);
        Assertions.assertThat(user).isPresent();
        System.out.println(user.get());
    }

    @Test
    public void deleteUserTest(){
        Integer id = 3;
        userRepository.deleteById(id);
        Optional<User> user = userRepository.findById(id);
        Assertions.assertThat(user).isNotPresent();
    }
}
