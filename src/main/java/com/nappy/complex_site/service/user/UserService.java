package com.nappy.complex_site.service.user;

import com.nappy.complex_site.dto.user.UserDto;
import com.nappy.complex_site.model.user.User;
import com.nappy.complex_site.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 회원가입 로직
    public Long userSave(UserDto dto) {
        User user = dto.toEntity();
        userRepository.save(user);

        return user.getId();
    }
}
