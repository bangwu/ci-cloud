package com.cloud.ci.docker;

import com.cloud.ci.model.Container;

/**
 * Created by bwu on 11/8/15.
 */
public final class DockerRun extends Docker{
    protected String commandLine = "docker run ";
    @Override
    public String execute(String id) throws Exception{
        Process process = runtime.exec(commandLine+"-i -t -d -p "+generatePort()+":8153 "+id);
        return put(process);
    }

    public static void main(String[] args) throws Exception{
        DockerRun dockerRun = new DockerRun();
        dockerRun.execute("7041141dc6ec");
    }

    public Container findContainerById(String result) {
        Container container = new DockerPs().findContainerById(result);
        return container;
    }
}
