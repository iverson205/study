---
title:关于线程类的currentThread和this
tags: Java,线程,getName
---
# 问题描述
````markdown
```java
public class MyThread extends Thread
{
	public MyThread()
	{
		System.out.println("Thread.currentThread().getname()="
				+ Thread.currentThread().getName());//main,执行构造函数的是主线程
		System.out.println("构造时this："+this);//Thread[Thread-0,5,main]，调用父类Thread类构造方法初始化的名字
		System.out.println("This.getName=" + this.getName());//Thread-0
	}
	
	public void run()
	{
		System.out.println("Thread.currentThread().getname()="
				+ Thread.currentThread().getName());//A 
		System.out.println("运行时this："+this);//Thread[Thread-0,5,main]
		System.out.println("This.getName=" + this.getName());//Thread-0
	}
	
	public static void main(String[] args)
	{
		MyThread thread = new MyThread();
		Thread t1 = new Thread(thread);//thread和t1是两个不同的对象
		System.out.println(thread+"?="+t1);
		t1.setName("A");
		System.out.println("t1.getName()="+t1.getName());//A
		t1.start();
	}

}
```
````

#  要点
* Thread.currentThread().getName() ：执行这行代码的线程
* this.getName()：当前对象的名字
* Thread[Thread-0,5,main]：线程类[该线程的名字，线程的优先级，所属的线程组 ]
* Thread t1 = new Thread(thread);//thread和t1是两个不同的对象