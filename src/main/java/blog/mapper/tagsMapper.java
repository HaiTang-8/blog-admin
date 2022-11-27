package blog.mapper;

import blog.entity.Tags;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface tagsMapper {

    ArrayList<Tags> findAllTags();

    ArrayList<Tags> findTagsByBlogId(Integer id);

    ArrayList<Tags> findFiveTags();

    ArrayList<Integer> findTagsIdByBlogId(Integer id);

    void deleteBlog_Tags(Integer id);

    void insertBlog_Tags(HashMap<String,Object> map);

    ArrayList<Tags> adminFindAllTag();

    void updateTag(Integer id, String name);

    void insertTag(String name);

    void deleteTag(Integer id);

    void deleteTagAndBlog(Integer id);

}
