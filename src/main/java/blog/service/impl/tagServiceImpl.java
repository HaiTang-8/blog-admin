package blog.service.impl;

import blog.entity.Tags;
import blog.mapper.tagsMapper;
import blog.service.tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class tagServiceImpl implements tagService {

    @Autowired
    private tagsMapper tagsMapper;

    @Override
    public ArrayList<Tags> findAllTags() {
        return tagsMapper.findAllTags();
    }

    @Override
    public ArrayList<Tags> findTagsByBlogId(Integer id) {
        return tagsMapper.findTagsByBlogId(id);
    }

    @Override
    public ArrayList<Tags> findFiveTags() {
        return tagsMapper.findFiveTags();
    }

    @Override
    public ArrayList<Integer> findTagsIdByBlogId(Integer id) {
        return tagsMapper.findTagsIdByBlogId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBlog_Tags(Integer id) {
        tagsMapper.deleteBlog_Tags(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBlog_Tags(HashMap<String, Object> map) {
        tagsMapper.insertBlog_Tags(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArrayList<Tags> adminFindAllTag() {
        return tagsMapper.adminFindAllTag();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTag(Integer id, String name) {
        tagsMapper.updateTag(id,name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTag(String name) {
        tagsMapper.insertTag(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTag(Integer id) {
        tagsMapper.deleteTag(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTagAndBlog(Integer id) {
        tagsMapper.deleteTagAndBlog(id);
    }
}
