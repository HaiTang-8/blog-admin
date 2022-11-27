package blog.entity.vo;

import java.io.Serializable;

//用于接收按年份查询的结果集
public class BlogVoList implements Serializable {

    private String MonthDay;
    private String title;
    private Integer id;

    public BlogVoList() {}

    public BlogVoList(String year, String monthDay, String title, Integer id) {
        MonthDay = monthDay;
        this.title = title;
        this.id = id;
    }

    @Override
    public String toString() {
        return "BlogVoList{" +
                "MonthDay='" + MonthDay + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

    public String getMonthDay() {
        return MonthDay;
    }

    public void setMonthDay(String monthDay) {
        MonthDay = monthDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
