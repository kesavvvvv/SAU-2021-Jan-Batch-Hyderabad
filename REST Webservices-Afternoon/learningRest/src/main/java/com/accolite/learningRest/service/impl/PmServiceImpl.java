package com.accolite.learningRest.service.impl;

import com.accolite.learningRest.entity.PrivateMessage;
import com.accolite.learningRest.repository.PmRepository;
import com.accolite.learningRest.service.PmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PmServiceImpl implements PmService {

    @Autowired
    PmRepository pmRepository;

    @Override
    public PrivateMessage add(PrivateMessage privateMessage) {
        privateMessage.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        return pmRepository.save(privateMessage);
    }

    @Override
    public String deletepm(Integer id){
        pmRepository.deleteById(id);
        return "Delete Success";
    }

    @Override
    public List<PrivateMessage> getMessages(Integer userId) {
        return pmRepository.findByUserIdOrderByIdDesc(userId);
    }


}
