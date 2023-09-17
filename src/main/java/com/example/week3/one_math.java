package com.example.week3;


import org.springframework.web.bind.annotation.*;

//step1 - address controler
@RestController

public class one_math {

    //--add--
    //step3
    @RequestMapping (value = "/add/{num1}/{num2}" , method = RequestMethod.GET)
    //step2 - สร้าง method ที่ต้องการ
    public String add(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return num1 + num2 +"";
    }
    //ทำ 2-3 วันไปเรื่อยๆ

    //--minus--
    @RequestMapping(value = "/minus/{num1}/{num2}" ,method =  RequestMethod.GET)
    public String minus(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return  num1 - num2 + "";
    }

    //--multiply--
    @RequestMapping(value = "/multiply" ,method =  RequestMethod.GET)
    public String multiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2){
        return num1 * num2 + "" ;
    }

    //--divide--
    @RequestMapping(value = "/divide", method = RequestMethod.GET )
    public String divide(@RequestParam("num1") double num1 , @RequestParam("num2") double num2){
        return num1 / num2 + "";
    }


}
