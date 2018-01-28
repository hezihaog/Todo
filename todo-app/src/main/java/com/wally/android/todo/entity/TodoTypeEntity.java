package com.wally.android.todo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Package: com.wally.android.todo.entity
 * FileName: TodoTypeEntity
 * Date: on 2018/1/28  下午5:53
 * Auther: zihe
 * Descirbe:代办事项类型表
 * Email: hezihao@linghit.com
 */

@Entity(
        //设置表名
        nameInDb = "TODO_TODO_TYPE",
        //是否需要greenDao创建表，默认为true
        createInDb = true,
        //是否生成所有参数构造器
        generateConstructors = true,
        //如果没有提供get、set方法，是否生成，默认为true
        generateGettersSetters = true
)
public class TodoTypeEntity extends BaseDaoEntity {
    //表中行id，表主键
    @Id(autoincrement = true)
    private Long rowId;

    //类型id
    @Property(nameInDb = "TYPE_ID")
    private String typeId;

    //类型的颜色值
    @Property(nameInDb = "TYPE_COLOR")
    private int typeColor;

    //类型解释
    @Property(nameInDb = "TYPE_DESC")
    private String typeDesc;

    //记录保存时间
    @Property(nameInDb = "CREATE_DATE")
    private Long createDate;

    //是否逻辑删除
    @Property(nameInDb = "IS_LOGIC_DELETE")
    private int isLogicDelete;

    @Generated(hash = 570017253)
    public TodoTypeEntity(Long rowId, String typeId, int typeColor, String typeDesc,
            Long createDate, int isLogicDelete) {
        this.rowId = rowId;
        this.typeId = typeId;
        this.typeColor = typeColor;
        this.typeDesc = typeDesc;
        this.createDate = createDate;
        this.isLogicDelete = isLogicDelete;
    }

    @Generated(hash = 995031354)
    public TodoTypeEntity() {
    }

    public Long getRowId() {
        return this.rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeDesc() {
        return this.typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
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

    public int getTypeColor() {
        return this.typeColor;
    }

    public void setTypeColor(int typeColor) {
        this.typeColor = typeColor;
    }
}
