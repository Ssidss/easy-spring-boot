package com.example.begine.repository;

import com.example.begine.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 這個是 JPA 用的 Repository 的規範
 * extends JpaRepository<User, Long> User 是這個repository 管的物件 Long 是他的ID 也就是 primary key
 * primary key如果要多個組合起來的話 有別種用法 自己去查 但滿麻煩的 所以我都會自己寫客製化的 repositroy
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {

    // Jpa規範的寫法 可以自己上網查 要用List的原因是find by name -> name 不是unique 的 所以要list
    // 如果是unique 的欄位 可以不用List<User> 就一個User 就行
    List<User> findByName(String name);

}
