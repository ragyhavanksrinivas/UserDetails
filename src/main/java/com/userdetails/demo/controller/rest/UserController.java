package com.userdetails.demo.controller.rest;

import com.userdetails.demo.dataaccess.User;
import com.userdetails.demo.dataaccess.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired private UserDao userRepository;
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
            throws Exception {
        User user =
                userRepository
                        .findById(String.valueOf(userId))
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping("/users")
    public User createUser(@RequestBody User userDab) {
        return userRepository.save(userDab);
    }

    /**
     * Update user response entity.
     *
     * @param userId the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Long userId,@RequestBody com.userdetails.demo.domain.entity.User userDetails)
            throws ResourceNotFoundException {

        User user =
                userRepository
                        .findById(String.valueOf(userId))
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        user.setCity(userDetails.getCity());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setGender(userDetails.getGender());
        user.setTitle(userDetails.getTitle());
        user.setPostcode(userDetails.getPostCode());
        user.setStreet(userDetails.getStreet());
        user.setCity(userDetails.getCity());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }



}
