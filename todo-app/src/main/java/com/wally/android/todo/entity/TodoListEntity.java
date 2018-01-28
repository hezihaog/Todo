package com.wally.android.todo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Package: com.wally.android.todo.entity
 * FileName: TodoListEntity
 * Date: on 2018/1/28  下午5:30
 * Auther: zihe
 * Descirbe:代办事项列表数据表
 * Email: hezihao@linghit.com
 */

@Entity(
        //设置表名
        nameInDb = "TODO_TODO_LIST",
        //是否需要greenDao创建表，默认为true
        createInDb = true,
        //是否生成所有参数构造器
        generateConstructors = true,
        //如果没有提供get、set方法，是否生成，默认为true
        generateGettersSetters = true
)
public class TodoListEntity extends BaseDaoEntity {
    //表中行id，表主键
    @Id(autoincrement = true)
    private Long rowId;

    //记录id
    @Property(nameInDb = "RECORD_ID")
    private String recordId;

    //记录所属用户id
    @Property(nameInDb = "USER_ID")
    private String userId;

    //代办事项类型
    @Property(nameInDb = "TODO_TYPE")
    private String todoType;

    //代办事项内容
    @Property(nameInDb = "TODO_CONTENT")
    private String todoContent;

    //记录保存时间
    @Property(nameInDb = "CREATE_DATE")
    private Long createDate;

    //是否逻辑删除
    @Property(nameInDb = "IS_LOGIC_DELETE")
    private int isLogicDelete;

    @Generated(hash = 2084352566)
    public TodoListEntity(Long rowId, String recordId, String userId,
                          String todoType, String todoContent, Long createDate,
                          int isLogicDelete) {
        this.rowId = rowId;
        this.recordId = recordId;
        this.userId = userId;
        this.todoType = todoType;
        this.todoContent = todoContent;
        this.createDate = createDate;
        this.isLogicDelete = isLogicDelete;
    }

    @Generated(hash = 1979991743)
    public TodoListEntity() {
    }

    public Long getRowId() {
        return this.rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTodoType() {
        return this.todoType;
    }

    public void setTodoType(String todoType) {
        this.todoType = todoType;
    }

    public String getTodoContent() {
        return this.todoContent;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
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