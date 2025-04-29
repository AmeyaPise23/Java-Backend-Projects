package com.user_service.UserService.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.user_service.UserService.Entity.UserService;

public interface UserRepository extends JpaRepository<UserService, Integer>{

}
