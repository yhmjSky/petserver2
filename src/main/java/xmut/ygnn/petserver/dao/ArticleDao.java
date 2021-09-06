package xmut.ygnn.petserver.dao;

import xmut.ygnn.petserver.entity.Article;
import xmut.ygnn.petserver.entity.PlayEntity;

import java.util.List;

public interface ArticleDao {

    List<Article> getAllArticle();


    boolean insert(Article article);

    boolean update(Article article);

    boolean delete(Article article);


}
