package com.szs.maven;
import org.junit.Test;
import static junit.framework.Assert.*;
		public class HelloTest {
			@Test
			public void testHello(){
				Hello hello = new Hello();
				String results = hello.sayHello("litingwei");
				//assertEquals: 断言是否相等,如果不一致会报错!
				assertEquals("Hello litingwei!",results);	
			}
		}