package com.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecuteCMD
{

	public static void main(String[] args)
	{
		Runtime runtime = Runtime.getRuntime();
		try
		{
			//Process process =  runtime.exec("cmd /c start C:\\Program Files\\Java\\jdk1.8.0_211\\bin &&  ");
			//runtime.exec("cmd /c   \"C:\\Program Files\\Java\\jdk1.8.0_211\\bin &&  jarsigner -storetype pkcs12 -keystore D:\\jar file\\JARS signing\\mddxiqc.pfx -tsa http://timestamp.comodoca.com/rfc3161 -digestalg SHA-1 D:\\JavaWebStartDemo.jar {97c93439-21c1-4b7a-a7a1-234f3a4d6260} \" ");
			
			String [] command = {"cmd" , "/c" , "jarsigner -storetype pkcs12 -keystore \"D:\\JarFile\\JARSigning\\mddxiqc.pfx\" -tsa http://timestamp.comodoca.com/rfc3161 -digestalg SHA-1 \"D:\\aws-java-sdk-1.11.3.jar\" {97c93439-21c1-4b7a-a7a1-234f3a4d6260}" };
			
			Process process =  runtime.exec("cmd /c start  jarsigner   -storetype pkcs12 -keystore \"D:\\JarFiles\\JARSigning\\mddxiqc.pfx\" -storepass \"3diadmin\" -tsa http://timestamp.comodoca.com/rfc3161 -digestalg SHA-1   \"D:\\org.apache.commons.io.jar\" {97c93439-21c1-4b7a-a7a1-234f3a4d6260} ");
			//Process process = runtime.exec("cmd /c jarsigner -verify -verbose -certs \"D:\\org.apache.commons.io.jar\"");

			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
				String cursor;
				while ( (cursor = bufferReader.readLine()) != null )
				{
					System.out.println(cursor);
				}
				
		
			
		} catch (IOException e)
		{      
			e.printStackTrace();
		}

	}

}
