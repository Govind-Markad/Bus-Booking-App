package com.busBooking.controller;

import com.busBooking.payload.UserDTO;
import com.busBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestParam("firstName") String firstName,
                                              @RequestParam("lastName") String lastName,
                                              @RequestParam("email") String email,
                                              @RequestParam("password") String password,
                                              @RequestParam("phoneNumber") String phoneNumber,
                                              @RequestParam(value = "profileImage",required = false)MultipartFile profileImage) {

        UserDTO createUserDTO = new UserDTO();

        createUserDTO.setFirstName(firstName);
        createUserDTO.setLastName(lastName);
        createUserDTO.setPassword(password);
        createUserDTO.setEmail(email);
        createUserDTO.setProfileImage(profileImage);
        createUserDTO.setPhoneNumber(phoneNumber);


        UserDTO userDto = userService.createUser(createUserDTO);

        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getUsers
            (@PageableDefault(size = 10,sort = "id")Pageable pageable){
        Page<UserDTO> users = userService.getUsers(pageable);

        return  new ResponseEntity<>(users,HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId){

        userService.deleteUser(userId);
        return  new ResponseEntity<>("User is deleted",HttpStatus.OK);
    }

    @PutMapping("/profile/{userId}")
    public ResponseEntity<UserDTO> updateUserProfile(@PathVariable ("userId")Long userId,
                                              @RequestParam(value = "profileImage",required = false)MultipartFile profileImage) {

        UserDTO createUserDTO = new UserDTO();

        createUserDTO.setProfileImage(profileImage);

        UserDTO updatedUser = userService.updateUserProfile(userId,profileImage);

        return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable ("userId")Long userId,@RequestBody UserDTO userDTO){

        UserDTO userDto = userService.updateUser(userId, userDTO);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }


}
