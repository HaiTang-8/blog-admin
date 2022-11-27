package blog.service.impl;

import blog.entity.Types;
import blog.mapper.typesMapper;
import blog.service.typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class typeServiceImpl implements typeService {

    @Autowired
    private typesMapper typesMapper;

    //获得全部类型
    @Override
    public ArrayList<Types> findAllTypes() {
        return typesMapper.findAllTypes();
    }

    @Override
    public ArrayList<Types> findFiveType() {
        return typesMapper.findFiveType();
    }

    @Override
    public ArrayList<Types> adminFindAllType() {
        return typesMapper.adminFindAllType();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateType(Integer id, String name) {
        typesMapper.updateType(id,name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertType(String name) {
        typesMapper.insertType(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteType(Integer id) {
        typesMapper.deleteType(id);
    }

    @Override
    public ArrayList<Integer> typeCorrespondingBlog(Integer id) {
        return typesMapper.typeCorrespondingBlog(id);
    }
}
