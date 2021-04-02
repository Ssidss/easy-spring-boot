package com.example.begine.service;

import com.example.begine.model.db.User;
import com.example.begine.repository.UserJpaRepository;
import com.example.begine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service 掌管一切邏輯的地方
 * 這邊會去使用Repository
 *
 * 這邊看起來很蠢 會一個Method 就return 的
 * 在複雜的情況下 應該不會只有這樣一行
 * 這邊是簡單的情況下
 *
 * 基本上要切 controller service repository 就是要把邏輯切開
 * Controller 只負責收資料 然後把收到的資料可能轉成給Service 要的格式 就丟進來給Service做
 * Service 處理任何邏輯面的東西
 * Repository 就是 一切對DB的操作都是Repository
 * 可的情況下 盡量同名的 Controller - Service - Repository 用再一起 不要用到別的名字的
 * ex: UserController -> UserService -> UserRepository
 *     RoleController -> RoleService -> RoleRepository
 *     不過在一些需求裡面 還是難免
 *     但記得就是 不用左右用
 *     UserService 永遠都只會用到Repository 且是 Controller 來call 他
 *     不會有什麼 RoleService 去用它
 *     Controller Repository 同理
 *
 */
@Service
public class UserService {

    // 一般來說 簡單的Restful Api 用 Jpa的就夠了
    @Autowired
    private UserJpaRepository userJpaRepository;

    // 某些情況下要客製化 query 才會用到這個
    @Autowired
    private UserRepository userRepository;


    public User save(User user) {
        return userJpaRepository.save(user);
    }

    public List<User> findAll() {
        return userJpaRepository.findAll();
    }

    public User findById(Long id) {
        return userJpaRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        this.userJpaRepository.deleteById(id);
    }

}
