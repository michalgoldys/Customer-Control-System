package pl.michalgoldys.customercontrolsystem;

import java.util.Collection;

public interface TotalSubscriptionsInterface<T>{
    Collection<Integer> totalSubscriptionsIncome(Collection<T> customer);
}
