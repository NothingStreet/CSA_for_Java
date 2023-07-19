import com.ljd.domain.Account;
import com.ljd.service.AccountService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccountServiceTest {
    private AccountService accountService;

    @Before
    public void init() throws IOException{
        accountService=new AccountService();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts=accountService.findAll();
        System.out.println(accounts);
        accountService.destroy();
    }

    @Test
    public void testDeleteByPrimaryKey(){
        int count = accountService.deleteByPrimaryKey("2023003");
        System.out.println(count);
        accountService.destroy();
    }

    @Test
    public void testInsert() throws ParseException {
        Account account1=new Account();
        account1.setId("2023001");
        account1.setMoney(100);
        account1.setName("五一");
        account1.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-01"));
        account1.setUpdateTime(null);

        Account account2=new Account();
        account2.setId("2023002");
        account2.setMoney(200);
        account2.setName("刘二");
        account2.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-02"));
        account2.setUpdateTime(null);

        Account account3=new Account();
        account3.setId("2023003");
        account3.setMoney(300);
        account3.setName("张三");
        account3.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-03"));
        account3.setUpdateTime(null);

        accountService.Insert(account1);
        accountService.Insert(account2);
        accountService.Insert(account3);
        accountService.destroy();
    }

    @Test
    public void testSelectByPrimaryKey(){
        Account account = accountService.selectByPrimaryKey("2023002");
        System.out.println(account);
        accountService.destroy();
    }

    @Test
    public void testUpdatePrimaryKey() throws ParseException {
        Account account=new Account();
        account.setMoney(500);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date=new java.sql.Date(sdf.parse(sdf.format(new Date())).getTime());
        account.setUpdateTime(date);
        account.setId("2023002");

        int i = accountService.updatePrimaryKey(account);
        System.out.println(i);
        accountService.destroy();
    }

    @Test
    public void testTansFer() throws ParseException {
        accountService.TransFer("2023002","2023001",300);
        accountService.destroy();
    }

}
