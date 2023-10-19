package com.busBooking.service;

import com.busBooking.payload.UserDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    Page<UserDTO> getUsers(Pageable pageable);

    void deleteUser(Long userId);

    UserDTO updateUserProfile(Long userId, MultipartFile profileImage);
    UserDTO updateUser(Long userId,UserDTO userDTO);

}
