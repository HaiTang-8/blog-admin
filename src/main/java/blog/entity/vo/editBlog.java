package blog.entity.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class editBlog implements Serializable {

    private Integer id;
    private String title;
    private String content;
    private Integer typeName;
    private ArrayList<Integer> tags;
    private String first_picture;
    private String description;

    @Override
    public String toString() {
        return "editBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", typeName='" + typeName + '\'' +
                ", tags=" + tags +
                ", first_picture='" + first_picture + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeName() {
        return typeName;
    }

    public void setTypeName(Integer typeName) {
        this.typeName = typeName;
    }

    public editBlog(Integer id, String title, String content, Integer typeName, ArrayList<Integer> tags, String first_picture, String description) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.typeName = typeName;
        this.tags = tags;
        this.first_picture = first_picture;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Integer> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Integer> tags) {
        this.tags = tags;
    }

    public String getFirst_picture() {
        return first_picture;
    }

    public void setFirst_picture(String first_picture) {
        this.first_picture = first_picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public editBlog() {
    }
}
