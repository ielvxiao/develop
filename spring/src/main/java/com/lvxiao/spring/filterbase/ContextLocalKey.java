package com.lvxiao.spring.filterbase;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import static com.lvxiao.spring.filterbase.ContextLocal.getCurrentScope;

/**
 * @author hongqi
 * @date 2022/03/28
 */
public class ContextLocalKey<T> {
    private final T defaultValue;
    private final Supplier<T> initializer;
    private final boolean enableNullProtection;

    private ContextLocalKey(T defaultValue, Supplier<T> initializer) {
        this(defaultValue, initializer, false);
    }

    private ContextLocalKey(T defaultValue, Supplier<T> initializer, boolean enableNullProtection) {
        this.defaultValue = defaultValue;
        this.initializer = initializer;
        this.enableNullProtection = enableNullProtection;
    }

    @Nonnull
    public static <T> ContextLocalKey<T> allocate() {
        return withDefaultValue0(null);
    }

    @Nonnull
    private static <T> ContextLocalKey<T> withDefaultValue0(T defaultValue) {
        return new ContextLocalKey<>(defaultValue, null);
    }

    @Nonnull
    public static ContextLocalKey<Boolean> withDefaultValue(boolean defaultValue) {
        return withDefaultValue0(defaultValue);
    }

    @Nonnull
    public static ContextLocalKey<Integer> withDefaultValue(int defaultValue) {
        return withDefaultValue0(defaultValue);
    }

    @Nonnull
    public static ContextLocalKey<Long> withDefaultValue(long defaultValue) {
        return withDefaultValue0(defaultValue);
    }

    @Nonnull
    public static ContextLocalKey<Double> withDefaultValue(double defaultValue) {
        return withDefaultValue0(defaultValue);
    }

    @Nonnull
    public static ContextLocalKey<String> withDefaultValue(String defaultValue) {
        return withDefaultValue0(defaultValue);
    }

    @Nonnull
    public static <T extends Enum<T>> ContextLocalKey<T> withDefaultValue(T defaultValue) {
        return withDefaultValue0(defaultValue);
    }

    @Nonnull
    public static <T> ContextLocalKey<T> withInitializer(Supplier<T> initializer) {
        return withInitializer(false, initializer);
    }

    @Nonnull
    public static <T> ContextLocalKey<T> withInitializer(boolean enableNullProtection, Supplier<T> initializer) {
        return new ContextLocalKey<>(null, initializer, enableNullProtection);
    }

    public T get() {
        ContextLocal currentScope = getCurrentScope();
        if (currentScope == null) {
            return defaultValue();
        }
        return currentScope.get(this);
    }

    Supplier<T> initializer() {
        return initializer;
    }

    T defaultValue() {
        return defaultValue;
    }

    boolean enableNullProtection() {
        return enableNullProtection;
    }

    /**
     * @return {@code true} if in a scope and set success.
     */
    public boolean set(T value) {
        ContextLocal currentScope = getCurrentScope();
        if (currentScope != null) {
            currentScope.set(this, value);
            return true;
        } else {
            return false;
        }
    }

}
