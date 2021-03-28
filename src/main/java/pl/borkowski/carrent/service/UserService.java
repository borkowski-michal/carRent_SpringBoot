package pl.borkowski.carrent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.borkowski.carrent.model.Role;
import pl.borkowski.carrent.model.User;
import pl.borkowski.carrent.repository.RoleRepo;
import pl.borkowski.carrent.repository.UserRepo;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return userRepo.findByFirstName(userName);
    }

    public User saveUser(User user){
        user.setActive(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepo.findByRole("admin");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        return userRepo.save(user);
    }


}
