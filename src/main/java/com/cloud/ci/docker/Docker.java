package com.cloud.ci.docker;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by bwu on 11/8/15.
 */
public abstract class Docker {
    protected  Runtime runtime = Runtime.getRuntime();
    protected  Random random = new Random(Calendar.getInstance().getTimeInMillis());
    protected String commandLine = "docker ";

    public void execute(String container, String image) throws Exception{}
    public String execute(String id) throws Exception{return null;}
    public void execute() throws Exception{}

    public void help() throws Exception{
        Process process = runtime.exec(commandLine +"-h");
        put(process);
    }

    protected String put(Process process) throws Exception{
        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;
        StringBuilder containerId = new StringBuilder();
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
            containerId.append(line);
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        return containerId.toString();
    }

    public long generatePort(){
        return random.nextInt(10000)+1024;
    }
}
