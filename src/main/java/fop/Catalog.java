package fop;

public class Catalog {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TransFormerUtil.convertToPDF(FilePathUtils.getRealPath("catalog.xml"), FilePathUtils.getRealPath("catalog.pdf"), FilePathUtils.getRealPath("catalog.xsl"));

	}

}
