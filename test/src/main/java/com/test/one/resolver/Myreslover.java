package com.test.one.resolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import com.test.one.service.PersonService;

public class Myreslover implements CacheResolver {
	
	@Autowired  
    private CacheManager cacheManager;  

	public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
		List<Cache> caches = new ArrayList<Cache>();  
        for(String cacheName : context.getOperation().getCacheNames()) {  
            caches.add(cacheManager.getCache(cacheName));  
            System.out.println(cacheName);
        }  
        if(context.getTarget() instanceof PersonService) {  
            caches.add(cacheManager.getCache("Person"));  
            System.out.println(cacheManager.getCache("Person").toString());
        }  
        return caches;  
	}

}
