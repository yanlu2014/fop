package fop;

public class invoice {

	public static void main(String[] args) throws Exception {
		TransFormerUtil.convertToPDF(FilePathUtils.getRealPath("invoice.xml"), FilePathUtils.getRealPath("invoice.pdf"), FilePathUtils.getRealPath("invoice.xsl"));


	}

}
