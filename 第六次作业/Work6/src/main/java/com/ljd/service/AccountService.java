package com.ljd.service;

import com.ljd.dao.AccountDao;
import com.ljd.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccountService {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    public AccountService() throws IOException{
            inputStream= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession=sqlSessionFactory.openSession();
            accountDao=sqlSession.getMapper(AccountDao.class);
    }
    public void destroy(){
        try{
            sqlSession.commit();
            sqlSession.close();
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Account> findAll(){
        return accountDao.findAll();
    }

    public int deleteByPrimaryKey(String id){
        return accountDao.deleteByPrimaryKey(id);
    }

    public void Insert(Account account){
        accountDao.insert(account);
    }

    public Account selectByPrimaryKey(String id){
        return accountDao.selectByPrimaryKey(id);
    }

    public int updatePrimaryKey(Account account){
        return accountDao.updateByPrimaryKey(account);
    }

    public void TransFer(String remitterId,String remitteeId,int money) throws ParseException {
        Account Remitter = this.selectByPrimaryKey(remitterId);
        Account Remittee = this.selectByPrimaryKey(remitteeId);

        if(Remitter.getMoney()-money<0){
            System.out.println("余额不足,转账失败");
        }
        else{
            Remittee.setMoney(Remittee.getMoney()+money);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Remittee.setUpdateTime(sdf.parse(sdf.format(new Date())));

            Remitter.setMoney(Remitter.getMoney()-money);
            Remitter.setUpdateTime(sdf.parse(sdf.format(new Date())));

            int count=this.updatePrimaryKey(Remitter)+this.updatePrimaryKey(Remittee);
            if(count!=2){
                System.out.println("更新失败");
            }else System.out.println("已修改数据:"+count+"条");
        }

    }

}
