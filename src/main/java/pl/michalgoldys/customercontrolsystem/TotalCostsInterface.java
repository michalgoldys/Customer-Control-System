package pl.michalgoldys.customercontrolsystem;

import java.util.Collection;

public interface TotalCostsInterface<T> {
    Collection<Double> totalCosts(Collection<T> customer);
}
