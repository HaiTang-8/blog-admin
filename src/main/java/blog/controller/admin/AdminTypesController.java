package blog.controller.admin;

import blog.entity.Types;
import blog.service.typeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class AdminTypesController {

    private final typeService typeService;

    @Autowired
    public AdminTypesController(blog.service.typeService typeService) {
        this.typeService = typeService;
    }

    //查询所有分类
    @GetMapping("/admin/findAllType/{pageNumber}")
    public PageInfo<Types> adminFindAllType(@PathVariable int pageNumber){

        PageHelper.startPage(pageNumber,5);
        ArrayList<Types> list = typeService.adminFindAllType();
        return new PageInfo<>(list);
    }

    //保存以及新增分类
    @PostMapping("/admin/updateType")
    public HashMap<String,String> updateType(@RequestBody HashMap<String,Object> map){
        //返回结果
        HashMap<String, String> result = new HashMap<>();
        //判断传来的map是否携带了id
        //如果携带了id，则代表是修改type
        //如果没用携带id，则代表是新增type
        if (map.get("id") == null){
            try {
                typeService.insertType((String) map.get("name"));
            } catch (Exception e) {
                result.put("msg","error");
                e.printStackTrace();
            }
        }else {
            try {
                typeService.updateType((Integer) map.get("id"),(String) map.get("name"));
            } catch (Exception e) {
                result.put("msg","error");
                e.printStackTrace();
            }
        }
        result.put("msg","success");
        return result;
    }

    //删除标签
    @GetMapping("/admin/deleteType/{id}")
    public HashMap<String,String> deleteType(@PathVariable Integer id){
        HashMap<String, String> map = new HashMap<>();
        try {
            //先查询该type是否还对应着博客
            //只要有一篇博客还对应着就不能删除
            ArrayList<Integer> integers = typeService.typeCorrespondingBlog(id);
            if (integers.size() == 0){
                typeService.deleteType(id);
                map.put("state","success");
                map.put("msg","删除成功");
            }else {
                map.put("state","error");
                map.put("msg","非法操作,该标签还存在对应的博客，无法删除");
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state","error");
            map.put("msg","删除失败");
            return map;
        }
    }
}
