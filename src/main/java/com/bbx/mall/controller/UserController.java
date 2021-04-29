package com.bbx.mall.controller;

import com.bbx.mall.common.BizException;
import com.bbx.mall.common.ResultBody;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResultBody login(@RequestBody UserDTO userDTO) {
        if(userDTO.getUsername().isEmpty()){
            throw new BizException("-1","用户名不能为空");
        }
        Map<String,Object> user = new HashMap();
        user.put("name",userDTO.getUsername());
        user.put("password",userDTO.getPassword());
        System.out.println(user);
        return ResultBody.success(user);
    }

}

class UserDTO {
    String username;
    String password;
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}
