package cn.itcast.core.controller;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liyan on 2017/8/2.
 */

@Controller
public class BrandControllerImpl  {

    @Autowired
    private BrandService brandService;

    //查询
    @RequestMapping(value = "/brand/list.do")
    public String list(String brandName,Byte isDisplay,Integer pageNo,Model model){

        Pagination pagination = brandService.selectPaginationByQuery(brandName, isDisplay, pageNo);
        model.addAttribute("pagination", pagination);
        model.addAttribute("brandName", brandName);
        if(null != isDisplay){
            model.addAttribute("isDisplay", isDisplay);
        }else{
            model.addAttribute("isDisplay", 1);
        }

        return "brand/list";
    }

    @RequestMapping("/brand/add.do")
    public String doAdd(HttpServletRequest request, Brand brand,String brandName){
       // String brandName = request.getParameter("brandName");
        brandService.saveBrand(brand);

        return "redirect:/brand/list.do";

    }


    @RequestMapping("/brand/toEdit.do")
    public String toEdid(Long brandId,Model model ){
        Brand brand=brandService.getBrandById(brandId);
       model.addAttribute("brand",brand);

        return "brand/edit";
    }



}