package com.my.controller;

import com.my.entity.User;
import com.my.mapper.UserDao;
import com.my.service.UserService;
import com.my.util.SessionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Don
 * 用户管理
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    /**
     * 获取登录session
     *
     * @param session
     * @return
     */
    @RequestMapping("getLoginSession")
    public Object getSession(HttpSession session) {
        return session.getAttribute("userInfo") == null ? null : (Map) session.getAttribute("userInfo");
    }

    /**
     * 登录方法
     *
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping("login")
    public Object login(String userName, String passWord, HttpServletRequest request) {
        //收集用户输入
        AuthenticationToken token = new UsernamePasswordToken(userName, passWord);
        //获取登录对象
        Subject crrentUser = SecurityUtils.getSubject();
        //判断是否已经认证
        if (!crrentUser.isAuthenticated()) {
            try {
                //提交数据  交给SecurityManager进行认证   登录
                crrentUser.login(token);
                //更新登录时间和登录IP
                Map map = new HashMap();
                map.put("loginIp", request.getRemoteAddr());
                map.put("userName", userName);
                userService.updateLoginInfoByUserName(map);
                //记录session
                Session session = crrentUser.getSession();
                session.setAttribute("userInfo", (Map) crrentUser.getPrincipal());
                //封装方法中设置session
                SessionUtil.setSession(session);
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 1;
    }


    /**
     * 根据条件查询
     *
     * @param map
     * @return
     */
    @RequestMapping("page")
    public Object list(@RequestParam Map map) {
        return userService.getList(map);
    }

    ;

    /***
     * 添加
     * @param map
     * @return
     */
    @RequestMapping("add")
    public Object add(@RequestBody Map map) {
        return userService.add(map);
    }


    /**
     * 更新
     *
     * @param map
     * @return
     */
    @RequestMapping("update")
    public Object update(@RequestBody Map map) {
        return userService.update(map);
    }


    /**
     * 删除
     *
     * @param userId
     * @return
     */
    @RequestMapping("delete")
    public Object delete(Integer userId) {
        return userService.delete(userId);
    }


    /**
     * 查询用户id对应的角色id集合
     *
     * @param userId
     * @return
     */
    @RequestMapping("listRoleIdsByUserId")
    public Object listRoleIdsByUserId(Integer userId) {
        return userService.listRoleIdsByUserId(userId);
    }

    /**
     * 添加用户角色关联
     *
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping("addUserAndRole")
    public Object addUserAndRole(Integer userId, String roleIds) {
        return userService.addUserAndRole(userId, roleIds);
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @GetMapping("getAll")
    public List<User> getAll() {
        return userDao.getAll();
    }

}
