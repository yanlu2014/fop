package fop;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class FopReport {

	private static final FopFactory fopFactory = FopFactory
			.newInstance(new File(".").toURI());
   private static String srcFile="E:/debug/fop/example";
   private static String descFile="E:/debug/fop/example";

	public static void main(String[] args) throws Exception {

		new FopReport().run();
		System.out.println("success");
	}

	public void run() throws Exception {
		File fo = new File(srcFile+"/helloworld.fo");
		File pdf = new File(descFile+"/helloworld.pdf");
		convertFO2PDF(fo, pdf);
	}

	public void convertFO2PDF(File fo, File pdf) throws Exception {
		// Construct driver

		FOUserAgent userAgent = fopFactory.newFOUserAgent();
		OutputStream out = null;
		out = new FileOutputStream(pdf);
		out = new BufferedOutputStream(out);
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, out);
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source source = new StreamSource(fo);
		Result res = new SAXResult(fop.getDefaultHandler());
		transformer.transform(source, res);
		out.close();
	}
}
