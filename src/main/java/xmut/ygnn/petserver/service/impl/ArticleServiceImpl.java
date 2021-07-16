package xmut.ygnn.petserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmut.ygnn.petserver.dao.ArticleDao;
import xmut.ygnn.petserver.entity.Article;
import xmut.ygnn.petserver.entity.PlayEntity;
import xmut.ygnn.petserver.service.ArticleService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleDao articleDao;


    @Override
    public List<PlayEntity> getAllArticle() {
        return articleDao.getAllArticle();
    }

    @Override
    public boolean insert(Article article) {
        return articleDao.insert(article);
    }

    @Override
    public boolean update(Article article) {
        return articleDao.update(article);
    }

    @Override
    public boolean delete(Article article) {
        return articleDao.delete(article);
    }
}
