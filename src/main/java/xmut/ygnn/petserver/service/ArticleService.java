package xmut.ygnn.petserver.service;

import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.entity.Article;
import xmut.ygnn.petserver.entity.PlayEntity;

import java.util.List;

@Service
public interface ArticleService {


    List<PlayEntity> getAllArticle();


    boolean insert(Article article);

    boolean update(Article article);

    boolean delete(Article article);


}
