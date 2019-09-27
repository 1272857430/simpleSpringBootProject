package cn.cjd.springboot.modal.common.DB.mybatis.config.service;

import com.modal.common.DB.mybatis.DBAccess;
import com.modal.common.DB.mybatis.config.bean.User;
import com.modal.common.DB.mybatis.config.daoInterface.IUser;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 和user表相关的数据库操作
 *
 * @author chengjiade
 */
public class UserService {
    /**
     * 登陆验证
     *
     * @param user
     * @return
     */
    public boolean judge(User user) {
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        int cou = 0; //数据库查询到符合条件的数目
        try {
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession执行SQL语句
            IUser iUser = sqlSession.getMapper(IUser.class);
            cou = iUser.QueryUserCount(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (cou == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户注册
     *
     * @param user
     */
    public void addUser(User user) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IUser iUser = sqlSession.getMapper(IUser.class);
            iUser.AddUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证手机号
     *
     * @param user
     * @return
     */
    public int queryPhone(User user) {
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        int phoneCount = 0;
        try {
            sqlSession = dBAccess.getSqlSession();
            IUser iUser = sqlSession.getMapper(IUser.class);
            phoneCount = iUser.QueryPhoneCount(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return phoneCount;
    }


    /**
     * 根据用户名和密码查询用户信息
     *
     * @param user
     * @return
     */
    public User queryUser(User user) {
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        User u = null;
        try {
            sqlSession = dBAccess.getSqlSession();
            IUser iUser = sqlSession.getMapper(IUser.class);
            u = iUser.queryUserByUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return u;
    }

    /**
     * 根据用户Id查询用户信息
     *
     * @param user
     * @return
     */
    public User queryUserById(int userId) {
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        User u = null;
        try {
            sqlSession = dBAccess.getSqlSession();
            IUser iUser = sqlSession.getMapper(IUser.class);
            u = iUser.queryUserById(userId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return u;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public void updateUser(User user) {
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dBAccess.getSqlSession();
            IUser iUser = sqlSession.getMapper(IUser.class);
            iUser.updateUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 分页查询所有用户
     *
     * @return
     */
    public List<User> QueryAllUserByPage(Map<String, Object> map) {
        List<User> userList = new ArrayList<User>();
        DBAccess dbAccess = new DBAccess();
        SqlSession session = null;
        try {
            session = dbAccess.getSqlSession();
            IUser iuUer = session.getMapper(IUser.class);
            userList = iuUer.QueryAllUserByPage(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * 查询用户数目
     *
     * @return
     */
    public int QueryUserCountByAdmin(Map<String, Object> map) {
        int userCount = 0;
        DBAccess dbAccess = new DBAccess();
        SqlSession session = null;
        try {
            session = dbAccess.getSqlSession();
            IUser iuUer = session.getMapper(IUser.class);
            userCount = iuUer.QueryUserCountByAdmin(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userCount;
    }

    /**
     * 删除用户
     *
     * @param userId
     */
    public void DeleteUser(int userId) {
        DBAccess dbAccess = new DBAccess();
        SqlSession session = null;
        try {
            session = dbAccess.getSqlSession();
            IUser iuUer = session.getMapper(IUser.class);
            iuUer.DeleteUser(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
