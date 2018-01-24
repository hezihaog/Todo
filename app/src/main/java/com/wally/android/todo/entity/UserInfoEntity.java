package com.wally.android.todo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Package: com.wally.android.todo.entity
 * FileName: UserInfoEntity
 * Date: on 2018/1/24  下午12:03
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

@Entity(
        //设置表名
        nameInDb = "TODO_USER_INFO",
        //是否需要greenDao创建表，默认为true
        createInDb = true,
        //是否生成所有参数构造器
        generateConstructors = true,
        //如果没有提供get、set方法，是否生成，默认为true
        generateGettersSetters = true
)
public class UserInfoEntity extends BaseDaoEntity {
    //表中行id，表主键
    @Id(autoincrement = true)
    private Long rowId;

    /**
     * 账号名
     */
    @Property(nameInDb = "ACCOUNT_NAME")
    String accountName;

    /**
     * 昵称
     */
    @Property(nameInDb = "NICK_NAME")
    String nickName;

    /**
     * 密码
     */
    @Property(nameInDb = "MD5_PWD")
    String md5Pwd;

    /**
     * 记录保存时间
     */
    @Property(nameInDb = "CREATE_DATE")
    private Long createDate;

    /**
     * 用于逻辑删除，如果后续有删除记录的操作，删除记录是不会删除表汇总的记录的，只改变该标志位，要加上该属性进行判断来过滤
     * 1为未删除，-100为逻辑删除了
     * 类型见{@link com.wally.android.todo.constant.Constants.LogicDelete}
     */
    @Property(nameInDb = "IS_LOGIC_DELETE")
    private int isLogicDelete;

@Generated(hash = 1425601209)
public UserInfoEntity(Long rowId, String accountName, String nickName,
        String md5Pwd, Long createDate, int isLogicDelete) {
    this.rowId = rowId;
    this.accountName = accountName;
    this.nickName = nickName;
    this.md5Pwd = md5Pwd;
    this.createDate = createDate;
    this.isLogicDelete = isLogicDelete;
}

@Generated(hash = 2042969639)
public UserInfoEntity() {
}

public Long getRowId() {
    return this.rowId;
}

public void setRowId(Long rowId) {
    this.rowId = rowId;
}

public String getAccountName() {
    return this.accountName;
}

public void setAccountName(String accountName) {
    this.accountName = accountName;
}

public String getNickName() {
    return this.nickName;
}

public void setNickName(String nickName) {
    this.nickName = nickName;
}

public String getMd5Pwd() {
    return this.md5Pwd;
}

public void setMd5Pwd(String md5Pwd) {
    this.md5Pwd = md5Pwd;
}

public Long getCreateDate() {
    return this.createDate;
}

public void setCreateDate(Long createDate) {
    this.createDate = createDate;
}

public int getIsLogicDelete() {
    return this.isLogicDelete;
}

public void setIsLogicDelete(int isLogicDelete) {
    this.isLogicDelete = isLogicDelete;
}
}