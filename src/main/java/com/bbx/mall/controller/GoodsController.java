package com.bbx.mall.controller;

import com.bbx.mall.Service.GoodsService;
import com.bbx.mall.common.BizException;
import com.bbx.mall.common.ResultBody;
import com.bbx.mall.modal.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mall")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    final String JSONContent = "application/json;charset=UTF-8";

    @RequestMapping(value="/goods-list",method= RequestMethod.POST,produces=JSONContent)
    public ResultBody GoodList(){
        List<Goods> list = goodsService.getAll();
        return ResultBody.success(list);
    }

    @RequestMapping(value="/goods-detail",method= RequestMethod.POST,produces=JSONContent)
    public ResultBody GoodDetail(@RequestBody Goods goods){
        if(goods.getGoods_id()==0){
            throw new BizException("-1","goods_id不能为空");
        }
        Goods detail = goodsService.getGoodsDetailById(goods.getGoods_id());
        System.out.println(detail);
        return ResultBody.success(detail);
    }

    @RequestMapping(value="/goods-update",method= RequestMethod.POST,produces=JSONContent)
    public ResultBody UpdateGoods(@RequestBody Goods goods){
        if(goods.getGoods_id()==0){
            throw new BizException("-1","goods_id不能为空");
        }
        goodsService.update(goods);
        Goods detail = goodsService.getGoodsDetailById(goods.getGoods_id());
        System.out.println(detail);
        return ResultBody.success(detail);
    }


}

