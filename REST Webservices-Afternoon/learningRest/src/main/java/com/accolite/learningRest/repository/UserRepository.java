package com.accolite.learningRest.repository;

import com.accolite.learningRest.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserData, Integer> {


}
