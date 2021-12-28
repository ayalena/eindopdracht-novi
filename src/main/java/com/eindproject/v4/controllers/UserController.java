package com.eindproject.v4.controllers;

import com.eindproject.v4.exceptions.RecordNotFoundException;
import com.eindproject.v4.model.User;
import com.eindproject.v4.payload.UserPostRequest;
import com.eindproject.v4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
//@RequestMapping("/users")
@PreAuthorize("hasAnyRole('ADMIN')")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @GetMapping("/login")
    public ResponseEntity<Object> loginUser(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(userService.loginUser(email));
    }

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        String newUsername = userService.createUser(user);
//
////        URI location = ServletUriComponentsBuilder
////                .fromCurrentRequest()
////                .path("/{username}")
////                .buildAndExpand(newUsername)
////                .toUri();
//
////        return ResponseEntity.created(location).build();
        return ResponseEntity.created(URI.create(newUsername)).build();

    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody User user) {
        userService.updateUser(username, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
//            throw new BadRequestException();
            throw new RecordNotFoundException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{username}/password")
    public ResponseEntity<Object> setPassword(@PathVariable("username") String username, @RequestBody String password) {
        userService.setPassword(username, password);
        return ResponseEntity.noContent().build();
    }

}
