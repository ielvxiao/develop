package com.lvxiao.multithread.lock.deadlock;

/**
 * @author lvxiao
 * @date 2019/6/1
 */
/*
 * 需求：简单的银行转账,它将资金从一个账户转到另一个账户
 * 在开始转账之前，需要获得两个Account的锁，以确保以原子的方式更新账户中的余额，且不能破坏不可变的条件，如账户的余额不能为负数
 *
 */

/*账户类*/
class Account{
    int id;
    private String accountName;//账号
    private int balance;//资金总额

    public Account(String accountName, int balance,int id) {
        this.id = id;
        this.accountName = accountName;
        this.balance = balance;
    }

    /**/
    public String getAccountName() {//获取账号
        return accountName;
    }
    public int getBalance() {//获取账号余额
        return balance;
    }

    public void debit(int amount){//更新转出方余额
        this.balance -= amount;
    }

    public void credbit(int amount){//更新转入方余额
        this.balance += amount;
    }
}


class TransferAccount implements Runnable{
    public Account fromAccount;//转出账户
    public Account toAccount;//转入账户
    public int amount;//转出金额
    public TransferAccount(Account fromAccount,Account toAccount,int amount){
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }
    @Override
    public void run(){
//        Account tmp;
//        if (fromAccount.id > toAccount.id) {
//            tmp = fromAccount;
//            fromAccount = toAccount;
//            toAccount = tmp;
//        }
        while(true){
            synchronized(fromAccount){
                synchronized(toAccount){
                    if(fromAccount.getBalance() <= 0){//转账进行的条件：判断转出账户的余额是否大于0
                        System.out.println(fromAccount.getAccountName() + "账户余额不足，无法进行转账");
                        return;
                    }else{
                        fromAccount.debit(amount);//更新转出账户的余额：-
                        toAccount.credbit(amount);//更新转入账户的余额：+
                    }
                }
            }
            System.out.println(fromAccount.getAccountName() + "......" + fromAccount.getBalance());//打印转出账户的余额
            System.out.println(toAccount.getAccountName() + "---" + toAccount.getBalance());//打印转入账户的余额
        }
    }
}

public class BankTransfer {
    public static void main(String[] args) {
        Account fromAccount = new Account("张三",100000,1);
        Account toAccount = new Account("李四",200000,2);

        Thread a = new Thread(new TransferAccount(fromAccount,toAccount,1));
        Thread b = new Thread(new TransferAccount(toAccount,fromAccount,2));

        a.start();
        b.start();
    }
}
