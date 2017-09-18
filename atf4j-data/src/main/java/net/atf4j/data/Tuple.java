package net.atf4j.data;

public class Tuple<K, V> implements Keyed<K, V> {
    private K key;
    private V value;

    public Keyed<K, V> setKey(final K key) {
        this.key = key;
        return this;
    }

    public Keyed<K, V> setValue(final V value) {
        this.value = value;
        return this;
    }

    @Override
    public K key() {
        return this.key;
    }

    @Override
    public V value() {
        return this.value;
    }

}
