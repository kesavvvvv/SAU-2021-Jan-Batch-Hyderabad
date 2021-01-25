package com.accolite.learningRest.service;

import com.accolite.learningRest.entity.PrivateMessage;

import java.util.List;

public interface PmService {
    public PrivateMessage add(PrivateMessage privateMessage);

    public List<PrivateMessage> getMessages(Integer userId);

    public String deletepm(Integer id);
}
