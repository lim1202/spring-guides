package com.example.demo.component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.common.TextConstant;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class IdArrayTypeHandler implements TypeHandler<List<Long>> {

    @Override
    public void setParameter(PreparedStatement ps, int i, List<Long> parameter, JdbcType jdbcType) throws SQLException {
        if (parameter.isEmpty()) {
            ps.setString(i, "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Long element : parameter) {
                sb.append(element).append(TextConstant.DELIMITER);
            }
            ps.setString(i, sb.toString().substring(0, sb.toString().length() - 1));
        }
    }

    @Override
    public List<Long> getResult(ResultSet rs, String columnName) throws SQLException {
        return stringToLongArray(rs.getString(columnName));
    }

    @Override
    public List<Long> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return stringToLongArray(rs.getString(columnIndex));
    }

    @Override
    public List<Long> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return stringToLongArray(cs.getString(columnIndex));
    }
    
    private List<Long> stringToLongArray(String resultString) {
        List<Long> resultList = new ArrayList<>();
        if (StringUtils.isEmpty(resultString)) return resultList;
        String[] arr = resultString.split(TextConstant.DELIMITER);
        if (arr.length == 0) return resultList;
        for (String s : arr) {
            resultList.add(Long.parseLong(s));
        }
        return resultList;
    }
}
