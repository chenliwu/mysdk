package com.clw.mysdk.base;

import com.clw.mysdk.utils.GsonUtil;

import java.io.Serializable;

public abstract class BaseBean implements Serializable{

    /**
     * 将对象转化成JSON字符串
     * @return
     */
    public String toJson(){
        String json=null;
        json= GsonUtil.parseObjectToJson(this);
        return json;
    }

    /**
     * 将JSON字符串转化成Java对象
     * 使用方法：   User user=new User();  user=(User) user.fromJson(json);
     * @param json
     */
    public Object fromJson(String json){
        return GsonUtil.parseJsonToObject(json,this.getClass());
    }

}
