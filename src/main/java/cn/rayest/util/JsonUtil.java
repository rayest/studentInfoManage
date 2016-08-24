package cn.rayest.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by Rayest on 2016/8/24 0024.
 */
public class JsonUtil {
    public static JSONArray formatResultSetToJsonArray(ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnNumber = resultSetMetaData.getColumnCount();
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            JSONObject jsonObject = new JSONObject();
            for (int i = 1; i <= columnNumber; i++) {
                jsonObject.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
