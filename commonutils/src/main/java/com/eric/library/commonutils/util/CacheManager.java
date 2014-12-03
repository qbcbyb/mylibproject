package com.eric.library.commonutils.util;

import android.app.Activity;
import android.content.Context;
import com.eric.library.commonutils.service.HttpCache;
import com.eric.library.commonutils.service.impl.ImageCache;
import com.eric.library.commonutils.service.impl.ImageSDCardCache;

/**
 * CacheManager
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2014-2-11
 */
public class CacheManager {

    private static HttpCache httpCache = null;

    private CacheManager() {
        throw new AssertionError();
    }

    /**
     * get the singleton instance of HttpCache
     * 
     * @param context {@link android.app.Activity#getApplicationContext()}
     * @return
     */
    public static HttpCache getHttpCache(Context context) {
        if (httpCache == null) {
            synchronized (CacheManager.class) {
                if (httpCache == null) {
                    httpCache = new HttpCache(context);
                }
            }
        }
        return httpCache;
    }

    /**
     * get the singleton instance of ImageCache
     * 
     * @return
     * @see ImageCacheManager#getImageCache()
     */
    public static ImageCache getImageCache() {
        return ImageCacheManager.getImageCache();
    }

    /**
     * get the singleton instance of ImageSDCardCache
     * 
     * @return
     * @see ImageCacheManager#getImageSDCardCache()
     */
    public static ImageSDCardCache getImageSDCardCache() {
        return ImageCacheManager.getImageSDCardCache();
    }
}
