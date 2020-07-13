package com.mina.springsecuritydemo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.mina.springsecuritydemo.security.ApplicationUserRole.ADMIN;
import static com.mina.springsecuritydemo.security.ApplicationUserRole.ADMINTRAINEE;
import static com.mina.springsecuritydemo.security.ApplicationUserRole.STUDENT;


@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUser().stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUser() {
        return Lists.newArrayList(
                new ApplicationUser(
                        "annasmith",
                        passwordEncoder.encode("password"),
                        STUDENT.getAuthorityGranters(),
                        true,
                        true,
                        true,
                        true
                ), new ApplicationUser(
                        "linda",
                        passwordEncoder.encode("password"),
                        ADMIN.getAuthorityGranters(),
                        true,
                        true,
                        true,
                        true
                ), new ApplicationUser(
                        "tom",
                        passwordEncoder.encode("password"),
                        ADMINTRAINEE.getAuthorityGranters(),
                        true,
                        true,
                        true,
                        true
                )
        );
    }
}
