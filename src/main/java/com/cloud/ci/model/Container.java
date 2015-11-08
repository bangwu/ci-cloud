package com.cloud.ci.model;

import java.util.Date;

/**
 * Created by bwu on 11/8/15.
 */
public class Container {
    /**id VARCHAR(255) NOT NULL PRIMARY KEY,
    image VARCHAR(255) NOT NULL,
    name VARCHAR(100) not NULL,
    command VARCHAR(100),
    create_at DATE,
    status VARCHAR(10),
    port INTEGER,
    host_port INTEGER*/

    private String id;
    private String user;
    private String image;
    private String name;
    private String command;
    private Date created;
    private String status;
    private Long port;
    private Long hostPort;

    public String getId() {
        return id;
    }

    public Container setId(String id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public Container setImage(String image) {
        this.image = image;
        return this;
    }

    public String getName() {
        return name;
    }

    public Container setName(String name) {
        this.name = name;
        return this;
    }

    public String getCommand() {
        return command;
    }

    public Container setCommand(String command) {
        this.command = command;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public Container setCreated(Date created) {
        this.created = created;
        return this;
    }
    public String getStatus() {
        return status;
    }

    public Container setStatus(String status) {
        this.status = status;
        return this;
    }


    public Long getPort() {
        return port;
    }

    public Container setPort(Long port) {
        this.port = port;
        return this;
    }

    public Long getHostPort() {
        return hostPort;
    }

    public Container setHostPort(Long hostPort) {
        this.hostPort = hostPort;
        return this;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id='" + id + '\'' +
                "\n image='" + image + '\'' +
                "\n name='" + name + '\'' +
                "\n command='" + command + '\'' +
                "\n created=" + created +
                "\n status='" + status + '\'' +
                "\n port=" + port +
                "\n hostPort=" + hostPort +
                "\n }";
    }
}
