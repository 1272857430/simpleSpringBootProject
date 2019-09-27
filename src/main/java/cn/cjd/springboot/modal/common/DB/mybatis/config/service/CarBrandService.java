package cn.cjd.springboot.modal.common.DB.mybatis.config.service;

import com.modal.common.DB.mybatis.DBAccess;
import com.modal.common.DB.mybatis.config.bean.CarBrand;
import com.modal.common.DB.mybatis.config.daoInterface.ICarBrand;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * 和carbrand表相关的数据库操作
 *
 * @author chengjiade
 */
public class CarBrandService {

    /*
     * 查询车品牌对应的id
     */
    public int queryCarBrandId(CarBrand carBrand) {
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        int id = 0;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarBrand iCarBrand = sqlSession.getMapper(ICarBrand.class);
            // 通过iCarBrand执行SQL语句
            id = iCarBrand.queryCarBrandId(carBrand);
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
     * 查询车id对应的品牌
     */
    public String queryCarBrand(int carBrandId) {
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        String carBrand = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarBrand iCarBrand = sqlSession.getMapper(ICarBrand.class);
            // 通过iCarBrand执行SQL语句
            carBrand = iCarBrand.queryCarBrand(carBrandId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carBrand;
    }

    /*
     * 模糊查询，查询出正确的品牌名
     */
    public CarBrand queryTrueCarBrandId(String inp) {
        // 获取DBAccess对象
        DBAccess dBAccess = new DBAccess();
        SqlSession sqlSession = null;
        CarBrand carBrand = null;
        try {
            // 通过DBAccess对象，获取SqlSession
            sqlSession = dBAccess.getSqlSession();
            // 通过sqlSession去获取接口，并会产生实现类
            ICarBrand iCarBrand = sqlSession.getMapper(ICarBrand.class);
            // 通过iCarBrand执行SQL语句
            carBrand = iCarBrand.queryTrueCarBrandId(inp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carBrand;
    }
}
