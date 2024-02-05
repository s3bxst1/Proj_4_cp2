

//filter uses <T> as a placeholder for other objects like strings and lists

interface Filter<T> {
    boolean accept(T t);
}
