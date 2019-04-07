package testClasses;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PDF_ReadExample {
	public static String pdfContent;
	private static final String PDFFILENAME = System.getProperty("user.dir")+"/" +"PDFfilename.docx";
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
			driver.get("https://www.tutorialspoint.com/selenium/selenium_tutorial.pdf");
			driver.manage().window().maximize();	
			Thread.sleep(10000);
			readPDFTest();
	//		writePDFToDoc();
	}
	
	public static void readPDFTest() throws Exception
	{
		URL url=new URL("https://www.tutorialspoint.com/selenium/selenium_tutorial.pdf");
		InputStream is=url.openStream();
		BufferedInputStream fileParse=new BufferedInputStream(is);
		PDDocument document =null;
		document=PDDocument.load(fileParse);
	 String pdfContent=	new PDFTextStripper().getText(document);
	System.out.println(pdfContent);
	BufferedWriter bw ;
	FileWriter fw;
	try
	{
		fw = new FileWriter(PDFFILENAME);
		bw = new BufferedWriter(fw);
		bw.write(pdfContent);

		System.out.println("Done");
		/*File file=new File(PDFFILENAME);
		if(file.exists())
		{
			file.createNewFile();
		}
		
			PrintWriter fw=new PrintWriter(file);    
		
	  BufferedWriter bw = new BufferedWriter(fw);
	   // bw.append(pdfContent);
    fw.write(pdfContent);*/  
    System.out.println("Written to a doc");
    fw.close();    
   }catch(Exception e){
	   System.out.println(e);}   
	finally
	{
		
	}
  

	}
	
	public static void writePDFToDoc() throws Exception
	{
		//readPDFTest();
		BufferedWriter bw ;
		FileWriter fw;
		try
		{
			fw = new FileWriter(PDFFILENAME);
			bw = new BufferedWriter(fw);
			bw.write(pdfContent);

			System.out.println("Done");
			/*File file=new File(PDFFILENAME);
			if(file.exists())
			{
				file.createNewFile();
			}
			
				PrintWriter fw=new PrintWriter(file);    
			
		  BufferedWriter bw = new BufferedWriter(fw);
		   // bw.append(pdfContent);
        fw.write(pdfContent);*/  
        System.out.println("Written to a doc");
        fw.close();    
       }catch(Exception e){
    	   System.out.println(e);}   
		finally
		{
			
		}
      
	}
}