package cn.cjd.springboot.modal.common.DB.mybatis.config.service;

import cn.cjd.springboot.modal.common.DB.mybatis.DBAccess;
import cn.cjd.springboot.modal.common.DB.mybatis.config.bean.SellUser;
import cn.cjd.springboot.modal.common.DB.mybatis.config.daoInterface.ISellUser;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 和SellUser表相关的数据库操作
 *
 * @author chengjiade
 */
public class SellUserService {

    /*
     * 查询售车用户
     */
    public List<SellUser> QuerySellUser(int carId) {
        List<SellUser> sellUserList = new ArrayList<SellUser>();

        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ISellUser iSellUser = sqlSession.getMapper(ISellUser.class);
            // 通过iCarInfo执行SQL语句
            sellUserList = iSellUser.QuerySellUser(carId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return sellUserList;
    }

    /**
     * 查询所有售车用户的数目
     *
     * @param map
     * @return
     */
    public int QuerySellUserCountByAdmin(Map<String, Object> map) {
        int count = 0;
        DBAccess dbAccess = new DBAccess();
        SqlSession session = null;

        try {
            session = dbAccess.getSqlSession();
            ISellUser iSellUser = session.getMapper(ISellUser.class);
            count = iSellUser.QuerySellUserCountByAdmin(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 分页查询售车用户
     *
     * @param carId
     * @return
     */
    public List<SellUser> QuerySellUserByPage(Map<String, Object> map) {
        List<SellUser> sellUserList = new ArrayList<SellUser>();

        DBAccess dbAccess = new DBAccess();
        SqlSession session = null;

        try {
            session = dbAccess.getSqlSession();
            ISellUser iSellUser = session.getMapper(ISellUser.class);
            sellUserList = iSellUser.QuerySellUserByPage(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sellUserList;
    }

    /**
     * 删除sellUser
     *
     * @param sellUserId
     */
    public void DeleteSellUser(int sellUserId) {
        DBAccess dbAccess = new DBAccess();
        SqlSession session = null;
        try {
            session = dbAccess.getSqlSession();
            ISellUser iSellUser = session.getMapper(ISellUser.class);
            iSellUser.DeleteSellUser(sellUserId);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
