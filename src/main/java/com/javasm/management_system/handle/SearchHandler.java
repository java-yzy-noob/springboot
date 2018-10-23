package com.javasm.management_system.handle;

import com.javasm.management_system.Service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchHandler {


    @Resource
    private IService is;

    @RequestMapping("/searchByKey")
    @ResponseBody
    public List searchByKey(String key){
        return is.searchList(key);
    }
    @RequestMapping("/addContent")
    @ResponseBody
    public String addContent(){
        return is.addContent();
    }

}
