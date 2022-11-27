package blog.controller.admin;

import blog.entity.Tags;
import blog.service.tagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class adminTagsController {

    @Autowired
    private tagService tagService;


    //查询所有的tag
    @GetMapping("/admin/adminFindAllTag/{pageNumber}")
    public PageInfo<Tags> adminFindAllTag(@PathVariable int pageNumber){

        PageHelper.startPage(pageNumber,5);
        ArrayList<Tags> list = tagService.adminFindAllTag();
        PageInfo<Tags> info = new PageInfo<>(list);
        return info;
    }

    //保存以及新增tag
    @PostMapping("/admin/updateTag")
    public HashMap<String,String> updateType(@RequestBody HashMap<String,Object> map){
        //返回结果
        HashMap<String, String> result = new HashMap<>();
        System.out.println(map);
        //判断传来的map是否携带了id
        //如果携带了id，则代表是修改type
        //如果没用携带id，则代表是新增type
        if (map.get("id") == null){
            try {
                tagService.insertTag((String) map.get("name"));
            } catch (Exception e) {
                result.put("msg","error");
                e.printStackTrace();
            }
        }else {
            try {
                tagService.updateTag((Integer) map.get("id"),(String) map.get("name"));
            } catch (Exception e) {
                result.put("msg","error");
                e.printStackTrace();
            }
        }
        result.put("msg","success");
        return result;
    }

    //删除标签
    @GetMapping("/admin/deleteTag/{id}")
    public String deleteTag(@PathVariable Integer id){
        try {
            tagService.deleteTag(id);
            tagService.deleteTagAndBlog(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
