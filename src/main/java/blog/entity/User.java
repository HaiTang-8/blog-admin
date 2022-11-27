package blog.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    //id
    private int id;
    //头像地址
    private String avatar;
    //创建时间
    private Date create_time;
    //邮箱
    private String email;
    //昵称
    private String nickname;
    //密码
    private String password;
    //更新时间
    private Date update_time;
    //账号
    private String account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public User() {}

    public User(int id, String avatar, Date create_time, String email, String nickname, String password, Date update_time, String account) {
        this.id = id;
        this.avatar = avatar;
        this.create_time = create_time;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.update_time = update_time;
        this.account = account;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", create_time=" + create_time +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", update_time=" + update_time +
                ", account='" + account + '\'' +
                '}';
    }
}
