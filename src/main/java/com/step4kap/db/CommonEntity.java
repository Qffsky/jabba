package com.step4kap.db;

/**
 * Interface for all objects that conect with database
 */
public interface CommonEntity<ID> {
    ID getId();
    void setId(ID id);
}
