package com.vicente.lightmall.test;

import com.alibaba.fastjson.JSONArray;

import java.util.Optional;

public class TestConunt {

    public static void main(String[] args) throws Exception {
        JSONArray jsonLongs = null;
        for (int i =0;i<10;i++){
            int index = i;
            Long longStr = Optional.ofNullable(jsonLongs).map(ele -> jsonLongs.size()>index?ele.getLongValue(index) : 0L).orElse(0L);
            System.out.println(longStr);
            //String longStr2 = Optional.ofNullable(jsonLongs).map(ele -> ele.getString(index)).orElse("0");
            //System.out.println(longStr2);
        }

    }
}
