package com.shujuguan.mapper;

import com.shujuguan.entity.data.DataTable;

/**
 * Created by limeng on 18-1-12.
 */
public interface DataTableMapper {

    int insertJson(DataTable dataTable);

    int insertJsonb(DataTable dataTable);

    int insertJsonAndJsonb(DataTable dataTable);
}
