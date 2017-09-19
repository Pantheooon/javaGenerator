package dao;


import model.TableColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用于查询数据库中表的信息
 */
public interface ITableDao {


    List<String> showTables();

    List<TableColumn> showFields(@Param("tableName") String tableName);
}
