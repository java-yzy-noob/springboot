package com.javasm.management_system.handle;

import com.javasm.management_system.Entity.TestData;
import com.javasm.management_system.Service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/fh")
@Controller
public class TCHandler {

    @Resource
    private IService is;

    @RequestMapping("/tc")
    public String technicalReview(){
        return "first/technicalCommittee ";
    }
    @RequestMapping("/showTechnicalReview")
    public String showTechnicalReview(){
        return "first/technicalReview";
    }
    @RequestMapping("/tr_data")
    @ResponseBody
    public Map<String, Object> tr_data(int limit, int page, String date_start, String date_end, String theKey){
        Map<String, Object> map = new HashMap<>();
        // 参数是每页数量和起始索引
        List<TestData> sublist = is.getTr_data((page - 1)*limit, limit, theKey, date_start, date_end);
        List<TestData> list = is.getAllTr_data(theKey, date_start, date_end);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",list.size());
        map.put("data", sublist);
        return map;
    }



}
