package com.test.config.page;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class MyPage<T> {
    @JSONField(ordinal = 1)
    private Integer code = 200;// 状态码，默认状态

    @JSONField(ordinal = 2)
    private String message = "";// 提示消息或者错误消息

    @JSONField(ordinal = 3)
    private String apiId = "";// 请求的唯一标识，预留

    @JSONField(ordinal = 4)
    private Integer totalCount = 0;//记录总数

    @JSONField(ordinal = 5)
    private List<T> rows = Collections.emptyList();//本次返回的数据列表

}
