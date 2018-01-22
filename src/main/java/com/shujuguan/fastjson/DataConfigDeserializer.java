package com.shujuguan.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.shujuguan.data.excel.ExcelDataConfig;
import com.shujuguan.entity.data.DataTable;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * dataconfig 泛型 反序列化
 * <strong>note</strong> json字符串 sourceType字段必须在dataConfig字段之前
 * Created by limeng on 18-1-15.
 */
public class DataConfigDeserializer implements ObjectDeserializer {
    private Map<String, Class> map = new HashMap<>();

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        //note json字符串 sourceType字段必须在dataConfig字段之前
        //String sourceType = ((DataTable) parser.getContext().getObject()).getSourceType();
        return (T) parser.parseObject(ExcelDataConfig.class);
    }


    public DataConfigDeserializer() {
        //TODO add 其他类型dataconfig
        map.put("EXCEL", ExcelDataConfig.class);
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_STRING;
    }
}
