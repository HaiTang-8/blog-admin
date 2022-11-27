package blog.service;

import blog.entity.Types;

import java.util.ArrayList;

public interface typeService {

    //查询所有的Type
    ArrayList<Types> findAllTypes();

    //只查询5条Type
    ArrayList<Types> findFiveType();

    ArrayList<Types> adminFindAllType();

    void updateType(Integer id,String name);

    void insertType(String name);

    void deleteType(Integer id);

    ArrayList<Integer> typeCorrespondingBlog(Integer id);
}
