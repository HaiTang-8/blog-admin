package blog.controller;

import blog.entity.Blog;
import blog.entity.Tags;
import blog.entity.vo.BlogVoList;
import blog.service.blogService;
import blog.service.tagService;
import blog.utils.DataUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class blogController {

    @Autowired
    private blogService blogService;

    @Autowired
    private tagService tagService;

    //根据id查询对应的博客
    @GetMapping("/blog/{id}")
    public HashMap<String,Object> findBlogById(@PathVariable("id") Integer id){
        Blog blog = blogService.findBlogById(id);

        //增加浏览次数
        blogService.updateBlogViews(id);

        //将时间格式转化为 yyyy-MM-dd
        blog.setUpdate_time(DataUtils.formation(blog.getUpdate_time()));

        ArrayList<Tags> tags = tagService.findTagsByBlogId(id);

        HashMap<String, Object> map = new HashMap<>();
        map.put("blog",blog);
        map.put("tags",tags);
        return map;
    }

    //后台管理页面编辑时初始化页面查询单个博客
    @GetMapping("/findBlogAndTagIdById/{id}")
    public HashMap<String,Object> findBlogAndTagIdById(@PathVariable("id") Integer id){
        Blog blog = blogService.editFindBlogById(id);

        ArrayList<Integer> tags = tagService.findTagsIdByBlogId(id);

        HashMap<String, Object> map = new HashMap<>();
        map.put("blog",blog);
        map.put("tags",tags);
        return map;
    }

    //首页分页接口
    @GetMapping("/blog/page/{pageNumber}")
    public PageInfo<Blog> getPageInfo(@PathVariable("pageNumber") int pageNumber){

        //1.通过调用PageHelper的静态方法开始获取分页数据
        //这里有两个参数，第一个是第几页，第二个是一页显示多少数据.我默认为5
        //当然也可以前端传值设定一页展示多少条数据，这里我简化了操作
        PageHelper.startPage(pageNumber,5);

        //获得所有的博客
        ArrayList<Blog> blogList = blogService.findAllBlog();

        //将时间格式转化为 yyyy-MM-dd
        blogList = DataUtils.formations(blogList);

        //根据全部的博客记录进行分页
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);

        return blogPageInfo;
    }


    //根据typeId来获取博客
    @GetMapping("/findBlogByTypeId/{id}/{pageNumber}")
    public PageInfo<Blog> findBlogByTypeId(@PathVariable("id") Integer id,@PathVariable("pageNumber") Integer pageNumber){
        //1.通过调用PageHelper的静态方法开始获取分页数据
        //这里有两个参数，第一个是第几页，第二个是一页显示多少数据.我默认为5
        //当然也可以前端传值设定一页展示多少条数据，这里我简化了操作
        PageHelper.startPage(pageNumber,5);

        //获得所有的博客
        ArrayList<Blog> blogList = blogService.findBlogByTypeId(id);

        //将时间格式转化为 yyyy-MM-dd
        blogList = DataUtils.formations(blogList);

        //根据全部的博客记录进行分页
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);

        return blogPageInfo;
    }

    //根据tagId来获取博客
    @GetMapping("/findBlogByTagId/{id}/{pageNumber}")
    public PageInfo<Blog> findBlogByTagId(@PathVariable("id") Integer id,@PathVariable("pageNumber") Integer pageNumber){
        //1.通过调用PageHelper的静态方法开始获取分页数据
        //这里有两个参数，第一个是第几页，第二个是一页显示多少数据.我默认为5
        //当然也可以前端传值设定一页展示多少条数据，这里我简化了操作
        PageHelper.startPage(pageNumber,5);

        //获得所有的博客
        ArrayList<Blog> blogList = blogService.findBlogByTagId(id);

        //将时间格式转化为 yyyy-MM-dd
        blogList = DataUtils.formations(blogList);

        //根据全部的博客记录进行分页
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);

        return blogPageInfo;
    }

    //根据年份查询所有博客
    @GetMapping("/findAllBlogByDate")
    public HashMap<String,ArrayList<BlogVoList>> findAllBlogByDate(){
        ArrayList<String> year = blogService.findAllBlogYear();
        HashMap<String, ArrayList<BlogVoList>> map = new HashMap<>();
        for (String y : year) {
            map.put(y,blogService.findAllBlogByYear(y));
        }
        return map;
    }

    //根据内容模糊查询博客
    @GetMapping("/SearchBlog/{basis}/{pageNumber}")
    public PageInfo<Blog> SearchBlog(@PathVariable("basis") String basis,@PathVariable("pageNumber") Integer pageNumber){
        //1.通过调用PageHelper的静态方法开始获取分页数据
        //这里有两个参数，第一个是第几页，第二个是一页显示多少数据.我默认为5
        //当然也可以前端传值设定一页展示多少条数据，这里我简化了操作
        PageHelper.startPage(pageNumber,5);

        //获得所有的博客
        //ArrayList<Blog> blogList = blogService.SearchBlog("%"+basis+"%");
        ArrayList<Blog> blogList = blogService.SearchBlog(basis);

        //将时间格式转化为 yyyy-MM-dd
        blogList = DataUtils.formations(blogList);

        //根据全部的博客记录进行分页
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);

        return blogPageInfo;
    }

    //最新推荐
    @GetMapping("/LatestRecommendation")
    public ArrayList<Blog> LatestRecommendation(){
        return blogService.LatestRecommendation();
    }
}
