/*package com.test.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.sun.mail.imap.Utility;
public class ThreadPoolManager
{
    private static Logger log = Logger.getLogger(ThreadPoolManager.class);
    private static ThreadPoolManager instance = new ThreadPoolManager();
    public static ThreadPoolManager getInstance() 
    {
        return instance;
    }
    
    private static ThreadPoolExecutor taskPool = null; // Thread pool used to hold running threads
    private static BlockingQueue taskQueue = null; // Blocking queue used to hold waiting threads
    private static int corePoolSize;
    private static int maxPoolSize;
    private static int queueSize;
    private static long waitTime;
    private ThreadPoolManager() 
    {
    }
    static 
    {
        corePoolSize = Utility.THREAD_POOL_CORE_SIZE; // Config in properties, e.g. THREAD_POOL_CORE_SIZE=2
        queueSize = Utility.THREAD_POOL_QUEUE_SIZE; // Config in properties, e.g. THREAD_POOL_QUEUE_SIZE=2
        maxPoolSize = Utility.THREAD_POOL_MAX_SIZE; // Config in properties, e.g. THREAD_POOL_MAX_SIZE=4
        waitTime = Utility.THREAD_KEEP_ALIVE_TIME; // Config in properties, e.g. THREAD_KEEP_ALIVE_TIME=60
        
        taskQueue = new ArrayBlockingQueue(queueSize);
        
        taskPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize, waitTime,
                TimeUnit.SECONDS, taskQueue, new ThreadPoolExecutor.CallerRunsPolicy());
        log.info("Initialize thread pool succeed. ThreadPool: corePoolSize = "
                + corePoolSize + ", queueSize = " + queueSize
                + ", maxPoolSize = " + maxPoolSize);
　　     }

    public void execute() 
    {
        log.info("ThreadPoolManager.execute() - start");
        List lst = fetch();
        if (lst != null && lst.size() > 0)
        {
            log.info("ThreadPoolManager.execute() - List size is " + lst.size());
            int availTaskCount = 0;
            Long id = null;
            int index = 0;
            while (index < lst.size()) 
            {
                // If the amount of active threads and waiting threads does not reach the max thread limit,
                // create enough threads to either meet the max thread limit or meet the number of appIds to be deal with.
                availTaskCount = maxPoolSize - taskPool.getActiveCount() - taskQueue.size();
                log.debug("ThreadPool status - [active: " + taskPool.getActiveCount() + ", queue: " + taskQueue.size() + ", available: " + availTaskCount + "]");
                if (availTaskCount > 0) 
                {
                    for (int i = index; i < index + availTaskCount && i < lst.size(); i++) 
                    {
                        id = (Long)lst.get(i);
                        log.debug("ThreadPoolManager.execute()::Id: " + id);
                        taskPool.execute(Runnable command); // Some task extends Thread or implements Runnable interface 
                    }
                    index = index + availTaskCount;
                }
                else 
                {
                    log.debug("Sleep 500 ms while no enough threads available in thread pool");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        log.info("ThreadPoolManager.execute() - end");
    }
    
    private List fetch()
    {
        // dummy service method to fetch sth
        List lst = new ArrayList();
        return lst;
    }
}*/