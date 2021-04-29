package com.bbx.mall.Service;

import com.bbx.mall.dao.GoodsDao;
import com.bbx.mall.modal.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    //右键 Generate -> Delegate Methods -> Shift全选 -> ok 生成如下代码

    public List<Goods> getAll() {
        return goodsDao.getAll();
    }

    public Goods getGoodsDetailById(int goods_id) {
        return goodsDao.getGoodsDetailById(goods_id);
    }

    public void delete(int goods_id) {
        goodsDao.delete(goods_id);
    }

    public void update(Goods g) {
        goodsDao.update(g);
    }

    public void create(Goods g) {
        goodsDao.create(g);
    }
}
