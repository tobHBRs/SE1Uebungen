package org.hbrs.se1.ws24.exercises.uebung4.meineLösung;
import java.util.List;

/**
 * Interface for defining basic methods for a persistence mechanism
 * Each concrete algorithm (i.e. strategy) must implement this method
 * This interface corresponds to the abstract strategy w.r.t. to the
 * Strategy Design Pattern (GoF).
 *
 */
public interface PersistenceStrategy<E> {
    public void save(List<E> member) throws PersistenceException;
    public List<E> load() throws PersistenceException;
}
