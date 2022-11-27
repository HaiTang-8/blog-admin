package blog.utils;

import blog.entity.Blog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataUtils {

    //对单个转化
    public static Date formation(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return java.sql.Date.valueOf(format.format(date));
    }

    //对list集合转化为yyyy-MM-dd
    public static ArrayList<Blog> formations(ArrayList<Blog> blogList){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < blogList.size(); i++) {
            java.sql.Date date = java.sql.Date.valueOf(format.format(blogList.get(i).getUpdate_time()));
            blogList.get(i).setUpdate_time(date);
        }
        return blogList;
    }

}
