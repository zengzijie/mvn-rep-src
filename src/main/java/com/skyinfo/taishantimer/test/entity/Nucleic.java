package com.skyinfo.taishantimer.test.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "t_nucleic_info")
public class Nucleic implements Serializable {
    @Id
//    @ApiModelProperty(value = "主键", name = "id", example = "12146788194582528")
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GenericGenerator(name = "custom-id", strategy = "com.skyinfo.taishantimer.config.CustomUUIDGenerator")
    @GeneratedValue(generator = "custom-id")
    private String id;
    private String street_name;
    private String community_name;
    private String name;
    private String building;
    private String unit;
    private String room;
    private String real_name;
    private String id_number;
    private String img;
    private String phone;
    private String ownership;
    private String create_time;
    private String relation;
    private String create_timestamp;
    private String update_time;
    private String update_timestamp;
    private String bind_time;
    private String block_id;
    private String rksj;
}
