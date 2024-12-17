package help;

public interface Payable {
    int getBalance();
    void setBalance(int balance);

    default void spendMoney(int amount) throws PossibleException {
        if (getBalance() < amount) {
            throw new PossibleException("Недостаточно денег!");
        }
        setBalance(getBalance() - amount);
    }
}