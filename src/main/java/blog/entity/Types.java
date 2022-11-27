package blog.entity;

import java.io.Serializable;

public class Types implements Serializable {

    private Integer id;
    private String name;
    private Integer size;


    public Types() {}

    public Types(Integer id, String name, Integer size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Types{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
