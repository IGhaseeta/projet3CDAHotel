//package com.eql.Hotel.dto;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import java.io.Serializable;
//import java.util.Objects;
//
//
//public class Authority implements Serializable {
//
//
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Authority(){}
//    public Authority(String name){
//        this.name=name;
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof Authority)) {
//            return false;
//        }
//        return Objects.equals(name, ((Authority) o).name);
//    }
//}
