package blog.controller.admin;

import blog.entity.User;
import blog.service.loginService;
import blog.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
public class adminLoginController {

    @Autowired
    private loginService loginService;

    @PostMapping("/admin/PostLogin")
    public HashMap<String,Object> Login(@RequestBody User user){
        User sqlUser = loginService.findUserByAccount(user.getAccount());
        //存放返回结果
        HashMap<String,Object> result = new HashMap<>();
        //存放生成token令牌的参数
        HashMap<String, String> map = new HashMap<>();

        try {
            if (sqlUser != null){
                if (user.getPassword().equals(sqlUser.getPassword())){
                    map.put("nickname",sqlUser.getNickname());
                    map.put("account",sqlUser.getAccount());
                    String token = JWTUtils.getToken(map);
                    result.put("state",true);
                    result.put("msg","登录成功");
                    result.put("nickName",sqlUser.getNickname());
                    result.put("token",token);
                    result.put("avatar",sqlUser.getAvatar());
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state",false);
            result.put("msg",e.getMessage());
        }
        result.put("state",false);
        result.put("msg","账号或者密码错误");
        return result;
    }
}
