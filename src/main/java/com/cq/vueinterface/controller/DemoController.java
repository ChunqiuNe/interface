package com.cq.vueinterface.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.TreeSet;

/**
 * @program: hll
 * @author: 黄岭
 * @create: 2019-06-20 20:53
 **/
@Controller
@RequestMapping("a")
public class DemoController {
    @ResponseBody
    @RequestMapping("a")
    public String aa() {
        return "aa";
    }

    @ResponseBody
    @RequestMapping("ab")
    public String text() throws IOException {
        InputStream inputStream1 = new FileInputStream("E:\\1.txt");
        InputStream inputStream2 = new FileInputStream("E:\\2.txt");
        InputStreamReader fileInputStream1 = null;
        InputStreamReader fileInputStream2 = null;
        if (inputStream1 != null && inputStream2 != null) {
           //  因为txt文本格式为ANSI 所以字符编码为GBK
            fileInputStream1 = new InputStreamReader(inputStream1,"GBK");
            fileInputStream2 = new InputStreamReader(inputStream2,"GBK");
        }
        BufferedReader br = null;
        BufferedReader br2 = null;
        br = new BufferedReader(fileInputStream1);
        br2 = new BufferedReader(fileInputStream2);
        String str1 = "";
        String str2 = "";
        String d = "";
        String d2 = "";
        String b = "";
        String e = "";
        //  行数
        int ddd = 0;
        int ddd2 = 0;
        while ((str2 = br2.readLine()) != null) {
            ddd2++;
            d2 += str2;
        }
        while ((str1 = br.readLine()) != null) {
            ddd++;
            d += str1;
            //使用treeset方法去重
            String[] str = str1.split("");
            TreeSet<String> tre = new TreeSet();
            for (String tr : str) {
                tre.add(tr);
            }

            for (String c : tre) {
                b += c;
            }
            System.out.println("去重前第" + ddd + "行" + str1);
            System.out.println("去重后第" + ddd + "行" + b);
//                System.out.println(br.readLine());
        }
        String[] str3 = b.split("");
        TreeSet<String> tre1 = new TreeSet();

        for (String tr : str3) {
            tre1.add(tr);
        }
        for (String c : tre1) {
            e += c;
        }
        System.out.println("去重前1" + d);
        System.out.println("去重前2" + d2);
        String[] d3 = d.split("");
        String[] d4 = d2.split("");
        String sr = "";
        TreeSet<String> trdd = new TreeSet();
        for (String add : d3) {
            trdd.add(add);
        }
        for (String add : d4) {
            trdd.add(add);
        }
        for (String c : trdd) {
            sr += c;
        }

        System.out.println("全部去重后" + e);
        System.out.println(ddd);
        System.out.println(str1);
        br.close();
        System.out.println("完完全全去重" + sr);
        fileInputStream1.close();
        fileInputStream2.close();
        inputStream1.close();
        inputStream2.close();
        return str1;
    }


    @ResponseBody
    @RequestMapping("ac")
    public String textc() throws IOException {
        InputStream inputStream1 = new FileInputStream("E:\\1.txt");
        InputStream inputStream2 = new FileInputStream("E:\\2.txt");
        // 获取文件大小
        File file = new File("E:\\2.txt");
        long length = file.length();
        System.out.println("大小"+length);
        InputStreamReader fileInputStream1 = null;
        InputStreamReader fileInputStream2 = null;
        if (inputStream1 != null && inputStream2 != null) {
            //  因为txt文本格式为ANSI 所以字符编码为GBK
            fileInputStream1 = new InputStreamReader(inputStream1,"GBK");
            fileInputStream2 = new InputStreamReader(inputStream2,"GBK");
        }
        BufferedReader br = null;
        BufferedReader br2 = null;
        br = new BufferedReader(fileInputStream1);
        br2 = new BufferedReader(fileInputStream2);
        String str1 = "";
        String str2 = "";
        String d = "";
        String d2 = "";

        //  行数
        int ddd = 0;
        int ddd2 = 0;
        //  获取txt文档中所以内容
        while ((str2 = br2.readLine()) != null) {
            ddd2++;
            d2 += str2;
        }
        while ((str1 = br.readLine()) != null) {
            ddd++;
            d += str1;
        }
        System.out.println("第一个文档内容"+d+"共"+ddd+"行");
        System.out.println("第二个文档内容"+d2+"共"+ddd2+"行");
        // 使用TreeSet特性去重
        TreeSet<String> tree1=new TreeSet();
        TreeSet<String> tree2=new TreeSet();
        String[] dd=d.split("");
        System.out.println(dd.toString());
        String  dd1="";
        String[] dd2=d2.split("");
        String  dddd2="";
        // 对第一个文件去重
        for (String add: dd){
            tree1.add(add);
        }
        for (String add: tree1){
            dd1+=add;
        }
        // 对第二个文件去重
        for (String add: dd2){
            tree2.add(add);
        }
        for (String add: tree2){
            dddd2+=add;
        }
        // 打印重复数据
        String cf="";
        for (int i=0;i<dd.length;i++){
            System.out.println(dd[i].toString());
            if (d2.contains(dd[i].toString())){
                cf+=dd[i].toString();
                        }
        }
        System.out.println("重复数据"+cf);
        System.out.println("第一个文档去重内容"+dd1);
        System.out.println("第二个文档去重内容"+dddd2);
        br.close();
        fileInputStream1.close();
        fileInputStream2.close();
        inputStream1.close();
        inputStream2.close();
        return d2+d;
    }
    @ResponseBody
    @RequestMapping("downloadFile")
    public String downloadFile(HttpServletRequest request,
                               HttpServletResponse response) throws UnsupportedEncodingException {
        // 获取指定目录下的第一个文件
        File scFileDir = new File("E:\\");
        File TrxFiles[] = scFileDir.listFiles();
        System.out.println(TrxFiles[0]);
        String fileName = TrxFiles[0].getName(); //下载的文件名
        System.out.println(fileName);
        fileName = "2.txt";
        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            String realPath = "E:\\";
            File file = new File(realPath, fileName);

            // 如果文件名存在，则进行下载
            if (file.exists()) {
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download the song successfully!");
                } catch (Exception e) {
                    System.out.println("Download the song failed!");
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}

