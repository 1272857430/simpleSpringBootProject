package com.modal.common.DB.mybatis.config.service;

import com.modal.common.DB.mybatis.DBAccess;
import com.modal.common.DB.mybatis.config.bean.CarInfo;
import com.modal.common.DB.mybatis.config.daoInterface.ICarInfo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 和carinfo表相关的数据库操作
 *
 * @author chengjiade
 */
public class CarInfoService {

    /**
     * 查询最新汽车
     *
     * @return
     */
    public List<CarInfo> QueryNewCar() {
        List<CarInfo> carList = new ArrayList<CarInfo>();
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarInfo iCarInfo = sqlSession.getMapper(ICarInfo.class);
            // 通过iCarInfo执行SQL语句
            carList = iCarInfo.QueryNewCar();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carList;
    }

    /**
     * 查询汽车数目
     *
     * @param parameter
     * @return
     */
    public int QueryCount(Map<String, Object> parameter) {
        int count = 0;
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarInfo iCarInfo = sqlSession.getMapper(ICarInfo.class);
            // 通过iCarInfo执行SQL语句
            count = iCarInfo.QueryCount(parameter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return count;
    }

    /**
     * 查询汽车列表
     *
     * @param parameter
     * @return
     */
    public List<CarInfo> QueryCarInfo(Map<String, Object> parameter) {
        List<CarInfo> carList = new ArrayList<CarInfo>();
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarInfo iCarInfo = sqlSession.getMapper(ICarInfo.class);
            // 通过iCarInfo执行SQL语句
            carList = iCarInfo.QueryCarInfo(parameter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carList;
    }

    /**
     * 根据carId查询某辆汽车信息
     *
     * @param carId
     * @return
     */
    public CarInfo QueryCarInfoById(int carId) {
        CarInfo carInfo = new CarInfo();

        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarInfo iCarInfo = sqlSession.getMapper(ICarInfo.class);
            // 通过carList执行SQL语句
            carInfo = iCarInfo.QueryCarInfoById(carId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carInfo;
    }

    /**
     * 添加汽车信息
     *
     * @param carInfo
     */
    public void AddCarInfo(CarInfo carInfo) {
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarInfo iCarInfo = sqlSession.getMapper(ICarInfo.class);
            // 通过carList执行SQL语句
            iCarInfo.AddCarInfo(carInfo);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 通过userId分页查询汽车列表
     *
     * @param parameter
     * @return
     */
    public List<CarInfo> QueryCarInfoByUserId(Map<String, Object> parameter) {
        List<CarInfo> carList = new ArrayList<CarInfo>();
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarInfo iCarInfo = sqlSession.getMapper(ICarInfo.class);
            // 通过carList执行SQL语句
            carList = iCarInfo.QueryCarInfoByUserId(parameter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carList;
    }

    /**
     * 通过suerId查询汽车数目
     *
     * @param userId
     * @return
     */
    public int QueryCountByUserId(int userId) {
        int count = 0;
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarInfo iCarInfo = sqlSession.getMapper(ICarInfo.class);
            // 通过carList执行SQL语句
            count = iCarInfo.QueryCountByUserId(userId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return count;
    }

    /**
     * 通过id删除某辆汽车
     *
     * @param carId
     * @return
     */
    public void deleteOneByCarId(int carId) {
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarInfo iCarInfo = sqlSession.getMapper(ICarInfo.class);
            // 通过carList执行SQL语句
            iCarInfo.deleteOneByCarId(carId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    public List<CarInfo> QueryCarByPage(Map<String, Object> map) {
        List<CarInfo> carList = new ArrayList<CarInfo>();
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarInfo iCarInfo = sqlSession.getMapper(ICarInfo.class);
            // 通过carList执行SQL语句
            carList = iCarInfo.QueryCarByPage(map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carList;
    }
}
