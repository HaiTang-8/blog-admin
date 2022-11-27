package blog.mapper;

import blog.entity.Blog;
import blog.entity.vo.BlogVoList;
import blog.entity.vo.editBlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface blogMapper {

    //根据id查询单个博客
    Blog findBlogById(Integer id);

    //查询所有博客
    ArrayList<Blog> findAllBlog();

    //根据TypeId查询博客
    ArrayList<Blog> findBlogByTypeId(Integer id);

    //根据TagId查询博客
    ArrayList<Blog> findBlogByTagId(Integer id);

    //根据年份查询所有博客
    ArrayList<BlogVoList> findAllBlogByYear(String year);

    ArrayList<String> findAllBlogYear();

    ArrayList<Blog> SearchBlog(String basis);

    ArrayList<Blog> findAllBlogAdmin();

    ArrayList<Blog> findBlogByTitleAndType(String title, String typeName);

    Blog editFindBlogById(Integer id);

    void updateBlog(editBlog editBlog);

    Integer findNewBlog();

    void insertBlog(editBlog editBlog);

    void deleteBlogById(Integer id);

    ArrayList<Blog> LatestRecommendation();

    void updateBlogViews(Integer id);
}
