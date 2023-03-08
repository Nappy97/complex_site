package com.nappy.complex_site.dto.user;

import com.nappy.complex_site.model.user.Role;
import com.nappy.complex_site.model.user.User;
import lombok.Getter;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
public class UserDto {

    Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date birth;

    @NotBlank(message = "아이디는 필수입력입니다")
    @Length(min = 4, max = 16, message = "아이디는 4자 이상 16자 이하로 입력해주세요")
    @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 4~20자리여야 합니다.")
    String username;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
    String password;

    @NotBlank(message = "이메일은 필수 입력 값입니다")
    @Email(message = "이메일 형식으로 입력해주세요")
    String email;

    @NotBlank(message = "닉네임은 필수 입력 값입니다")
    @Length(min = 2, message = "닉네임은 2자 이상 입력해주세요")
    String nickname;

    Integer zipcode;

    String name;

    String address;

    String detailAddress;

    Role role;

    String fileName;

    String filePath;

    public User toEntity() {
        User user = User.builder()
                .id(id)
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .zipcode(zipcode)
                .address(address)
                .detailAddress(detailAddress)
                .name(name)
                .role(Role.USER)
                .birth(birth)
                .fileName(fileName)
                .filePath(filePath)
                .build();
        return user;
    }
}
