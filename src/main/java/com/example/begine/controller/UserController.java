package com.example.begine.controller;

import com.example.begine.model.db.User;
import com.example.begine.model.dto.RespDto;
import com.example.begine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 如果不用這個RestController 用 Controller 的話 他會去resources 那個資料夾撈對應的html檔案之類的
// 我們要寫API 會用 RestController
@RestController // 加這個才能傳String 或是 物件之類的 物件會自動轉成json 格式的文字
@RequestMapping("/user")  // 這個就是你的API 路徑
public class UserController {

    /**
     * 這個 @Autowired 是 spring-boot 的神奇註解
     * 他會自動幫你產一個對應的 instance 來使用
     * 反正加就對了
     * 阿這個註解 只有在 有加入 Spring-boot 的零件的東西才會作用
     * 好像有 @Controller @RestController @Repository @Service @Component
     * 之類的可以用 剩下自己要用到在查
     */
    @Autowired
    private UserService userService;

    /**
     * 這兩個可以抓到傳進來的請求跟回應
     * 通常要取一些奇奇怪怪的東西可以用這個取
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;

    // 對應到 ｈｔｔｐ的 Get Method
    @GetMapping("")
    public RespDto findAll() {
        httpServletRequest.getParameter("authorization"); // 這個是取 http query string
        httpServletRequest.getHeader("Authorization"); // 這是取 header 看你要怎麼用
        return new RespDto()
                .setData(this.userService.findAll())
                .setResult("success");
    }

    @GetMapping("/{id}") // 在路徑上的參數 ex: GET /user/1  -> 就是抓那個 1
    public RespDto findById(@PathVariable Long id) {
        return new RespDto()
                .setData(this.userService.findById(id))
                .setResult("success");
    }

    // 對應到 http的 Post Method
    @PostMapping("")
    public RespDto save(@RequestBody User user) {
        return new RespDto()
                .setData(this.userService.save(user))
                .setResult("success");
    }




}
