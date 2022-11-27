package blog.mapper;


import blog.entity.Types;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface typesMapper {

    ArrayList<Types> findAllTypes();

    ArrayList<Types> findFiveType();

    ArrayList<Types> adminFindAllType();

    void updateType(Integer id, String name);

    void insertType(String name);

    void deleteType(Integer id);

    ArrayList<Integer> typeCorrespondingBlog(Integer id);

}
