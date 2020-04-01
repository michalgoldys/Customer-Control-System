package pl.michalgoldys.customercontrolsystem;

import java.util.Collection;

public interface TotalIncomeInterface<T> {
    Collection<Integer> totalIncome(Collection<T> customer);
}
