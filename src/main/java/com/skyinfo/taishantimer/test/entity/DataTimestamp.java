package com.skyinfo.taishantimer.test.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_TIMER_TIMESTAMP")
@Data
public class DataTimestamp implements Serializable {
    @Id
    @ApiModelProperty(value = "主键", name = "id", example = "12146788194582528")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Long timestamp;
    private String type;
    private String rksj;

}
