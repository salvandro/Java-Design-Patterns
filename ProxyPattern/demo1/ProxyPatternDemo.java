package demo1;

import demo1.proxy.Proxy;

public class ProxyPatternDemo
{
	public static void main(String args[])
	{
		Proxy proxy = new Proxy();
		
		System.out.println("***Proxy Pattern Demo 1***\n");
		
		proxy.doSomeWork();
	}
}
