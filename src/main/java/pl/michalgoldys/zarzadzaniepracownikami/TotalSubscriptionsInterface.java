package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.Collection;

public interface TotalSubscriptionsInterface<T>{
    Collection<Integer> totalSubscriptionsIncome(Collection<T> customer);
}
