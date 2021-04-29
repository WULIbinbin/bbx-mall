package com.bbx.mall.dao;

import com.bbx.mall.modal.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {
    //查列表
    List<Goods> getAll();
    //查详情
    Goods getGoodsDetailById(int goods_id);
    //删
    void delete(int goods_id);
    //改
    void update(Goods g);
    //增
    void create(Goods g);
}
