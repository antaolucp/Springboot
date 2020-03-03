package com.dxh.bookillustration.config;


import org.apache.logging.log4j.util.Base64Util;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class FileDownloadUtil {
    public static String UploadFile(MultipartFile file, File dest,boolean flag){
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            System.out.println(dest.getParentFile());

            dest.getParentFile().mkdir();
        }else{
            deleteFile( dest.getParentFile(),flag);
        }
        try {
            file.transferTo(dest); //保存文件
            return "true";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "true";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "true";
        }
    }

    public static void downImg(HttpServletResponse response, String filename, String path ){
        if (filename != null) {
            FileInputStream is = null;
            BufferedInputStream bs = null;
            OutputStream os = null;
            try {
                File file = new File(path);
                if (file.exists()) {
                    //设置Headers
                    response.setHeader("Content-Type","application/octet-stream");
                    //设置下载的文件的名称-该方式已解决中文乱码问题
                    response.setHeader("Content-Disposition","attachment;filename=" +  new String( filename.getBytes("gb2312"), "ISO8859-1" ));
                    is = new FileInputStream(file);
                    bs =new BufferedInputStream(is);
                    os = response.getOutputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while((len = bs.read(buffer)) != -1){
                        os.write(buffer,0,len);
                    }
                }else{
                    String error = Base64Util.encode("下载的文件资源不存在");
                    response.sendRedirect("/user/download?error="+error);
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }finally {
                try{
                    if(is != null){
                        is.close();
                    }
                    if( bs != null ){
                        bs.close();
                    }
                    if( os != null){
                        os.flush();
                        os.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void deleteFile(File file,boolean flag) {
        if (flag) return;
        //判断文件不为null或文件目录存在
        //取得这个目录下的所有子文件对象
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f : files) {
            //打印文件名
            String name = file.getName();
            System.out.println(name);
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()) {
                deleteFile(f, false);
            } else {
                f.delete();
            }

        }
    }
}