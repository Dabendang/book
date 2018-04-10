package edu.fjut.bookshop.web.controller.backend;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.domain.CateGory;
import edu.fjut.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by qyw on 2017/6/21.
 */
@Controller
@RequestMapping("/admin/category/")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "categories")
    public String list( Map<String,Object> map,@RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum, @RequestParam(value = "pageSize",defaultValue ="5") Integer pageSize){

        PageInfo pageInfo = categoryService.getCategorys(pageNum,pageSize);

        map.put("pageInfo",pageInfo);

        return "CategoryList";
    }

    @PostMapping(value = "category")
    @ResponseBody
    public ServerResponse saveOrUpdate(CateGory cateGory){
        if(null!=cateGory.getCategoryid()){
           return  categoryService.update(cateGory);
        }
        return categoryService.save(cateGory);
    }


    @GetMapping(value = "toDelete")
    @ResponseBody
    public ServerResponse delete(@RequestParam(required = false) Integer categoryid){

        return categoryService.delete(categoryid);
    }








}
