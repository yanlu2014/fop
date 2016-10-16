package fop;

import java.io.File;
import java.io.IOException;

import org.apache.fop.apps.FopFactory;
import org.xml.sax.SAXException;

public class FilePathUtils {

	public  static  FopFactory  fopFactory=FopFactory.newInstance(new File(".").toURI());
	/*static{
		  try {
			fopFactory = FopFactory.newInstance(new File(getRealPath("conf/fop.xml")));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	
	public static String  getBasicPath(){
		
		return (new File("").toURI().getPath().substring(1)+"/example/");
		
	}
      public static String  getRealPath(String fileName){
		
		return (new File("").getAbsolutePath()+"/example/"+fileName);
		
	}
   public static void main(String[] args)
   {
	   System.out.println("==="+new File("").getAbsolutePath());
   }
}
