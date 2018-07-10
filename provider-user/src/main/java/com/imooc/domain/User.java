package com.imooc.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
@Data
@Entity
@Table(name = "test_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private Date birthday;

}
