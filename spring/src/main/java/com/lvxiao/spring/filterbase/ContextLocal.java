package com.lvxiao.spring.filterbase;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author hongqi
 * @date 2022/03/28
 */
public class ContextLocal {

    private static final ThreadLocal<ContextLocal> SCOPE_THREAD_LOCAL = ThreadLocal.withInitial(ContextLocal::new);

    private final ConcurrentMap<ContextLocalKey<?>, Object> values = new ConcurrentHashMap<>();

    @Nonnull
    public static ContextLocal beginScope() {
        ContextLocal scope = SCOPE_THREAD_LOCAL.get();
        if (scope != null) {
            throw new IllegalStateException("start a scope in an exist scope.");
        }
        scope = new ContextLocal();
        SCOPE_THREAD_LOCAL.set(scope);
        return scope;
    }

    /**
     * @see #beginScope
     */
    public static void endScope() {
        SCOPE_THREAD_LOCAL.remove();
    }

    @Nullable
    public static ContextLocal getCurrentScope() {
        return SCOPE_THREAD_LOCAL.get();
    }

    public <T> void set(@Nonnull ContextLocalKey<T> key, T value) {
        if (value != null) {
            values.put(key, value);
        } else {
            values.remove(key);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(@Nonnull ContextLocalKey<T> key) {
        T value = (T) values.get(key);
        if (value == null && key.initializer() != null) {
            if (values.containsKey(key)) {
                return null;
            }
            value = key.initializer().get();
            if (value != null) {
                values.put(key, value);
            }
        }
        return value == null ? key.defaultValue() : value;
    }
}
