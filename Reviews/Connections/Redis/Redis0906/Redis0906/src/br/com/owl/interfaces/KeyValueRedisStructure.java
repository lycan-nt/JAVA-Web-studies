package br.com.owl.interfaces;

import java.util.List;

public interface KeyValueRedisStructure<T> {

    T get(String key);
    void set(String key, T bean);
    List<T> multiplesGet(Iterable<String> keys);
    void delete(String key);

}
