package com.ljd.dao;

import com.ljd.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    int deleteByPrimaryKey(String id);

    void insert(Account account);

    Account selectByPrimaryKey(String id);

    int updateByPrimaryKey(Account account);

}
