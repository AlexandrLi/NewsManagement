package com.epam.ali.testapp.model;


public class BaseEntity {
    private Integer id;

    public BaseEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;
        if (this.id == null || that.id == null) {
            throw new NullPointerException("Entity id is null");
        }
        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
