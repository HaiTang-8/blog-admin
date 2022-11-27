package blog.service.impl;

import blog.entity.User;
import blog.mapper.loginMapper;
import blog.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements loginService {

    @Autowired
    private loginMapper loginMapper;

    @Override
    public User findUserByAccount(String account) {
        return loginMapper.findUserByAccount(account);
    }
}
