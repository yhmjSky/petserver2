package xmut.ygnn.petserver.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmut.ygnn.petserver.entity.Admin;
import xmut.ygnn.petserver.entity.Result;
import xmut.ygnn.petserver.entity.User;
import xmut.ygnn.petserver.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController  {

    @Autowired
    private AdminService adminService;

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    @PostMapping("/login")
    public Result login(@RequestBody String json){
        Admin admin=null;
        Admin admin2=null;
        try{
            admin=gson.fromJson(json,Admin.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("json: " + json);
        admin2=adminService.getUserByAdminName(admin.getUsername());
        if(admin2!=null){//存在该账户
            if(admin2.getPassword().equals(admin.getPassword())){//密码正确
                result.setSuccess("登录成功！",gson.toJson(admin2));
            }else{//密码错误
                result.setInfo("用户名或密码错误！",null);
            }
        }else{
            result.setInfo("用户名或密码错误！",null);//不可以提示账号错误
        }
        return result;
    }

}
