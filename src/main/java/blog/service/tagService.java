package blog.service;

import blog.entity.Tags;

import java.util.ArrayList;
import java.util.HashMap;

public interface tagService {

    //查询所有Tags
    ArrayList<Tags> findAllTags();

    //根据blogId查询Tags
    ArrayList<Tags> findTagsByBlogId(Integer id);

    //查询五条Tags
    ArrayList<Tags> findFiveTags();

    ArrayList<Integer> findTagsIdByBlogId(Integer id);

    void deleteBlog_Tags(Integer id);

    void insertBlog_Tags(HashMap<String,Object> map);

    ArrayList<Tags> adminFindAllTag();

    void updateTag(Integer id,String name);

    void insertTag(String name);

    void deleteTag(Integer id);

    void deleteTagAndBlog(Integer id);
}
