package xmut.ygnn.petserver.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmut.ygnn.petserver.entity.Result;
import xmut.ygnn.petserver.service.ArticleService;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();


    @GetMapping("/list")
    public Result list() {
        result.setSuccess("查询成功！", gson.toJson(this.articleService.getAllArticle()));
        return result;
    }


}
