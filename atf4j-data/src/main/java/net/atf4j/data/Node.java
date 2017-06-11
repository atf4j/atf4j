package net.atf4j.data;

public abstract class Node<L, R> {
    private L left;
    private R right;

    protected L left() {
        return left;
    }

    protected R right() {
        return right;
    }

}
