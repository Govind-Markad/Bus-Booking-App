package com.busBooking.payload;

import org.springframework.web.multipart.MultipartFile;

public class UserCreateRequest {

    private UserDTO userDTO;

    private MultipartFile profileImage;

    public UserDTO getUserDTO(){
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO){
        this.userDTO=userDTO;
    }
}
