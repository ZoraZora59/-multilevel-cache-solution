package cn.gk.multilevel.cache.sdk.model;

import com.github.benmanes.caffeine.cache.Weigher;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * <h3>multilevel-cache-solution</h3>
 * <h4>cn.gk.multilevel.cache.sdk.model</h4>
 * <p>缓存配置类</p>
 *
 * @author zora
 * @since 2020.07.17
 */
@Builder
public class CacheConfiguration implements Serializable {

    private static final long DEFAULT_MAXIMUM_MEMORY_USAGE_SIZE = 128 * 1024 * 1024;
    private static final long DEFAULT_MAXIMUM_CACHE_SIZE = 256;
    private static final Weigher<String, String> DEFAULT_WEIGHER = (key, value) -> key.length() + value.length();

    public Weigher<String, String> getWeigher() {
        return weigher == null ? DEFAULT_WEIGHER : weigher;
    }

    public long getMemoryUsageSize() {
        return memoryUsageSize > 0 ? memoryUsageSize : DEFAULT_MAXIMUM_MEMORY_USAGE_SIZE;
    }

    public long getLocalCacheCountSize() {
        return localCacheCountSize > 0 ? localCacheCountSize : DEFAULT_MAXIMUM_CACHE_SIZE;
    }

    /**
     * 权重配置
     */
    private final Weigher<String, String> weigher;
    /**
     * 基于权重的最大用量
     */
    private final long memoryUsageSize;
    /**
     * 本地缓存最大个数配置
     */
    private final long localCacheCountSize;

    /**
     * value软引用
     */
    @Getter
    private final boolean softValues;
}
