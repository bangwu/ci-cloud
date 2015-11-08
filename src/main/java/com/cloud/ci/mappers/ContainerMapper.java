package com.cloud.ci.mappers;

import com.cloud.ci.model.Container;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by bwu on 11/8/15.
 */
public interface ContainerMapper {
    @Insert("insert into containers(id,userid, image, name, command, create_at, status, port, host_port) "+
    "values(#{id}, #{user}, #{image}, #{name}, #{command}, #{created}, #{status}, #{port}, #{hostPort}) ")
    void save(Container container);

    @Select("select id, userid as user, image, name, command, create_at as created, status, port, host_port as hostPort "+
    "from containers "+
    "where userid=#{userid} ")
    List<Container> findAllByUser(String userId);
}
