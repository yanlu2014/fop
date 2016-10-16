package fop;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang.StringUtils;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class TransFormerUtil {
	// Construct a FopFactory
	private static final FopFactory fopFactory = FilePathUtils.fopFactory;

	/**
	 * 
	 * @param sourceFile
	 * @param desFile
	 * @param middleFile
	 *            中间文件
	 * 
	 * @throws Exception
	 */
	public static void convertToPDF(String sourceFile, String desFile,
			String middleFile) throws Exception {

		// Step 2: Set up output stream.
		OutputStream out = new BufferedOutputStream(new FileOutputStream(
				desFile));
	
		// Step 3: Construct fop with desired output format
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
		// Step 4: Setup XSLT using identity transformer
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = null;
		if (StringUtils.isNotBlank(middleFile)) {
			File file = new File(middleFile);
			transformer = transformerFactory.newTransformer(new StreamSource(
					file));
		} else {
			transformer = transformerFactory.newTransformer();
		}

		// Step 5: Setup input and output for XSLT transformation
		Source source = new StreamSource(new File(sourceFile));
		// Step 6: Resulting SAX events (the generated FO) must be piped through
		// to FOP
		Result res = new SAXResult(fop.getDefaultHandler());
		// Step 7: Start XSLT transformation and FOP processing
		transformer.transform(source, res);
		out.close();
	}
}
