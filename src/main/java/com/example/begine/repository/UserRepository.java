package com.example.begine.repository;

import com.example.begine.model.db.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository // 要告訴spring-boot 這是一個repository
@Transactional // 要做刪除修改要加這個 我也忘了為啥
public class UserRepository {

    // 我拿來客製化常用的 entityManager 反正就是管理資料用的啦
    @Autowired
    private EntityManager entityManager;

    public User save(User user, boolean isCreate) {
        /**
         * 這邊其實不一定要用 isCreate
         * 如果你ID 判別的方法簡單的話 可以用別種
         */
        if (isCreate) {
            /**
             * 一般來說我們甕流水號的話 不會設定ID 所以進來的時候 getId() 應該會拿到 null
             * 用這個persist 就會把資料存進DB 並產一個流水號
             * 這個流水號會自動設定給 user 這個物件 所以 return 回去會帶有流水號
             */
            entityManager.persist(user);
        } else {
            /**
             * 用merge 的時候是 你要update 資料的時候
             * 這種時候 你的 user getId() 是會撈到東西的
             * 這樣才會是update
             */
            entityManager.merge(user);
        }

        // 刷新 沒別的意思
        entityManager.flush();
        return user;
    }

    public List<User> findAll(){
        // createNativeQuery 第一個是 query string, 第二個是 轉成什麼物件 要DB撈出來的名字 跟型態設定得跟你那個物件一樣
        // 名字的話 會看@Column(name = "") 那個name設定的名字
        return this.entityManager.createNativeQuery("SELECT * FROM user;", User.class)
                .getResultList();
    }

    public List<Map<String, Object>> findSomeShit() {
        // 沒指定的話撈出來可以是Map<String, Object> 的格式 有些人是會在寫一些Dto 去撈啦 我懶 這樣用比較快
        // 就是你格式不一定跟你Table 一樣的時候 通常是在Join 一堆奇怪的Table 會這麼做
        return this.entityManager.createNativeQuery("SELECT * FROM user")
                .getResultList();
    }


}
