package cn.cjd.springboot.modal.db_use.otherDataSource.use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 170096 on 2019/1/22 18:04
 *
 * @author ${User}
 */
@Service
public class UseService {

    @Autowired
    @Qualifier("otherJdbcTemplate")
    private JdbcTemplate otherJdbcTemplate;

    /**
     * 判断表是否存在
     */
    private boolean judgeTableExit(String tableName) throws SQLException {
        String sql = "SELECT table_name FROM information_schema.TABLES WHERE table_name ='" + tableName + "'";
        List resultList = otherJdbcTemplate.queryForList(sql);
        return !CollectionUtils.isEmpty(resultList);
    }

    /**
     * 获取表字段
     */
    private List<String> getTableColumn(String tableName, String dbName) throws SQLException {
        List<String> columnNameList = new ArrayList<>();
        String sql = "select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='" + tableName + "' and table_schema='" + dbName + "'";
        List resultList = otherJdbcTemplate.queryForList(sql);
        resultList.forEach(item -> {
            columnNameList.add(((LinkedCaseInsensitiveMap) item).get("COLUMN_NAME").toString());
        });
        return columnNameList;
    }
}
