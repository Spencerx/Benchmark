/**
* OWASP Benchmark Project v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13361")
public class BenchmarkTest13361 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		try {
			int randNumber = java.security.SecureRandom.getInstance("SHA1PRNG").nextInt(99);
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextInt(int) - TestCase");
			throw new ServletException(e);
	    }		
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextInt(int) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6680 = param; //assign
		StringBuilder b6680 = new StringBuilder(a6680);  // stick in stringbuilder
		b6680.append(" SafeStuff"); // append some safe content
		b6680.replace(b6680.length()-"Chars".length(),b6680.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6680 = new java.util.HashMap<String,Object>();
		map6680.put("key6680", b6680.toString()); // put in a collection
		String c6680 = (String)map6680.get("key6680"); // get it back out
		String d6680 = c6680.substring(0,c6680.length()-1); // extract most of it
		String e6680 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6680.getBytes() ) )); // B64 encode and decode it
		String f6680 = e6680.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g6680 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g6680); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
