package com.ling;

import com.ling.entity.Commodity;
import com.ling.service.CommodityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Lian on 03/07/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityServiceTest {
    @Autowired
    private CommodityService commodityService;

    @Test
    public void contextLoads() {
        System.out.println(commodityService.count());
    }

    @Test
    public void testInsert() {
        Commodity commodity = new Commodity();
        commodity.setSkuId("1501009001");
        commodity.setName("原味切片面包（10片装）");
        commodity.setCategory("101");
        commodity.setPrice(880);
        commodity.setBrand("良品铺子");
        commodityService.save(commodity);

        commodity = new Commodity();
        commodity.setSkuId("1501009002");
        commodity.setName("原味切片面包（6片装）");
        commodity.setCategory("101");
        commodity.setPrice(680);
        commodity.setBrand("良品铺子");
        commodityService.save(commodity);

        commodity = new Commodity();
        commodity.setSkuId("1501009004");
        commodity.setName("元气吐司850g");
        commodity.setCategory("101");
        commodity.setPrice(120);
        commodity.setBrand("百草味");
        commodityService.save(commodity);

    }

    @Test
    public void testDelete() {
        Commodity commodity = new Commodity();
        commodity.setSkuId("1501009002");
        commodityService.delete(commodity);
    }

    @Test
    public void testGetAll() {
        Iterable<Commodity> iterable = commodityService.getAll();
        iterable.forEach(e->System.out.println(e.getName()));
    }

    @Test
    public void testGetByName() {
        List<Commodity> list = commodityService.getByName("面包");
        list.forEach(c -> System.out.println(c.getName()));
    }

    @Test
    public void testPage() {
        Page<Commodity> page = commodityService.pageQuery(0, 10, "切片");
        System.out.println(page.getTotalPages());
        System.out.println(page.getNumber());
        List<Commodity> list = page.getContent();
        list.forEach(c -> System.out.println(c.getName()));
    }
}