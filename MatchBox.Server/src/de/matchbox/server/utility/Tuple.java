package de.matchbox.server.utility;

public class Tuple<T1, T2> {

    private final T1 object1;
    private final T2 object2;

    public Tuple(T1 pObject1, T2 pObject2) {
        this.object1 = pObject1;
        this.object2 = pObject2;
    }

    public T1 getObject1() {
        return object1;
    }

    public T2 getObject2() {
        return object2;
    }
}
