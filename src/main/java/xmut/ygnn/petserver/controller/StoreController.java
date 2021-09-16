package xmut.ygnn.petserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmut.ygnn.petserver.entity.Result;
import xmut.ygnn.petserver.entity.Store;
import xmut.ygnn.petserver.service.StoreService;

import java.io.Serializable;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService storeService;

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    @GetMapping("/list")
    public Result list() {
        result.setSuccess("查询成功！", gson.toJson(this.storeService.getAllStore()));
        return result;
    }


    @PostMapping("/insert")
    public Result insert(String json){
        Store store=null;
        try{
            store=gson.fromJson(json,Store.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(storeService.getByName(store.getName())!=null){//username重复！
            result.setInfo("重名，添加失败",null);
        }else{
            storeService.insert(store);
            result.setSuccess("添加成功！",gson.toJson(store));
        }
        return result;
    }


    @DeleteMapping("/delete/{name}")
    public Result delete(@PathVariable("name") String name) {

        boolean is=this.storeService.delete(storeService.getByName(name));
        if(is){
            result.setSuccess("删除成功！", null);

        }else{
            result.setInfo("删除失败！",null);
        }
        return result;
    }

    @GetMapping("/line1/{name}")
    public Result list1(@PathVariable("name") Serializable name) {
        result.setSuccess("查询成功！", gson.toJson(this.storeService.getByName(name.toString())));
        return result;
    }

    @GetMapping("/line/{id}")
    public Result list(@PathVariable("id") Serializable id) {
        result.setSuccess("查询成功！", gson.toJson(this.storeService.getById(Integer.parseInt(id.toString()))));
        return result;
    }


    @PutMapping("/update")
    public Result update(String json) {
        result.setInfo("更改失败！",json);
        Store store=null;
        try{
            store=gson.fromJson(json,Store.class);
            if(this.storeService.update(store)){
                result.setSuccess("更改成功！",gson.toJson(storeService.getByName(store.getName())));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
