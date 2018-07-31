package com.apche.camel.choice;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;


public class RoutingTest 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	CamelContext camelContext = new DefaultCamelContext();
    	camelContext.addRoutes(new RouteBuilder(){
    
    	@Override
    	public void configure() throws Exception{
    	from("file:D:\\Apache_Camel_Test\\IN").
    	choice()
    	.when(xpath("/Order/Country='USA'")).to("file:D:\\Apache_Camel_Test\\A")
    	.when(xpath("/Order/Country='UK'")).to("file:D:\\Apache_Camel_Test\\B")
    	.otherwise().to("file:D:\\Apache_Camel_Test\\C")
    	.end();
    	}
    	});
    	
    	System.out.println("Starting Camel Context......");
    	camelContext.start();
    	      Thread.sleep(3000);
    	      camelContext.stop();
    	}
    	}
