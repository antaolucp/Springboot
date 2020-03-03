package com.dxh.bookillustration.controller;

import com.dxh.bookillustration.config.FileDownloadUtil;
import com.dxh.bookillustration.pojo.*;
import com.dxh.bookillustration.service.ImageService;
import com.dxh.bookillustration.service.IndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
public class ImageController {
    @Autowired
    IndexService indexService;
    @Autowired
    ImageService imageService;
    @RequestMapping("/user/hua")
    public String index(Map map,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 24);
        List<Atlas> atlas =indexService.findAtlasalltime();

        PageInfo<Atlas> pageInfo = new PageInfo<Atlas>(atlas);
        map.put("pageInfo", pageInfo);
        map.put("labelall",indexService.findlabelall());
        map.put("Atlastime",atlas);
        map.put("Atlashotandtime",indexService.findAtlasallhottime());

        return "hua/index";
    }
    @RequestMapping("/user/find")
    public String find(Map map,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,25);
        List<Atlas> atlas =indexService.findAtlasalltime();
        PageInfo<Atlas> pageInfo = new PageInfo<Atlas>(atlas);
        map.put("time","1");
        map.put("like","1");
        map.put("fans","1");
        map.put("pageInfo",pageInfo);
        map.put("labelall",indexService.findlabelall());
        map.put("Atlastime",atlas);
        return "hua/find";
    }
    @RequestMapping("/user/find/time/{time}/fans/{fans}/like/{like}")
    public String find(Map map,@PathVariable("time")String time,@PathVariable("like") String like,
                       @PathVariable("fans") String fans,
                       @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,25);
        map.put("time", time);
        map.put("like",like);
        map.put("fans",fans);
        List<Atlas> atlas=imageService.findAtlas(time,fans,like);
        PageInfo<Atlas> pageInfo = new PageInfo<Atlas>(atlas);
        map.put("pageInfo",pageInfo);
        map.put("labelall",indexService.findlabelall());
        map.put("Atlastime",atlas);

        return "hua/find";
    }
    @RequestMapping("/user/rank")
    public String rank(Map map){
        List<Atlas> atlas =imageService.findMapperonlook();
        map.put("Atlaslooknum",atlas);
        return "/rank/rank";
    }

    @RequestMapping("/user/like")
    public String like(Map map){
        List<Atlas> atlas=indexService.findAtlasallhot();
        map.put("Atlasallhot",atlas);
        return "/rank/likes";
    }
    @RequestMapping("/user/hua/{atlas_id}")
    public String uhua(@PathVariable("atlas_id") Integer atlas_id, Map map, HttpSession session){
        Atlas atlas=imageService.findAtlasbyId(atlas_id);
        KUser user=(KUser) session.getAttribute("user");
        if (user!=null) {
            for (Fans fan : user.getFollows()) {

                if (fan.getUser_id() == atlas.getUser_id()) {
                    System.out.println(fan.getUser_id());
                    map.put("followtext", "已关注 ~ ~!");
                    break;
                }
            }
            for(Likes likes:imageService.findlikebyId(atlas_id)){
                if(user.getUser_id()==likes.getUser_id()){
                    map.put("liketext","已喜欢");
                    break;
                }
            }
        }
        atlas.setAtlas_time(atlas.getAtlas_time().split("\\.")[0]);
        map.put("like_count",imageService.findlikebyId(atlas_id).size());
        map.put("Atlas",atlas);
        map.put("Atlashotandtime",indexService.findAtlasallhottime());
        map.put("Comments",imageService.findCommentById(atlas_id));
        return "/hua/uhua";
    }
    @RequestMapping("/user/us/{user_id}/upload")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String upload(@PathVariable("user_id") Integer user_id,Map map){
        map.put("labels",indexService.findlabelall());
        return "/hua/upload";
    }

    @ResponseBody
    @RequestMapping("/user/us/uploads")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String uploads(MultipartFile[] image,Atlas atlas,String[] label,HttpSession session){
        KUser user=(KUser) session.getAttribute("user");
        System.out.println(image[0]);
        atlas.setAtlas_id(imageService.findAtlas_id()+1);
        atlas.setUser_id(user.getUser_id());
        if(atlas.getAtlas_synopsis()==null){
            atlas.setAtlas_synopsis("");
        }
        imageService.InsertAtlas(atlas);
        for (MultipartFile file: image){
            Images images=new Images();
            String fileName = file.getOriginalFilename();
            String path="E:/web/asd/image1.pzhan.com/pzhan/hua/"+atlas.getAtlas_id();
            File dest = new File(path + "/" + fileName);
            System.out.println(dest);
            images.setImage("pzhan/hua/"+atlas.getAtlas_id()+"/"+ fileName);
            images.setAtlas_id(atlas.getAtlas_id());
            images.setUser_id(user.getUser_id());
            imageService.InsertImage(images);
            FileDownloadUtil.UploadFile(file,dest,true);
        }
        return "/user/hua/"+atlas.getAtlas_id();
    }

    @RequestMapping(value = "/user/download", method = RequestMethod.GET)
    public void imgDownload(HttpServletResponse response, String [] names, String [] paths,String name) {
        //存放--服务器上zip文件的目录

        String directory = "E:\\web\\asd";
        File directoryFile=new File(directory);
        if(!directoryFile.isDirectory() && !directoryFile.exists()){
            directoryFile.mkdirs();
        }
        //设置最终输出zip文件的目录+文件名
        String zipFileName = name+".zip";
        String strZipPath = directory+"\\"+zipFileName;

        ZipOutputStream zipStream = null;
        FileInputStream zipSource = null;
        BufferedInputStream bufferStream = null;
        File zipFile = new File(strZipPath);
        try{
            //构造最终压缩包的输出流
            zipStream = new ZipOutputStream(new FileOutputStream(zipFile));
            for (int i = 0; i<paths.length ;i++){
                //解码获取真实路径与文件名
                String realFileName = java.net.URLDecoder.decode(names[i],"UTF-8");
                String realFilePath = "E:"+java.net.URLDecoder.decode(paths[i],"UTF-8");
                File file = new File(realFilePath);
                //TODO:未对文件不存在时进行操作，后期优化。
                if(file.exists())
                {
                    zipSource = new FileInputStream(file);//将需要压缩的文件格式化为输入流
                    /**
                     * 压缩条目不是具体独立的文件，而是压缩包文件列表中的列表项，称为条目，就像索引一样这里的name就是文件名,
                     * 文件名和之前的重复就会导致文件被覆盖
                     */
                    ZipEntry zipEntry = new ZipEntry(realFileName+"."+realFilePath.substring(realFilePath.length()-3));//在压缩目录中文件的名字
                    zipStream.putNextEntry(zipEntry);//定位该压缩条目位置，开始写入文件到压缩包中
                    bufferStream = new BufferedInputStream(zipSource, 1024 * 10);
                    int read = 0;
                    byte[] buf = new byte[1024 * 10];
                    while((read = bufferStream.read(buf, 0, 1024 * 10)) != -1)
                    {
                        zipStream.write(buf, 0, read);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(null != bufferStream) bufferStream.close();
                if(null != zipStream){
                    zipStream.flush();
                    zipStream.close();
                }
                if(null != zipSource) zipSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //判断系统压缩文件是否存在：true-把该压缩文件通过流输出给客户端后删除该压缩文件  false-未处理
        if(zipFile.exists()){
            FileDownloadUtil.downImg(response,zipFileName,strZipPath);
            zipFile.delete();
        }
    }
}
