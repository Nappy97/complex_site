package com.nappy.complex_site.repository.user;

import com.nappy.complex_site.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
