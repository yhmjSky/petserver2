package xmut.ygnn.petserver.controller;


import org.springframework.web.bind.annotation.RequestMapping;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmut.ygnn.petserver.entity.Result;
import xmut.ygnn.petserver.entity.User;
import xmut.ygnn.petserver.service.UserService;

import java.io.Serializable;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    @PostMapping("/insert")
    public Result insert(String json){
        User user=null;
        try{
            user=gson.fromJson(json,User.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(userService.getUserByUsername(user.getUsername())!=null){//username重复！
            result.setInfo("该账号已注册！",null);
        }else{
            userService.insert(user);
            result.setSuccess("注册成功！",gson.toJson(user));
        }
        return result;
    }

    @DeleteMapping("/delete/{username}")
    public Result delete(@PathVariable("username") String username) {

        boolean is=this.userService.delete(userService.getUserByUsername(username));
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
        User user=null;
        try{
            user=gson.fromJson(json,User.class);
            if(this.userService.update(user)){
                result.setSuccess("更改成功！",gson.toJson(userService.getUserByUsername(user.getUsername())));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/list")
    public Result list() {
        result.setSuccess("查询成功！", gson.toJson(this.userService.getAllUser()));
        return result;
    }

    @GetMapping("/line/{id}")
    public Result list(@PathVariable("id") Serializable id) {
        result.setSuccess("查询成功！", gson.toJson(this.userService.getUserByUserid(Integer.parseInt(id.toString()))));
        return result;
    }

    @GetMapping("/openid/{openid}")
    public Result openid(@PathVariable("openid") Serializable openid) {
        result.setSuccess("查询成功！", gson.toJson(this.userService.getUserByOpenid(openid.toString())));
        return result;
    }

    @PostMapping("/login")
    public Result login(String json){
        User user=null;
        User user1=null;
        try{
            user=gson.fromJson(json,User.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        user1=userService.getUserByUsername(user.getUsername());
        if(user1!=null){//存在该账户
            if(user1.getPassword().equals(user.getPassword())){//密码正确
                result.setSuccess("登录成功！",gson.toJson(user1));
            }else{//密码错误
                result.setInfo("用户名或密码错误！",null);
            }
        }else{
            result.setInfo("用户名或密码错误！",null);//不可以提示账号错误
        }
        return result;
    }


    @PostMapping("/loginById")
    public Result loginById(String json){
        User user=null;
        User user1=null;
        try{
            user=gson.fromJson(json,User.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        user1=userService.getUserByOpenid(user.getOpenid());

        if(user1!=null){//存在该账户
                result.setSuccess("登录成功！",gson.toJson(user1));
        }else{
            result.setInfo("未知错误！",null);//不可以提示账号错误
        }

        return result;
    }

}


