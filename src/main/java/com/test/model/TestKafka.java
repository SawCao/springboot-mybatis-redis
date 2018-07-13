package com.test.model;

import lombok.Data;

import java.util.Date;

@Data
public class TestKafka {

    private Long id;

    private String msg;

    private String name_id;

    private String name;

    private Date sendTime;

}
