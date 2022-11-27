package blog.service.impl;

import blog.entity.Blog;
import blog.entity.vo.BlogVoList;
import blog.entity.vo.editBlog;
import blog.mapper.blogMapper;
import blog.service.blogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class blogServiceImpl implements blogService {

    @Autowired
    private blogMapper blogMapper;

    @Override
    public Blog findBlogById(Integer id) {
        return blogMapper.findBlogById(id);
    }

    @Override
    public Blog editFindBlogById(Integer id) {
        return blogMapper.editFindBlogById(id);
    }

    @Override
    public ArrayList<Blog> findAllBlog() {
        return blogMapper.findAllBlog();
    }

    @Override
    public ArrayList<Blog> findBlogByTypeId(Integer id) {
        return blogMapper.findBlogByTypeId(id);
    }

    @Override
    public ArrayList<Blog> findBlogByTagId(Integer id) {
        return blogMapper.findBlogByTagId(id);
    }

    @Override
    public ArrayList<BlogVoList> findAllBlogByYear(String year) {
        return blogMapper.findAllBlogByYear(year);
    }

    @Override
    public ArrayList<String> findAllBlogYear() {
        return blogMapper.findAllBlogYear();
    }

    @Override
    public ArrayList<Blog> SearchBlog(String basis) {
        return blogMapper.SearchBlog(basis);
    }

    @Override
    public ArrayList<Blog> findAllBlogAdmin() {
        return blogMapper.findAllBlogAdmin();
    }

    @Override
    public ArrayList<Blog> findBlogByTitleAndType(String title, String typeName) {
        return blogMapper.findBlogByTitleAndType(title,typeName);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateBlog(editBlog editBlog) {
        blogMapper.updateBlog(editBlog);
    }

    @Override
    public Integer findNewBlog() {
        return blogMapper.findNewBlog();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBlog(editBlog editBlog) {
        blogMapper.insertBlog(editBlog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBlogById(Integer id) {
        blogMapper.deleteBlogById(id);
    }

    @Override
    public ArrayList<Blog> LatestRecommendation() {
        return blogMapper.LatestRecommendation();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBlogViews(Integer id) {
        blogMapper.updateBlogViews(id);
    }
}
