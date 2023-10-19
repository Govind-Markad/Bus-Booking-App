package com.busBooking.service.impl;

import com.busBooking.entities.User;
import com.busBooking.service.UserService;
import com.busBooking.payload.UserDTO;
import com.busBooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String uploadDirectory = "src/main/resources/static/user_profile_image/";


    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = convertToEntity(userDTO);

        MultipartFile profileImage = userDTO.getProfileImage();
        if (profileImage !=null && !profileImage.isEmpty())
        {
            String fileName = saveProfileImage(profileImage);
             user.setProfilePicture(fileName);
        }
        User savedUser = userRepo.save(user);
        return convertToDTO(savedUser);

    }

    @Override
    public Page<UserDTO> getUsers(Pageable pageable) {
        Page<User> userPage = userRepo.findAll(pageable);
        List<UserDTO> userDTOS = userPage.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new PageImpl<>(userDTOS,pageable,userPage.getTotalElements());

    }

    @Override
    public void deleteUser(Long userId) {
        User user =userRepo.findById(userId).orElseThrow(() -> new RuntimeException());
        userRepo.delete(user);
    }

    @Override
    public UserDTO updateUserProfile(Long userId, MultipartFile profileImage) {

        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));


        user.setUpdatedAt(new Date());
        user.setCreatedAt(new Date());



        // Update profile picture if provided
        if (profileImage != null && !profileImage.isEmpty()) {
            String fileName = saveProfileImage(profileImage);
            user.setProfilePicture(fileName);
        }



        User updatedUser = userRepo.save(user);
        return convertToDTO(updatedUser);

    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {

        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException());

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUpdatedAt(new Date());

        User updatedUser = userRepo.save(user);
        return convertToDTO(updatedUser);
    }




    private String saveProfileImage(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String baseFileName = originalFileName.substring(0,originalFileName.lastIndexOf("."));
            String uniqueFileName = baseFileName +"_" +System.currentTimeMillis() + fileExtension;
            Path path = Paths.get(uploadDirectory + uniqueFileName);
            Files.write(path, bytes);
            return uniqueFileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save profile image", e);
        }
    }

    private String generateUniqueFileName(String fileExtension) {

        String timestamp = String.valueOf(new Date().getTime());

        return "profile_" + timestamp + fileExtension;

    }


    private User convertToEntity(UserDTO userDTO) {

        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        return user;

    }
    private UserDTO convertToDTO(User user) {

        UserDTO userDTO = new UserDTO();


        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPasswordHash());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setProfilePicture(user.getProfilePicture());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdatedAt(user.getUpdatedAt());

        return userDTO;
    }
}
