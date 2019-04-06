package com.example.yathaarth.assignement2.Models;

public class SocialItem {
    String name;
    String desc;
    int image_resource_id;     // We refer to image using an integer id i.e indexed

    public SocialItem(String name,String desc, int image_resource_id) {
        this.name = name;
        this.desc = desc;
        this.image_resource_id = image_resource_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage_resource_id() {
        return image_resource_id;
    }

    public void setImage_resource_id(int image_resource_id) {
        this.image_resource_id = image_resource_id;
    }
}

