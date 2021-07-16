package xmut.ygnn.petserver.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmut.ygnn.petserver.entity.PlayEntity;
import xmut.ygnn.petserver.entity.Result;
import xmut.ygnn.petserver.entity.User;
import xmut.ygnn.petserver.service.PlayService;

@RestController
@RequestMapping("/video")
public class PlayController {

    @Autowired
    private PlayService playService;

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();


    @GetMapping("/list")
    public Result list() {
        result.setSuccess("查询成功！", gson.toJson(this.playService.getAllVideo()));
        return result;
    }


    @PostMapping("/insert")
    public Result insert(String json){
        PlayEntity playEntity=null;
        try{
            playEntity=gson.fromJson(json,PlayEntity.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(playService.getVideoByName(playEntity.getName())!=null){//username重复！
            result.setInfo("重名，添加失败",null);
        }else{
            playService.insert(playEntity);
            result.setSuccess("添加成功！",gson.toJson(playEntity));
        }
        return result;
    }


    @DeleteMapping("/delete/{name}")
    public Result delete(@PathVariable("username") String name) {

        boolean is=this.playService.delete(playService.getVideoByName(name));
        if(is){
            result.setSuccess("删除成功！", null);

        }else{
            result.setInfo("删除失败！",null);
        }
        return result;
    }

    @PutMapping("/update")
    public Result update(String json) {
        result.setInfo("更改失败！",json);
        PlayEntity playEntity=null;
        try{
            playEntity=gson.fromJson(json,PlayEntity.class);
            if(this.playService.update(playEntity)){
                result.setSuccess("更改成功！",gson.toJson(playService.getVideoByName(playEntity.getName())));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
