package net.atf4j.data;

import java.util.Collection;

/**
 * IFactory.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public interface IFactory
{
    /**
     * Factory method to create single instance of object.
     * @return Object.
     */
    public Object create();

    /**
     * Factory method to create a collection.
     * @param number of instances as int.
     * @return Collection of instances.
     */
    public Collection<Object> create(int number);
}
