package com.cloud.ci.service;

import com.cloud.ci.model.Container;

import java.util.List;

/**
 * Created by bwu on 11/8/15.
 */
public interface DockerService {
    String create(String userId);

    List<Container> findAllContainers(String userId);
}
