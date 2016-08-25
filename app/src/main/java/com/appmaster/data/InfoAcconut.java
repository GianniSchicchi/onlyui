package com.appmaster.data;

/**
 * Created by Gianni on 2016/8/24.
 */

public class InfoAcconut {

    public AccountType mAccountType;
    public String mAccount;

    public InfoAcconut() {
        mAccountType = AccountType.TYPE0;
        mAccount = "asdf23";
    }

    public InfoAcconut(AccountType accountType, String account) {
        mAccountType = accountType;
        mAccount = account;
    }

}
