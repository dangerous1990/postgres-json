package com.shujuguan.mybatis.type.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shujuguan.entity.data.DataConfig;
import com.shujuguan.fastjson.DataConfigDeserializer;
import com.shujuguan.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by limeng on 18-1-10.
 */
public class JsonTypeHandler<T extends Object> extends BaseTypeHandler<T> {
    private static final ObjectMapper mapper = new ObjectMapper();
    private Class<T> clazz;

    public JsonTypeHandler(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, this.toJson(parameter));
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return this.toObject(rs.getString(columnName), clazz);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return this.toObject(rs.getString(columnIndex), clazz);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return this.toObject(cs.getString(columnIndex), clazz);
    }

    private String toJson(T object) {
        try {
            return JsonUtils.toJson(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private T toObject(String content, Class<?> clazz) {
        if (StringUtils.isNotBlank(content)) {
            try {

                ParserConfig jcParserConfig = new ParserConfig();
                jcParserConfig.putDeserializer(DataConfig.class, new DataConfigDeserializer());
                return JSON.parseObject(content, clazz, jcParserConfig, JSON.DEFAULT_PARSER_FEATURE);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }
}
