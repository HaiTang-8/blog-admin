package blog.service;

import blog.entity.User;

public interface loginService {

    User findUserByAccount(String account);

}
