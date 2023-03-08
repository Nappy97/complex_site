package com.nappy.complex_site.model.user;

import com.nappy.complex_site.dto.user.UserDto;
import com.nappy.complex_site.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date birth;

    private String username;

    private String password;

    private String email;

    private String nickname;

    private String name;

    private Integer zipcode;

    private String address;

    private String detailAddress;

    private String fileName;

    private String filePath;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String provider;

    private String providerId;

    public String getRoleKey(){
        return this.role.getKey();
    }

    // 회원수정 메소드
    public User update(String password, String nickname, String name, int zipcode, String address, String detailAddress, String email) {
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.zipcode = zipcode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.email = email;
        return this;
    }

    public User update(String nickname, String name, int zipcode, String address, String detailAddress){
        this.nickname = nickname;
        this.name = name;
        this.zipcode = zipcode;
        this.address = address;
        this.detailAddress = detailAddress;
        return this;
    }

    @Builder
    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.birth = userDto.getBirth();
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        this.nickname = userDto.getNickname();
        this.name = userDto.getName();
        this.zipcode = userDto.getZipcode();
        this.address = userDto.getAddress();
        this.detailAddress = userDto.getDetailAddress();
        this.fileName = userDto.getFileName();
        this.filePath = userDto.getFilePath();
        this.role = userDto.getRole();
    }
}
