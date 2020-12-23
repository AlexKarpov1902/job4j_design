package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> ch = findBy(child);
        if (ch.isPresent()) {
            return false;
        }
        Optional<Node<E>> par = findBy(parent);
        if (par.isEmpty()) {
            return false;
        }
        par.get().children.add(new Node<>(child));
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Predicate<Node<E>> isNodeEqual = (x) -> x.value.equals(value);
        Node<E> el = findNode(isNodeEqual);
        if (el == null) {
            return rsl;
        } else {
            return Optional.of(el);
        }
    }

    public boolean isBinary() {
        Predicate<Node<E>> isNotBiTree = (x) -> x.children.size() > 2;
        if (findNode(isNotBiTree) != null) {
            return false;
        }
        return true;
    }

    private Node<E> findNode(Predicate<Node<E>> predicate) {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                return el;
            }
            data.addAll(el.children);
        }
        return null;
    }
}