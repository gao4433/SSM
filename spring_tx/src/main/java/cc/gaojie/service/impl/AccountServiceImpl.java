package cc.gaojie.service.impl;

import cc.gaojie.dao.AccountDao;
import cc.gaojie.service.AccountService;

/**
 * @author 高杰
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i = 1 / 0;
        accountDao.in(inMan,money);
    }
}

