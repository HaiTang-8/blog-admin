package blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Blog implements Serializable {

    private Integer id;
    private String content;
    private Date create_time;
    private Date update_time;
    private String first_picture;
    private String title;
    private Integer views;
    private String type_id;
    private String user_id;
    private String description;
    private String typeName;
    private String nickName;
    private String avatar;
    private ArrayList<Tags> tags;

    public Blog() {}

    public Blog(Integer id, String content, Date create_time, Date update_time, String first_picture, String title, Integer views, String type_id, String user_id, String description, String typeName, String nickName, String avatar, ArrayList<Tags> tags) {
        this.id = id;
        this.content = content;
        this.create_time = create_time;
        this.update_time = update_time;
        this.first_picture = first_picture;
        this.title = title;
        this.views = views;
        this.type_id = type_id;
        this.user_id = user_id;
        this.description = description;
        this.typeName = typeName;
        this.nickName = nickName;
        this.avatar = avatar;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", first_picture='" + first_picture + '\'' +
                ", title='" + title + '\'' +
                ", views=" + views +
                ", type_id='" + type_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", description='" + description + '\'' +
                ", typeName='" + typeName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", tags=" + tags +
                '}';
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getFirst_picture() {
        return first_picture;
    }

    public void setFirst_picture(String first_picture) {
        this.first_picture = first_picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
