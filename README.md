* Spring-boot easy tutorial


* pom.xml 
安裝第三方Library 用的一個東西
設定方式就是xml
通常要用什麼套件就直接google xxx maven 然後拿到網址去pom.xml 
的dependency 貼上


* mvnw 

管理第三方套件跟打包之類的東西
終端機執行的話可以用 
./mvnw spring-boot:run 來執行
打包的話
./mvnw clean install package 可以根據pom.xml 裡面的設定打包成jar or war 檔案


* git

git init 開始一個git 管理 這個會建立一個.git 的影藏資料夾
git add <file name> 把某個檔案加入git管理 通常可以直接在根目錄 
git add . 把全部的檔案加進來

git commit -m '<message>' commit 這次 add 的檔案 並加上message
那個 -m '<message>' 一定要打 <message> 就打你要輸入的訊息通常會記錄這次改動的內容

這時候檔案就已經放進去 git管理了
git push -u <remote> <branch> 把指定的分支推倒指定的remote repository
remote repository 就是github gitlab 之類的東西


