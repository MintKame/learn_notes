package _3_transaction_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "accountService2")
public class AccountServiceImpl2 implements AccountService2 {
    @Autowired
    AccountDao2 accountDao;

    @Override
    public void transfer(String from, String to, int amount) {
        accountDao.incBalance(to, amount);
        int tmp = 10/0; // 模拟异常
        accountDao.decBalance(from, amount);
    }
}
