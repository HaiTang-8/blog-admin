package blog.service;

import blog.entity.Blog;
import blog.entity.vo.BlogVoList;
import blog.entity.vo.editBlog;

import java.util.ArrayList;

public interface blogService {

    //根据Id查询单个博客
    Blog findBlogById(Integer id);

    Blog editFindBlogById(Integer id);

    //查询数据库中所有的博客
    ArrayList<Blog> findAllBlog();

    //根据TypeId来查询博客
    ArrayList<Blog> findBlogByTypeId(Integer id);

    //根据TagId查询博客
    ArrayList<Blog> findBlogByTagId(Integer id);

    //根据年份查询博客
    ArrayList<BlogVoList> findAllBlogByYear(String year);

    //查询博客年份集合
    ArrayList<String> findAllBlogYear();

    ArrayList<Blog> SearchBlog(String basis);

    ArrayList<Blog> findAllBlogAdmin();

    ArrayList<Blog> findBlogByTitleAndType(String title,String typeName);

    void updateBlog(editBlog editBlog);

    Integer findNewBlog();

    void insertBlog(editBlog editBlog);

    void deleteBlogById(Integer id);

    ArrayList<Blog> LatestRecommendation();

    void updateBlogViews(Integer id);
}
