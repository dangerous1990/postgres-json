package com.shujuguan.mybatis.type.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;

import java.sql.*;
import java.util.Collection;

/**
 * Created by limeng on 18-1-10.
 */
public class ArrayTypeHandler<T> extends BaseTypeHandler<T> {
    private static final String TYPE_NAME_VARCHAR = "varchar";
    private static final String TYPE_NAME_INTEGER = "integer";
    private static final String TYPE_NAME_BOOLEAN = "boolean";
    private static final String TYPE_NAME_NUMERIC = "numeric";
    private static final String TYPE_NAME_JSON = "json";
    private Class<T> clazz;

    public ArrayTypeHandler(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        String typeName = null;
        if (parameter instanceof Integer[]) {
            typeName = TYPE_NAME_INTEGER;
        } else if (parameter instanceof String[]) {
            typeName = TYPE_NAME_VARCHAR;
        } else if (parameter instanceof Boolean[]) {
            typeName = TYPE_NAME_BOOLEAN;
        } else if (parameter instanceof Double[]) {
            typeName = TYPE_NAME_NUMERIC;
        } else {
            typeName = TYPE_NAME_JSON;
        }
        if (typeName == null) {
            throw new TypeException("ArrayTypeHandler parameter typeName error, your type is " + parameter.getClass().getName());
        }
        Connection conn = ps.getConnection();
        if (clazz.isArray()) {
            Array array = conn.createArrayOf(typeName, (Object[]) parameter);
            ps.setArray(i, array);
        } else if (parameter instanceof Collection) {
            Object[] newArray = ((Collection) parameter).toArray();
            Array array = conn.createArrayOf("varchar", newArray);
            ps.setArray(i, array);
        }
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return (T)getArray(resultSet.getArray(s));
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return (T)getArray(resultSet.getArray(i));
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return (T)getArray(callableStatement.getArray(i));
    }

    private Object[] getArray(Array array) {
        if (array == null) {
            return null;
        }
        try {
            return (Object[]) array.getArray();
        } catch (Exception e) {
        }
        return null;
    }

}
