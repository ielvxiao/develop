package com.lvxiao.algorithm.function;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * @author lvxiao
 * @date 2020/4/5
 */
@Data
@AllArgsConstructor
class Address {
    private String road;
    private String building;
}
@Data
@AllArgsConstructor
class PersonObj {
    private Integer id;
    private Address Address;
    private String name;
}
public class OptionalTest {
    private static String getRoad(PersonObj person) {
        return Optional.ofNullable(person)
                .map(PersonObj::getAddress)
                .map(Address::getRoad)
                .orElse("地址不存在");
    }

    public static void main(String[] args) {
        PersonObj obj = new PersonObj(1, new Address("融化路", "朝林广场"), "吕啸");
        System.out.println(OptionalTest.getRoad(obj));
        System.out.println(OptionalTest.getRoad(null));
    }
}
