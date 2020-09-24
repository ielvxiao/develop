package com.lvxiao.spring.jackson;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-09-24
 */
public class JacksonTest {

    private static enum TestEnum {
        T_1(1,"lll"),;
        private int id;
        private String name;

        TestEnum(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        @JsonValue //转换为json值
        public String getName() {
            return name;
        }
    }
    @JsonRootName(value = "user")
    @JsonPropertyOrder({"d","c","b","name","a"}) //使用排序
    private static class AnyGetterTest{
        private String name;
        private Map<String, Object> map;
        public String a="test";
        public String b="test";
        public String c="test";
        public String d="test";

        @JsonRawValue //嵌套json
        public String json="{\"lv\":\"xiao\"}";
        public AnyGetterTest(String name, Map<String, Object> map) {
            this.name = name;
            this.map = map;
        }

        @JsonGetter("testName")
        public String getName() {
            return name;
        }

        @JsonAnySetter
        public void add(String key, Object value) {
            map.put(key, value);
        }

        @JsonAnyGetter
        public Map<String, Object> getMap() {
            return map;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        //1.使用jackson的@JsonAnyGetter标记Map后，只能用在map可以讲内部的属性提取出来。
        //2.使用jackson的@JsonGetter("testName")标记后，可以改变其中返回的key值。
        Map<String, Object> map = new HashMap<>();
        map.put("name", 1);
        map.put("key2", false);
        AnyGetterTest anyGetterTest = new AnyGetterTest("key0", map);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String s = objectMapper.writeValueAsString(anyGetterTest);
        System.out.println(s);
        //使用JsonVal
        System.out.println(objectMapper.writeValueAsString(TestEnum.T_1));
    }
}
