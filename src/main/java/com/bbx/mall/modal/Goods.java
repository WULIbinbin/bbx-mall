package com.bbx.mall.modal;

public class Goods {
    private int goods_id;
    private String goods_name;
    private String goods_category_id;
    private int selling_price;
    private int original_price;
    private int update_user;

    // 右键 Generate -> Setter and Getter -> Shift全选 -> ok 生成如下代码
    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_category_id() {
        return goods_category_id;
    }

    public void setGoods_category_id(String goods_category_id) {
        this.goods_category_id = goods_category_id;
    }

    public int getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(int selling_price) {
        this.selling_price = selling_price;
    }

    public int getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(int original_price) {
        this.original_price = original_price;
    }

    public int getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(int update_user) {
        this.update_user = update_user;
    }

    // 右键 Generate -> toString() -> 全选 -> ok 生成如下代码

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_category_id='" + goods_category_id + '\'' +
                ", selling_price=" + selling_price +
                ", original_price=" + original_price +
                ", update_user=" + update_user +
                '}';
    }
}
