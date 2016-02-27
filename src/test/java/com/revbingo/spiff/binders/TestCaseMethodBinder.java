/*
 * Copyright Mark Piper 2016
 *
 * This file is part of SPIFF.
 *
 * SPIFF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SPIFF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SPIFF.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.revbingo.spiff.binders;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;

import org.junit.Test;

import com.revbingo.spiff.ExecutionException;

public class TestCaseMethodBinder {

	@Test
	public void binderCallsMethod() throws Exception {
		MethodBinder unit = new MethodBinder(MethodBindingTestClass.class.getDeclaredMethod("theMethod", int.class));
		
		MethodBindingTestClass target = new MethodBindingTestClass();
		
		int theInt = 10;
		
		unit.bind(target, theInt);
		
		assertThat(target.privateReally, is(theInt + 1));
	}
	
	@Test(expected=ExecutionException.class)
	public void throwsExecutionExceptionIfCalledWithWrongType() throws Exception {
		MethodBinder unit = new MethodBinder(MethodBindingTestClass.class.getDeclaredMethod("theMethod", int.class));
		
		MethodBindingTestClass target = new MethodBindingTestClass();
		
		unit.bind(target, 10f);
	}
	
	@Test(expected=ExecutionException.class)
	public void doesntCauseNullPointerIfNullPassed() throws Exception {
		MethodBinder unit = new MethodBinder(MethodBindingTestClass.class.getDeclaredMethod("theMethod", int.class));
		
		MethodBindingTestClass target = new MethodBindingTestClass();
		
		unit.bind(target, null);
	}
	
	@Test(expected=ExecutionException.class)
	public void throwsExecutionExceptionIfMethodThrowsAnException() throws Exception {
		MethodBinder unit = new MethodBinder(MethodBindingTestClass.class.getDeclaredMethod("anExceptionMethod", int.class));
		
		MethodBindingTestClass target = new MethodBindingTestClass();
		
		unit.bind(target, 10);
	}
	
	@Test(expected=ExecutionException.class)
	public void createAndBindCannotBeCalled() throws Exception {
		new MethodBinder(MethodBindingTestClass.class.getDeclaredMethod("theMethod", int.class)).createAndBind(null);
	}
	
	@Test
	public void privateMethodsCanBeAccessed() throws Exception {
		MethodBinder unit = new MethodBinder(MethodBindingTestClass.class.getDeclaredMethod("aPrivateMethod", int.class));
		
		MethodBindingTestClass target = new MethodBindingTestClass();
		
		int x = 10;
		
		unit.bind(target, x);
		
		assertThat(target.privateReally, is(x));
	}
	
	@Test(expected=ExecutionException.class)
	public void exceptionThrownIfMethodIsMadeInaccessible() throws Exception {
		Method privateMethod = MethodBindingTestClass.class.getDeclaredMethod("aPrivateMethod", int.class);
		MethodBinder unit = new MethodBinder(privateMethod);
		
		MethodBindingTestClass target = new MethodBindingTestClass();
		
		privateMethod.setAccessible(false);
		unit.bind(target, 10);
	}
	
	public static class MethodBindingTestClass {
		
		public int privateReally;
		
		public void theMethod(int theInt) {
			privateReally = theInt + 1;
		}
		
		public void anExceptionMethod(int theInt) {
			throw new RuntimeException("oops");
		}
		
		private void aPrivateMethod(int theInt) {
			privateReally = theInt;
		}
	}
}
