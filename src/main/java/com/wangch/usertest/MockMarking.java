package com.wangch.usertest;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MockMarking {
    public static void connect() throws IOException {
        StringBuffer sb = new StringBuffer();
        Socket socket = new Socket("marking.itaojin.cn", 80);
        String x1 = "$$$ZYL REQ TIME$$$" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        sb.append(x1);
        System.out.println(x1);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("POST /marking/api/MarkingPermissionApi.getProjectInfo?_token=abc50271f6df4c0f9739abed93bc73d8 HTTP/1.1\n" +
                "Host: marking.itaojin.cn\n" +
                "Connection: keep-alive\n" +
                "Content-Length: 0\n" +
                "Accept: application/json, text/plain, */*\n" +
                "Cache-Control: no-cache\n" +
                "Origin: chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop\n" +
                "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36\n" +
                "Postman-Token: 2d7f3d1d-152f-c13a-802f-f2d080ce2513\n" +
                "Accept-Encoding: gzip, deflate\n");
        bw.write("\n\n");
        bw.flush();
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = inputStream.read(buf)) != -1){
            String x = new String(buf, 0, len, "utf-8");
            sb.append(x);
            System.out.println(x);
        }
        saveToFile(sb.toString());
        socket.close();
    }

    public static void saveToFile(String data) throws IOException {
        String path = "/Users/wangch/test/marking/socket_test";
        File f = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(f, true);
        fileOutputStream.write(data.getBytes());
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
      while (true){
          connect();
          Thread.sleep(1000);
      }
    }
}
