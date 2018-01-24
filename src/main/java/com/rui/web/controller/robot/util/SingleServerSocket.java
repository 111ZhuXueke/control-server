package com.rui.web.controller.robot.util;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : zhuxueke
 * @since : 2018-01-17 9:29
 **/
public class SingleServerSocket {
    private static ServerSocket serverSocket = null;
    public static Socket socket = null;
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
    /**
     * 判断socket是否关闭
     * @author : zhuxueke
     * @since : 2018/1/24 18:23
     */
    public static boolean isClose(){
        return socket.isClosed();
    }
}
