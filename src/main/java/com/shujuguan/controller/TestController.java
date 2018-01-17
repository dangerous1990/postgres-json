package com.shujuguan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.shujuguan.entity.data.DataConfig;
import com.shujuguan.entity.data.DataTable;
import com.shujuguan.fastjson.DataConfigDeserializer;
import com.shujuguan.mapper.DataTableMapper;
import com.shujuguan.mongo.dao.DataTableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by limeng on 18-1-17.
 */
@RestController
@RequestMapping("datatable")
public class TestController {

    @Autowired
    private DataTableDao dataTableDao;

    @Autowired
    private DataTableMapper dataTableMapper;

    private DataTable getDataTable(HttpServletRequest httpRequest) {
        ParserConfig jcParserConfig = new ParserConfig();
        jcParserConfig.putDeserializer(DataConfig.class, new DataConfigDeserializer());
        try {
            InputStream input = httpRequest.getInputStream();
            StringBuffer content = new StringBuffer();
            byte[] buffer = new byte[1024];
            while (input.read(buffer, 0, 1024) != -1) {
                content.append(buffer);
            }
            return JSON.parseObject(content.toString(), DataTable.class, jcParserConfig, JSON.DEFAULT_PARSER_FEATURE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/mongo/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add1(HttpServletRequest request) {
        dataTableDao.insert(getDataTable(request));
    }

    @RequestMapping(value = "/postgres/json/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add2(HttpServletRequest request) {
        dataTableMapper.insertJson(getDataTable(request));
    }

    @RequestMapping(value = "/postgres/jsonb/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add3(HttpServletRequest request) {
        dataTableMapper.insertJsonb(getDataTable(request));
    }

    @RequestMapping(value = "/postgres/mix/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add4(HttpServletRequest request) {
        dataTableMapper.insertJsonAndJsonb(getDataTable(request));
    }


}
