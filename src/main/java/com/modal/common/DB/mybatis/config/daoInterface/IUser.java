package com.modal.common.DB.mybatis.config.daoInterface;

import com.modal.common.DB.mybatis.config.bean.User;

import java.util.List;
import java.util.Map;


/**
 * 与User.xml配置文件相对应的接口
 *
 * @author chengjiade
 */
public interface IUser {

    /*
     * 查询user列表
     */
    public List<User> QueryUser(User user);

    /*
     * 登陆查询
     */
    public int QueryUserCount(User user);

    /*
     * 注册验证手机号查询
     */
    public int QueryPhoneCount(User user);

    /*
     * 添加用户
     */
    public void AddUser(User user);

    /*
     * 根据用户名和密码查询用户
     */
    public User queryUserByUser(User user);

    /*
     * 根据用户Id查询用户
     */
    public User queryUserById(int userId);

    /*
     * 更新用户信息
     */
    public void updateUser(User user);

    /*
     * 查询所有用户
     */
    public List<User> QueryAllUserByPage(Map<String, Object> map);

    /*
     * 查询用户数目
     */
    public int QueryUserCountByAdmin(Map<String, Object> map);

    /*
     * 删除用户
     */
    public void DeleteUser(int userId);
}
