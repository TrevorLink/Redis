package com.example.springbootredis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HuangSir
 * @date 2021-11-26 11:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
   private String name;
   private int age;
}
