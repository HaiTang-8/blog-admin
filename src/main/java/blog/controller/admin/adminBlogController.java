package blog.controller.admin;

import blog.entity.Blog;
import blog.entity.vo.editBlog;
import blog.service.blogService;
import blog.service.tagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class adminBlogController {

    @Autowired
    private blogService blogService;

    @Autowired
    private tagService tagService;


    //查询所有博客以及条件查询博客
    @PostMapping("/admin/findAllBlogAdmin/{pageNumber}")
    public PageInfo<Blog> findAllBlogAdmin(@PathVariable("pageNumber") int pageNumber,
                                           @RequestBody(required = false) HashMap<String,Object> map){
        PageHelper.startPage(pageNumber,5);
        //判断 如果请求体中没有传递map或者是map集合中的所有内容为空
        //这代表：此次请求来自界面初始化或者搜索全部
        //map不为null 或者 map集合中最少有一个key存在内容，则代表是来自条件搜索
        if (map == null || (map.get("title") == null && map.get("typeName") == null) ){
            ArrayList<Blog> blogList = blogService.findAllBlogAdmin();
            PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);
            return blogPageInfo;
        }else {
            //判断title是否为null，为null是则直接传递null，因为要拼接 % 符号
            //如果为空还拼接上符号，SQL语句中的if判断会出现问题
            if (map.get("title") == null){
                ArrayList<Blog> blogList = blogService.findBlogByTitleAndType(null, (String) map.get("typeName"));
                PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);
                return blogPageInfo;
            }else {
                ArrayList<Blog> blogList = blogService.findBlogByTitleAndType("%"+map.get("title")+"%", (String) map.get("typeName"));
                PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);
                return blogPageInfo;
            }
        }
    }

    //保存编辑后的博客
    @PostMapping("/admin/saveBlog")
    public HashMap<String,Object> saveBlog(@RequestBody Map<String,Object> map){

        //返回的结果
        HashMap<String, Object> result = new HashMap<>();
        //使用editBlog来接收map
        editBlog editBlog = new editBlog();
        try {
            editBlog.setTitle((String) map.get("title"));
            editBlog.setContent((String) map.get("content"));
            editBlog.setFirst_picture((String) map.get("first_picture"));
            editBlog.setTypeName((Integer) map.get("typeName"));
            editBlog.setDescription((String) map.get("description"));
            editBlog.setTags((ArrayList<Integer>) map.get("tags"));


            if (map.get("id") != ""){
                editBlog.setId((Integer) map.get("id"));

                //执行更新操作
                blogService.updateBlog(editBlog);

                //如果是不是新博客，则就要吧原有的tag清空
                tagService.deleteBlog_Tags(editBlog.getId());

                //用于存放进行批量插入操作的Map
                HashMap<String, Object> tagsMap = new HashMap<>();
                tagsMap.put("id",editBlog.getId());
                tagsMap.put("list",editBlog.getTags());

                tagService.insertBlog_Tags(tagsMap);
            }else {
                //执行插入操作
                blogService.insertBlog(editBlog);

                //不是新博客就不需要执行清空操作，直接开始批量添加
                //添加需要博客id，需要先拿到上面保存的博客id
                Integer id = blogService.findNewBlog();

                //用于存放进行批量插入操作的Map
                HashMap<String, Object> tagsMap = new HashMap<>();
                tagsMap.put("id",id);
                tagsMap.put("list",editBlog.getTags());

                tagService.insertBlog_Tags(tagsMap);
            }
            result.put("msg","success");
        } catch (Exception e) {
            result.put("msg","error");
            e.printStackTrace();
        }
        return result;
    }

    //删除博客
    @GetMapping("/admin/deleteBlogById/{id}")
    public String deleteBlogById(@PathVariable Integer id){
        try {
            blogService.deleteBlogById(id);
            tagService.deleteBlog_Tags(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
