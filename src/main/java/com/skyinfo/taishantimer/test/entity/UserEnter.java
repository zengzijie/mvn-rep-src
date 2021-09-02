package com.skyinfo.taishantimer.test.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "t_userenter_info")
public class UserEnter {
    @Id
    @ApiModelProperty(value = "主键", name = "id", example = "12146788194582528")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String user_id;
    private String block_name;
    private String id_number;
    private String create_time;
    private String create_timestamp;
    private String block_id;
    private String in_out_flag;
    private String rksj;
}
