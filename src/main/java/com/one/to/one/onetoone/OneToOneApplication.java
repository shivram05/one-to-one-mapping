package com.one.to.one.onetoone;

import com.one.to.one.onetoone.model.Gender;
import com.one.to.one.onetoone.model.User;
import com.one.to.one.onetoone.model.UserProfile;
import com.one.to.one.onetoone.repository.UserProfileRepository;
import com.one.to.one.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;
    public static void main(String[] args) {
        SpringApplication.run(OneToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setName("shivram shrestha");
        user.setEmail("shivramshrestha01@gmail.com");

        UserProfile userProfile = new UserProfile();
        userProfile.setAddress("5319 Prairie Sage Ln");
        userProfile.setPhoneNumber("9811078948");
        userProfile.setDateOfBirth(LocalDate.of(1995,06,30));
        userProfile.setGender(Gender.MALE);


        user.setUserProfile(userProfile);
        userProfile.setUser(user);

        userRepository.save(user);
    }
}
