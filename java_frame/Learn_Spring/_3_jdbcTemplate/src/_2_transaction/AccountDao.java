package _2_transaction;

import java.util.List;

public interface AccountDao {
    public void incBalance(String name, int amount);

    public void decBalance(String name, int amount);
}
