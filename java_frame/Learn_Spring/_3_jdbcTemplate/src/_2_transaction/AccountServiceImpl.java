package _2_transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "accountService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountDao accountDao;

    @Override
    public void transfer(String from, String to, int amount) {
        accountDao.incBalance(to, amount);
        int tmp = 10/0; // 模拟异常
        accountDao.decBalance(from, amount);
    }
}

/*  Transactional 参数:
        propagation: 事务传播行为 (7种, 见img_propaation
        多个 事务方法间 调用, 这个过程中，是如何管理事务
        默认 Required

        isolation: 事务隔离级别 (见db笔记
        mysql 默认 repeatable

        timeout: 超时时间,  (秒为单位
        事务要在一定时间内commit,否则rollback
        默认-1 (不超时

        readOnly: 是否只读(查询)
        默认false

        rollbackFor: 出现哪些异常, 进行回滚

        noRollbackFor: 出现哪些异常, 不回滚
 */