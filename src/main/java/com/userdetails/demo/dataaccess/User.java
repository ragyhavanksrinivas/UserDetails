package com.userdetails.demo.dataaccess;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Getter
@Setter

@Entity
@Table(name= "USER_DETAILS")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name= "userid")
    private String userId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "title")
    private String title;

    @Column(name = "gender")
    private  String gender;

    @Column(name = "street")
    private  String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String  state;

    @Column (name= "postcode")
    private String  postcode;


    }
