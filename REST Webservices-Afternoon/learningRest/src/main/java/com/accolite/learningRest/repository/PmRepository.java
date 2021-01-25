package com.accolite.learningRest.repository;

import com.accolite.learningRest.entity.PrivateMessage;
import com.accolite.learningRest.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PmRepository extends JpaRepository<PrivateMessage, Integer>  {
    public List<PrivateMessage> findByUserIdOrderByIdDesc(Integer userId);
}
