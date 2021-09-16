package xmut.ygnn.petserver.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmut.ygnn.petserver.entity.Discuss;
import xmut.ygnn.petserver.entity.Goods;
import xmut.ygnn.petserver.entity.Result;
import xmut.ygnn.petserver.service.DiscussService;

@RestController
@RequestMapping("/discuss")
public class DiscussController {


    @Autowired
    private DiscussService discussService;


    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    @GetMapping("/list")
    public Result list() {
        result.setSuccess("查询成功！", gson.toJson(this.discussService.getAll()));
        return result;
    }


    @PostMapping("/insert")
    public Result insert(String json){
        Discuss discuss=null;
        try{
            discuss=gson.fromJson(json,Discuss.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        discussService.insert(discuss);
        result.setSuccess("添加成功！",gson.toJson(discuss));

        return result;
    }


    @PutMapping("/update")
    public Result update(String json) {

        result.setInfo("更改失败！",json);
        Discuss discuss=null;
        try{
            discuss=gson.fromJson(json,Discuss.class);
            if(this.discussService.update(discuss)){
                result.setSuccess("更改成功！",gson.toJson(discuss));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
