package br.com.owl.util;
import static java.util.Objects.requireNonNull;

public class Expirable <V>{
    private final V value;

    private volatile long expireTimeMS;

    public Expirable(V value, long expireTimeMS) {
        this.value = requireNonNull(value);
        this.expireTimeMS = expireTimeMS;
    }

    /** Returns the value. */
    public V get() {
        return value;
    }

    /** Returns the time, in milliseconds, when the value will expire. */
    public long getExpireTimeMS() {
        return expireTimeMS;
    }

    /** Specifies the time, in milliseconds, when the value will expire. */
    public void setExpireTimeMS(long expireTimeMS) {
        this.expireTimeMS = expireTimeMS;
    }

    /** Returns if the value has expired and is eligible for eviction. */
    public boolean hasExpired(long currentTimeMS) {
        return (currentTimeMS - expireTimeMS) >= 0;
    }

    /** Returns if the value will never expire. */
    public boolean isEternal() {
        return (expireTimeMS == Long.MAX_VALUE);
    }

    @Override
    public String toString() {
        return String.format("%s{value=%s, expireTimeMS=%,d}",
                getClass().getSimpleName(), value, expireTimeMS);
    }
}
