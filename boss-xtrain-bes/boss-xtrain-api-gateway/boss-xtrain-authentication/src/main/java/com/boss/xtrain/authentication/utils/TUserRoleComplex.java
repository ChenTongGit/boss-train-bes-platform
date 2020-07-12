package com.boss.xtrain.authentication.utils;

import java.io.Serializable;

public class TUserRoleComplex implements Serializable {

    private Long id;
    private Long tRId;

    public TUserRoleComplex(){}
    public Long getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色ID
     *
     * @return t_r_id - 角色ID
     */
    public Long gettRId() {
        return tRId;
    }

    /**
     * 设置角色ID
     *
     * @param tRId 角色ID
     */
    public void settRId(Long tRId) {
        this.tRId = tRId;
    }
    @Override
    public int hashCode(){
        final int PRIME = 2;
        int result = 1;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        result = PRIME * result + ((tRId == null) ? 0 : tRId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final TUserRoleComplex other = (TUserRoleComplex) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (tRId == null) {
            if (other.tRId != null)
                return false;
        } else if (!tRId.equals(other.tRId))
            return false;
        return true;
    }
}