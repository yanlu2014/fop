package fop;


public class HelloWorld {


	public static void main(String[] args) throws Exception {
	
		//TransFormerUtil.convertToPDF(FilePathUtils.getRealPath("helloWorld.fo"), FilePathUtils.getRealPath("helloWorld.pdf"), null);

		TransFormerUtil.convertToPDF(FilePathUtils.getRealPath("sayHello.xml"), FilePathUtils.getRealPath("sayHello.pdf"), FilePathUtils.getRealPath("sayHello.xsl"));

	}

	
}
