package _3_transaction_xml;

public interface AccountDao2 {
    public void incBalance(String name, int amount);

    public void decBalance(String name, int amount);
}
