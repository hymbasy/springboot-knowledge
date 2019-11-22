package com.alex.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -4780507730055555546L;

    private Integer id;

    private Integer userId;

    private BigDecimal orderAmt;

    private Date createTime;

    private String desc;
}
