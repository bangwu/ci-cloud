package com.cloud.ci.docker;

import com.cloud.ci.model.Container;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by bwu on 11/8/15.
 */
public class DockerPs extends Docker{
    protected String commandLine = "docker ps ";

    public Container findContainerById(String id){
        Process process=null;
        Container container = null;
        try {
            process = runtime.exec(commandLine+"-f id="+id);
            container = toContainer(process);
        }catch (Exception e){
            System.out.println("can not find this container");
        }finally {
           return container!=null ? container:new Container();
        }
    }

    protected Container toContainer(Process process) throws Exception{
        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;
        StringBuilder containerId = new StringBuilder();
        while ((line = bufferedReader.readLine())!=null){
            if(!line.contains("CONTAINER ID")){
                System.out.println(line);
                containerId.append(line);
            }
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        String[] containerFields = containerId.toString().split("        ");
        System.out.println(containerFields.length);
        String[] ports = containerFields[3].split("   ");
        Container container =new Container()
                .setId(containerFields[0])
                .setImage(containerFields[1])
                .setCommand(containerFields[2])
                .setCreated(new Date())
                .setStatus("up")
                .setPort(Long.parseLong(ports[2].split("->")[1].split("/")[0]))
                .setHostPort(Long.parseLong(ports[2].split("->")[0].split(":")[1]))
                .setName(ports[3]);
        return container;
    }

}
