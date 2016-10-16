<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:template match="/">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="A4-portrait"
					page-height="29.7cm" page-width="21.0cm" margin="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="A4-portrait">
			 
      
				<fo:flow flow-name="xsl-region-body">
					<fo:block></fo:block>
					<xsl:for-each select="invoice">
                    <fo:block>info</fo:block>
                    <fo:block break-after="page"></fo:block>
						<xsl:apply-templates select="." />

					</xsl:for-each>



				</fo:flow>
			</fo:page-sequence>
		</fo:root>


	</xsl:template>

	<xsl:template match="invoice-view">
	
		<xsl:for-each select="out">
			<fo:block>
				<xsl:value-of select="position()" /> **<xsl:value-of select="last()" />=<xsl:value-of select="invoice-id" />
			</fo:block>
			<xsl:variable name="flag" >true</xsl:variable>
		</xsl:for-each>
		<fo:block break-after="page"></fo:block>
		<xsl:apply-templates select="summary" />
		 
	</xsl:template>
	<xsl:template match="summary">
	<fo:block><xsl:value-of select="info" /></fo:block>
	<fo:block break-after="page" ></fo:block>
	</xsl:template>
	
</xsl:stylesheet>