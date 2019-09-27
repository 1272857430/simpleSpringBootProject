package cn.cjd.springboot.modal.common.DB.mybatis.config.service;

import cn.cjd.springboot.modal.common.DB.mybatis.DBAccess;
import cn.cjd.springboot.modal.common.DB.mybatis.config.bean.CarType;
import cn.cjd.springboot.modal.common.DB.mybatis.config.daoInterface.ICarType;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * 和cartype表相关的数据库操作
 *
 * @author chengjiade
 */
public class CarTypeService {

    /*
     * 查询车类型对应的id
     */
    public int queryCarTypeId(CarType carType) {
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        int id = 0;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarType iCarType = sqlSession.getMapper(ICarType.class);
            // 通过iCarBrand执行SQL语句
            id = iCarType.querycarTypeId(carType);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return id;
    }


    /*
     * 查询车id对应的类型
     */
    public String queryCarType(int carTypeId) {
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        String carType = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarType iCarType = sqlSession.getMapper(ICarType.class);
            // 通过iCarBrand执行SQL语句
            carType = iCarType.querycarType(carTypeId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carType;
    }


    /*
     * 模糊查询汽车类型的ID
     */
    public CarType queryTruecarTypeId(String inp) {
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        CarType carType = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarType iCarType = sqlSession.getMapper(ICarType.class);
            // 通过iCarBrand执行SQL语句
            carType = iCarType.queryTruecarTypeId(inp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carType;
    }


}
