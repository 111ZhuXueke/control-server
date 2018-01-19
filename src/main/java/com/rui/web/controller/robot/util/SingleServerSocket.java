package com.rui.web.controller.robot.util;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : zhuxueke
 * @since : 2018-01-17 9:29
 **/
public class SingleServerSocket {
    private static ServerSocket serverSocket = null;

    public static ServerSocket getInstance(int port){
        if(serverSocket == null){
            try{
                serverSocket = new ServerSocket(port);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return serverSocket;
    }
}
