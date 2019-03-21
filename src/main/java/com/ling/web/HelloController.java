package com.ling.web;

import com.ling.entity.OrderAddressRequest;
import com.ling.entity.OrderStatusRequest;
import com.ling.util.JsonUtils;
import org.apache.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lian on 03/06/2019.
 */
@RestController
public class HelloController {
    @GetMapping("/index.cfm/POTStatus")
    public String checkOrder(@RequestParam(name = "enigma_order_id") Long enigmaOrderId){
        System.out.println("enigmaOrderId = [" + enigmaOrderId + "]");
        return "{" +
                "\"summary\": {" +
                "  \"status\": \"SUCCESS\"," +
                "  \"enigma_order_id\": \""+enigmaOrderId+"\"," +
                "  \"existed\" : \" false\"" +
                " }" +
                "}";
    }

    @PostMapping("/index.cfm/POTUpdate")
    public String updateOrderItemStatus(HttpServletRequest req, @RequestParam(name = "UpdateType") String updateType,
                                        @RequestBody(required = false) OrderAddressRequest request
                                       // @RequestBody(required = false) OrderStatusRequest osr
                                        ){
        System.out.println("updateType = [" + updateType + "]");
        System.out.println("updateType = [" + req.getHeader("token") + "]");
        System.out.println("updateType = [" + req.getHeader(HttpHeaders.CONTENT_TYPE) + "]");

       System.out.println(JsonUtils.toJsonString(request));
     //   System.out.println(JsonUtils.toJsonString(osr));
        System.out.println("test git");
        return "{" +
                "\"summary\": {" +
                "  \"status\": \"FAILED\"," +
                "  \"message\": \"slskjsdlfksj dksj fo\"," +
                //"  \"date\": \"March, 12 2019 03:27:48\"" +
                "  \"date\": \"2019-03-12 03:27:48\"" +
                " }" +
                "} ";
    }

}
