package com.rui.web.controller.robot.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 机器人本地socket服务端
 * @author : zhuxueke
 * @since : 2018-01-16 17:02
 **/
public class ServerSocketThread{

    public ServerSocketThread(Socket socket){
        SingleServerSocket.socket = socket;
        run();
    }

    public void run() {
    	try{
            //根据输入输出流和客户端连接
            InputStream inputStream = SingleServerSocket.socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String temp = null;
            String info="";
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
            }
            System.out.println("--------客户端连接成功--------");
            System.out.println("服务端接收到客户端命令信息："+info+",当前服务端ip为："+SingleServerSocket.socket.getInetAddress().getHostAddress());
            OutputStream outputStream=SingleServerSocket.socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(outputStream);
            //对客户端的信息进行处理
            handleClient(info);
            info = "服务端接收到客户端命令信息："+info+",当前服务端ip为："+SingleServerSocket.socket.getInetAddress().getHostAddress();
            printWriter.print(info);
            printWriter.flush();
            SingleServerSocket.socket.shutdownOutput();//关闭输出流
            //关闭相对应的资源
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStream.close();
            SingleServerSocket.socket.close();
        }catch (Exception e){         
            System.out.println("--------客户端连接失败--------");
            System.out.println("--------ServerSocket或者client连接有误--------");
            e.printStackTrace();
        }
    }
    /**
     * 对客户端的信息进行处理
     * @author : zhuxueke
     * @since : 2018/1/16 17:28
     */
    private void handleClient(String info){
    	Robot robot = null;
		try {  
			robot = new Robot();//创建Robot对象  
    	} catch (Exception e) {
            e.printStackTrace();  
	    }  
		robot.keyPress(KeyEvent.VK_CONTROL);  
        robot.keyPress(KeyEvent.VK_W);  
        robot.keyRelease(KeyEvent.VK_CONTROL);  
        robot.keyRelease(KeyEvent.VK_W);  
        robot.delay(100);  
    }
    /**
     * 拼接成json字符串返回到客户端
     * @param str
     * @param val
     * @return
     * @author : zhuxueke
     * @since : 2018年1月18日
     */
    private String backClientJson(String[] str,Object[] val){
    	StringBuilder strb = new StringBuilder("{");
    	for(int i = 0; i < str.length; i++){
    		strb.append("\""+str[i]+"\":\""+val[i]+"\"");
    		if(i != str.length -1){
    			strb.append(",");
    		}
    	}
    	strb.append("}");
    	return strb.toString();
    }

}
