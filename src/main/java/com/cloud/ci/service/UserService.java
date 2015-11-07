package com.cloud.ci.service;

import com.cloud.ci.model.User;

public interface UserService {

    boolean save(User user);

    boolean findUser(User user);
}
