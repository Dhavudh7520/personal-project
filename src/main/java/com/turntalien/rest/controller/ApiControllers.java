package com.turntalien.rest.controller;

import com.turntalien.rest.models.User;
import com.turntalien.rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping("/users")
    public List<User> getUsers( ) {
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "saved...";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);

        return "updated..";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);

        return "user deleted with id" + id;
    }
}
