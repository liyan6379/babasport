package cn.itcast.core.controller;

import cn.itcast.core.service.product.UploadService;
import cn.itcat.common.web.Constants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liyan on 2017/8/17.
 */

@Controller
public class UploadController {

    @Autowired
    private UploadService uploadService;


    @RequestMapping("/upload/uploadPic.do")
    public void uploadPic(@RequestParam(required =false,value = "brandImgUrl") MultipartFile brandImgUrl, HttpServletResponse response) throws IOException{
        String path = uploadService.uploadPic(brandImgUrl.getBytes(), brandImgUrl.getOriginalFilename(), brandImgUrl.getSize());

        String url=new StringBuilder(Constants.IMG_URL).append(path).toString();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url",url);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(jsonObject.toString());
    }
}
