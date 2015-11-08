package com.cloud.ci.service.impl;

import com.cloud.ci.docker.DockerRun;
import com.cloud.ci.mappers.ContainerMapper;
import com.cloud.ci.model.Container;
import com.cloud.ci.service.DockerService;
import com.cloud.ci.util.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bwu on 11/8/15.
 */
@Service("dockerService")
public class DockerServiceImpl implements DockerService{

    private ContainerMapper containerMapper;
    private SqlSession sqlSession;

    public DockerServiceImpl() {
        this.sqlSession = MySqlSessionFactory
                .getSqlSessionFactory()
                .openSession(true);
        this.containerMapper = sqlSession.getMapper(ContainerMapper.class);
    }

    @Override
    public String create(String userId){
        DockerRun dockerRun = new DockerRun();
        String result=null;
        do{
            try {
                result = dockerRun.execute("0ab139abcf2b");
            }catch (Exception e){
                System.out.println("container create fialer");
            }
        }while (result == null);
        Container container = dockerRun.findContainerById(result);
        container.setUser(userId);
        containerMapper.save(container);
        return result;
    }

    @Override
    public List<Container> findAllContainers(String userId) {
        return containerMapper.findAllByUser(userId);
    }
}
