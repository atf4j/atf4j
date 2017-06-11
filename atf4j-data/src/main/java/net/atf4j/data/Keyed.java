package net.atf4j.data;

public interface Keyed<K, V> {
    public K key();

    public V value();
}
