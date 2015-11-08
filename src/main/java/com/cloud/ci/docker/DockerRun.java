package com.cloud.ci.docker;

import com.cloud.ci.model.Container;

/**
 * Created by bwu on 11/8/15.
 */
public final class DockerRun extends Docker{
    protected String commandLine = "docker run ";
    @Override
    public String execute(String id) throws Exception{
        Process process = runtime.exec(commandLine+"-i -t -d -p "+generatePort()+":8080 "+id);
        return put(process);
    }

    public static void main(String[] args) throws Exception{
        DockerRun dockerRun = new DockerRun();
        dockerRun.execute("0ab139abcf2b");
        System.out.println(dockerRun.findContainerById("d40d2bc59ce8c494fbca2193ae91bc3d479b9d75dc4924c4ba97df50bddf973c"));
    }

    public Container findContainerById(String result) {
        Container container = new DockerPs().findContainerById(result);
        return container;
    }
}
