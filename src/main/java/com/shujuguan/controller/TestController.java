package com.shujuguan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.shujuguan.entity.data.DataConfig;
import com.shujuguan.entity.data.DataTable;
import com.shujuguan.fastjson.DataConfigDeserializer;
import com.shujuguan.mapper.DataTableMapper;
import com.shujuguan.mongo.dao.DataTableDao;
import com.shujuguan.utils.ObjectUtils;
import com.shujuguan.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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

    private static final String dtJson = "{\"sourceType\":\"EXCEL\",\"accessList\":[{\"key\":\"1000068\"}],\"accesses\":{\"1000068\":{\"filters\":[]}},\"chartIds\":[],\"columns\":[{\"categroyQuality\":112.0,\"columnName\":\"c0vfc82ced4b4de425fa4ff8a88c10f34ce\",\"columnType\":\"ID\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"INTEGER\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"球员编号\",\"oriColumnType\":\"ID\",\"sourceColumnType\":\"INTEGER\",\"sourceIndex\":0,\"sourceName\":\"球员编号\",\"typeOK\":true},{\"categroyQuality\":112.0,\"columnName\":\"c1a257e8c475e6e4a709212b2261f525648\",\"columnType\":\"TEXT\",\"columnWidth\":16,\"dataQuality\":1.0,\"dataType\":\"STRING\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"球员\",\"oriColumnType\":\"TEXT\",\"sourceColumnType\":\"STRING\",\"sourceIndex\":1,\"sourceName\":\"球员\",\"typeOK\":true},{\"categroyQuality\":16.0,\"columnName\":\"c2q58f4895c424a4c46b909cd0255d1d712\",\"columnType\":\"TEXT\",\"columnWidth\":8,\"dataQuality\":1.0,\"dataType\":\"STRING\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"球队\",\"oriColumnType\":\"TEXT\",\"sourceColumnType\":\"STRING\",\"sourceIndex\":2,\"sourceName\":\"球队\",\"typeOK\":true},{\"categroyQuality\":5.0,\"columnName\":\"c3b252bbc68480b40ad930c9630e19b1542\",\"columnType\":\"TEXT\",\"columnWidth\":8,\"dataQuality\":1.0,\"dataType\":\"STRING\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"位置\",\"oriColumnType\":\"TEXT\",\"sourceColumnType\":\"STRING\",\"sourceIndex\":3,\"sourceName\":\"位置\",\"typeOK\":true},{\"categroyQuality\":13.0,\"columnName\":\"c4v01ba87fef6fc45d99156f7e764913a73\",\"columnType\":\"INTEGER\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"INTEGER\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"出场\",\"oriColumnType\":\"INTEGER\",\"sourceColumnType\":\"INTEGER\",\"sourceIndex\":4,\"sourceName\":\"出场\",\"typeOK\":true},{\"categroyQuality\":17.0,\"columnName\":\"c5t7070409ae78b44be8fabda384719e9e9\",\"columnType\":\"INTEGER\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"INTEGER\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"先发\",\"oriColumnType\":\"INTEGER\",\"sourceColumnType\":\"INTEGER\",\"sourceIndex\":5,\"sourceName\":\"先发\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c6x0f27f00459264923ae65336ada1fc1c1\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"分钟\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":6,\"sourceName\":\"分钟\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c7u38aacf84c31c4c27a4862c94b47e4b55\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"命中率\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":7,\"sourceName\":\"命中率\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c8ca789215ec6fc4e4c8b20037bef9a2a77\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"三分命中率\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":8,\"sourceName\":\"三分命中率\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c9f7a35d88d490748c1baa343dd8aca1d6a\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"罚球命中率\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":9,\"sourceName\":\"罚球命中率\",\"typeOK\":true},{\"categroyQuality\":11.0,\"columnName\":\"c10v2a79cd44fdf4489693f98e7d01dce1e0\",\"columnType\":\"INTEGER\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"INTEGER\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"两双\",\"oriColumnType\":\"INTEGER\",\"sourceColumnType\":\"INTEGER\",\"sourceIndex\":10,\"sourceName\":\"两双\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c11z8cae8d70c9774c74b6b4c20f8262065a\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"效率\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":11,\"sourceName\":\"效率\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c12be5c5be14a7ed42ae903dd6df83795dd5\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"进攻\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":12,\"sourceName\":\"进攻\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c13ba7ae1091e03649378eccedeb11f9c57e\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"防守\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":13,\"sourceName\":\"防守\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c14w7ab7a9a83ac8410283cc0ac011507acb\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"篮板\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":14,\"sourceName\":\"篮板\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c15rb7efb061c0494331b4470a664e7b99ae\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"助攻\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":15,\"sourceName\":\"助攻\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c16dab0a8c3e795c46338f6781627d570476\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"抢断\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":16,\"sourceName\":\"抢断\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c17qbbae4f1ef1df4304aaab3198230f2dc0\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"盖帽\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":17,\"sourceName\":\"盖帽\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c18s3ddbe151326f4000882c1cdd71fb8d42\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"失误\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":18,\"sourceName\":\"失误\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c19d9c31e0ac4a0449588f5c8a7583c690f1\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"犯规\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":19,\"sourceName\":\"犯规\",\"typeOK\":true},{\"categroyQuality\":0.0,\"columnName\":\"c20e8934a655e84248cf9cb70e23a140042f\",\"columnType\":\"DECIMAL\",\"columnWidth\":64,\"dataQuality\":1.0,\"dataType\":\"DOUBLE\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"format\":{\"DATETIME\":\"yyyy/MM/dd hh:mm:ss\",\"DAY\":\"yyyy/MM/dd\",\"DURATION\":\"hh:mm'ss\\\"SSS\",\"MONTH\":\"yyyy/MM\",\"QUARTER\":\"yyyy Q\",\"TIME\":\"hh:mm:ss\",\"YEAR\":\"yyyy\",\"currency\":{\"position\":\"pre\",\"symbol\":\"\"},\"decimals\":\"auto\",\"level\":\"DATETIME\",\"percentage\":false,\"separated\":false},\"level\":\"DATETIME\",\"lost\":false,\"name\":\"得分\",\"oriColumnType\":\"DECIMAL\",\"sourceColumnType\":\"DOUBLE\",\"sourceIndex\":20,\"sourceName\":\"得分\",\"typeOK\":true},{\"categroyQuality\":1.0,\"columnName\":\"_sjg_filename_\",\"columnType\":\"TEXT\",\"columnWidth\":255,\"dataQuality\":1.0,\"dataType\":\"STRING\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"lost\":false,\"name\":\"_上传文件名称_\",\"sourceColumnType\":\"STRING\",\"sourceIndex\":21,\"sourceName\":\"_上传文件名称_\",\"typeOK\":true},{\"categroyQuality\":1.0,\"columnName\":\"_sjg_uploadtime_\",\"columnType\":\"DATETIME\",\"columnWidth\":255,\"dataQuality\":1.0,\"dataType\":\"DATETIME\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"lost\":false,\"name\":\"_文件上传时间_\",\"sourceColumnType\":\"DATETIME\",\"sourceIndex\":22,\"sourceName\":\"_文件上传时间_\",\"typeOK\":true},{\"categroyQuality\":1.0,\"columnName\":\"_sjg_uploadcount_\",\"columnType\":\"INTEGER\",\"columnWidth\":255,\"dataQuality\":1.0,\"dataType\":\"INTEGER\",\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"lost\":false,\"name\":\"_文件更新次数_\",\"sourceColumnType\":\"INTEGER\",\"sourceIndex\":23,\"sourceName\":\"_文件更新次数_\",\"typeOK\":true}],\"createDate\":1515641193868,\"dataConfig\":{\"append\":false,\"columns\":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],\"dataFileId\":\"5a56d96638634d0cab29ef01\",\"dataStoreId\":\"5a56d989ad32df69aef2c68d\",\"deleteRows\":[],\"filename\":\"NBA2011-2012季后赛球员数据统计.xlsx\",\"maxRow\":112,\"name\":\"NBA2011-2012季后赛球员数据统计.xlsx:球员得分数据统计\",\"sheetIndex\":0,\"sheetName\":\"球员得分数据统计\",\"sourceType\":\"EXCEL\",\"storageSize\":31994,\"titleRow\":0,\"updateData\":false,\"updateType\":0,\"uploadCount\":1,\"uploadDate\":1515641193657},\"dataSize\":112,\"dbTableName\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"deleted\":0,\"displayType\":\"EXCEL\",\"enableAuth\":true,\"groupAccessList\":[],\"groupAccesses\":{},\"id\":\"kfd2c79bdd8b44e24bc96c2dfe29d60eb\",\"name\":\"NBA2011-2012季后赛球员数据统计.xlsx:球员得分数据统计\",\"ownerId\":\"7\",\"policies\":[],\"revisions\":[],\"status\":\"CONFIRMED\",\"updateDate\":1515641316857,\"userId\":\"1000009\",\"version\":0}";
    private static byte[] datas;
    private static DataTable DATATABLE;

    static {
        ParserConfig jcParserConfig = new ParserConfig();
        jcParserConfig.putDeserializer(DataConfig.class, new DataConfigDeserializer());
        DATATABLE = JSON.parseObject(dtJson.toString(), DataTable.class, jcParserConfig, JSON.DEFAULT_PARSER_FEATURE);
        try {
            datas = ObjectUtils.serialize(DATATABLE);
        } catch (Exception e) {
            e.printStackTrace();
            datas = null;
        }
    }

    private DataTable getDataTable(HttpServletRequest httpRequest) {
//        ParserConfig jcParserConfig = new ParserConfig();
//        jcParserConfig.putDeserializer(DataConfig.class, new DataConfigDeserializer());
//        try {
//            final Reader reader = new InputStreamReader(httpRequest.getInputStream(), Charset.forName("utf8"));
//            final CharArrayBuffer buffer = new CharArrayBuffer(httpRequest.getContentLength());
//            final char[] tmp = new char[1024];
//            int l;
//            while((l = reader.read(tmp)) != -1) {
//                buffer.append(tmp, 0, l);
//            }
//            //buffer
//            return JSON.parseObject( buffer.toString(), DataTable.class, jcParserConfig, JSON.DEFAULT_PARSER_FEATURE);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            return ObjectUtils.deserialize(datas);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/mongo/add", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add1(HttpServletRequest request) {
        DataTable dataTable = getDataTable(request);
        dataTable.setId(UUID.randomUUID().toString());
        dataTableDao.insert(dataTable);
    }

    @RequestMapping(value = "/mongo/{id}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add1(@PathVariable String id) {
        dataTableDao.getByID(id);
    }

    @RequestMapping(value = "/postgres/json/add", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add2(HttpServletRequest request) {
        DataTable dataTable = getDataTable(request);
        dataTable.setId(UUID.randomUUID().toString());
        dataTableMapper.insertJson(dataTable);
    }

    @RequestMapping(value = "/postgres/json/{id}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void get(@PathVariable String id) {
        dataTableMapper.getJsonById(id);
    }


    @RequestMapping(value = "/postgres/jsonb/add", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add3(HttpServletRequest request) {
        DataTable dataTable = getDataTable(request);
        dataTable.setId(UUIDGenerator.generateUUID());
        dataTableMapper.insertJsonb(dataTable);
    }

    @RequestMapping(value = "/postgres/jsonb/{id}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add3(@PathVariable String id) {
        dataTableMapper.getJsonbById(id);
    }

    @RequestMapping(value = "/postgres/mix/add", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add4(HttpServletRequest request) {
        DataTable dataTable = getDataTable(request);
        dataTable.setId(UUIDGenerator.generateUUID());
        dataTableMapper.insertJsonAndJsonb(dataTable);
    }

    @RequestMapping(value = "/postgres/mix/{id}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void add4(@PathVariable String id) {
        dataTableMapper.getMixById(id);
    }


}
