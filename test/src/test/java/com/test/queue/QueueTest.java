/*package com.test.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class QueueTest {
	//	1、定义一个队列缓存池
	private static List<Queue> queueCache = new LinkedList<Queue>();
	//	2、定义队列缓冲池最大消息数，如果达到该值，那么队列检入将等待检出低于该值时继续进行。
	private Integer offerMaxQueue = 2000 ;
	//	3、定义检出线程，如果队列缓冲池没有消息，那么检出线程会线程等待中
	new Thread(){
		public void run(){
			while(true){
				String ip = null;
				try {
					synchronized (queueCache) {
						Integer size = queueCache.size();
						if(size==0){
							//队列缓存池没有消息，等待。。。。									
							queueCache.wait();
						}
						Queue queue = queueCache.remove(0);

						if(isIpLock(queueStr)){
							 queueCache.add(queue);该queue重新加入队列缓冲池，滞后处理，
			                  continue;
							//假若这个是一个多应用的分布式系统，那么这个判断应该是分布式锁，这里说的锁不是线程停止，而是跳过该消息，滞后处理
						}else
							//这里是处理该消息的操作。
							
					}
					size = queueCache.size();
					if(size < offerMaxQueue && size>=0){									
						queueCache.notifyAll();//在队列缓存池不超过最大值的前提下，假若检入正在等待中，那么那么让他们排队检入。
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {//检出该消息队列的锁
					unIpLock(queueStr);
				} catch (Execption e) {//捕获异常，不能让线程挂掉
					e.printStackTrace();
				}	
			}
		}
	}.start();
}
*/