<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0"
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
      xmlns:fo="http://www.w3.org/1999/XSL/Format">

<xsl:template match="/">
  <fo:root>
      <fo:layout-master-set>
        <fo:simple-page-master master-name="A4-portrait"
              page-height="29.7cm" page-width="21.0cm" margin="2cm">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="A4-portrait">
        <fo:flow flow-name="xsl-region-body">
        
         <xsl:for-each select="catalog/cd">
    <fo:block>
    <xsl:sort select="artist" case-order=""/>
     <xsl:value-of select="title"/>
      <xsl:value-of select="artist"/>
     </fo:block>
    </xsl:for-each>
        
          
       
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
   
   
</xsl:template>

</xsl:stylesheet>