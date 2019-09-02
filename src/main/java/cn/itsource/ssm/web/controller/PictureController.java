package cn.itsource.ssm.web.controller;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.domain.PageList;
import cn.itsource.ssm.domain.Picture;
import cn.itsource.ssm.service.IPictureService;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    private IPictureService pictureService;
    @RequestMapping("/add")
    public String add(MultipartFile pic, HttpServletRequest req, Picture imgs) throws IOException {

        ServletContext context = req.getServletContext();
        String rPath = context.getRealPath("/pics");
        System.out.println(context);
        System.out.println(rPath);
        String contentType = pic.getContentType();
        if (contentType!=null && contentType.startsWith("image/")){

            String realPath = "F:\\java res\\myssm\\src\\main\\webapp\\pics";

            String oldName = pic.getOriginalFilename();
            String newName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(oldName);
            System.out.println(pic.getContentType());
            System.out.println(pic.getName());
            System.out.println(pic.getOriginalFilename());

            File file = new File(realPath+"/"+newName);
            pic.transferTo(file);
            System.out.println(imgs);

            //生成一个缩略图
            File f = new File(realPath,newName);
            Thumbnails.of(f).size(40,60).toFile(realPath+"/"+newName+"_small.jpg");

            imgs.setStorePath("/pics/"+newName);
            pictureService.add(imgs);
        }
//        FileInputStream fis = new FileInputStream(file);
//
//        InputStreamReader input = new InputStreamReader(fis);
//
//        BufferedReader br = new BufferedReader(input);
//        int i=0;
//        while (i<10){
//
//            System.out.println(br.readLine());
//            i++;
//        }
        return "redirect:/jump/index";
    }

    /**
     * 查询轮播展示的图
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Picture> findAll(){
        return pictureService.findAll();
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public Picture findOne(Long id){
        return pictureService.findOne(id);
    }

    @RequestMapping("/update")
    public String update(Picture picture){
        pictureService.update(picture);
        return "main";
    }

    @RequestMapping("/download")
    public void download(String storePath, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        ServletContext context = req.getServletContext();
        String realPath = context.getRealPath(storePath);
        //设置为下载项
        resp.setContentType("application/x-msdownload");
        //设置下载文件得名字
        String filename = storePath.substring(storePath.lastIndexOf("/") + 1);
        resp.setHeader("Content-Disposition", "attachment;filename="+filename);
        File file = new File(realPath);
        Files.copy(file.toPath(),resp.getOutputStream());
    }

    @RequestMapping("/page")
    @ResponseBody
    public PageList<Picture> findByQuery(Condition con){
        con.setFlag(false);
        PageList<Picture> pageList = pictureService.loadByQuery(con);
        return pageList;
    }

}
