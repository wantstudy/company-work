package com.test.one;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TypeAnnotionTest {

	@Test
	public void testType(){
		Collections.emptyList().add("one");
		int i = Integer.parseInt("hello");
		System.console().reader();
	}
	
//	public @interface Authority {
//	     String role();
//	}
//	 
//	public @interface Authorities {
//	    Authority[] value();
//	}
//	 
//	public class RepeatAnnotationUseOldVersion {
//	     
//	    @Authorities({@Authority(role="Admin"),@Authority(role="Manager")})
//	    public void doSomeThing(){
//	    }
//	}
	
	
	@Repeatable(Authorities.class)
	public @interface Authority {
	     String role();
	}
	 
	public @interface Authorities {
	    Authority[] value();
	}
	 
	public class RepeatAnnotationUseNewVersion {
	    @Authority(role="Admin")
	    @Authority(role="Manager")
	    public void doSomeThing(){ }
	}

}
