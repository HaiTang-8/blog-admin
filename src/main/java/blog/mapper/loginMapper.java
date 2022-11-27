package blog.mapper;

import blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface loginMapper {
    User findUserByAccount(String account);
}
