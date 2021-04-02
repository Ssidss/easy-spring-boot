package com.example.begine.model.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

// 這邊反正我習慣 db 裡面是用底線命名的
// 小寫 + _ 切單字 比如說 userInfo -> user_info
// Java 裡面也只有物件會用大寫開頭
@Table(name = "user", indexes = {
        @Index(name = "name_idx", columnList = "name") // 創建db的index 簡單來說就是可以增快搜尋這個欄位的速度 自己要再詳細查怎麼用
}) // 給ＤＢ看的table 設定
@Entity(name = "user")  // 給 JAVA程式看的名字
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 加這行 就可以用流水號當ＩＤ
    private Long id;

    @Column(length = 64, nullable = false) // 這@Column 是給DB看的設定
    private String name;

    @CreationTimestamp // 加這個 會讓你的程式更新的時候自動新增現在時間
    @Column(name = "update_at")
    @JsonProperty(value = "update_at")  // 這是給 controller 在收發資料的時候 收的欄位名稱 看controller 的地方解釋
    private Date updateAt;

    @UpdateTimestamp // 新增的時候會加上去 不過更新的時候這個就沒效了 要自己再設定一次時間 後面範例會有看到
    @Column(name = "create_at")
    @JsonProperty(value = "create_at")
    private Date createAt;

    private String updater;


    /**
     * 一般來說 在寫物件導向的時候 會把成員隱藏起來 只用這個 getter && setter 來操作
     *
     */
    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public User setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public User setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getUpdater() {
        return updater;
    }

    public User setUpdater(String updater) {
        this.updater = updater;
        return this;
    }
}
