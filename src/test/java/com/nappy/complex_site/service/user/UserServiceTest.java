package com.nappy.complex_site.service.user;

import com.nappy.complex_site.dto.user.UserDto;
import com.nappy.complex_site.model.user.Role;
import com.nappy.complex_site.model.user.User;
import com.nappy.complex_site.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserDto userDto;

    @Test
    void userSave() throws ParseException {
        Long id = 1L;
        String username = "admin";
        String password = "1234";
        String email = "admin@admin.com";
        String nickname = "관리자";
        Integer zipcode = 1234;
        String address = "응애";
        String detailAddress = "응애1";
        String name = "관리자임둥";
        Role role = Role.ADMIN;
        Date birth = new SimpleDateFormat("yyyy-MM-dd").parse("19990101");
        String fileName = "hi.jpg";
        String filePath = "C";

        UserDto user = userDto.toEntity(id, birth, username, password, email, nickname, name, zipcode, address, detailAddress, fileName, filePath, role);
        userService.userSave((UserDto) user);
    }
}