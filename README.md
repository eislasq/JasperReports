# JasperReports
Plugin cordova para llenar un reporte Jasper con un xml por medio de XPath Query


#Instalacion 
```
cordova plugin add https://github.com/eislasq/JasperReports
```


#Uso
```
JasperReports.xml2pdf('/path/to/xmlDataSource.xml','/path/to/report.jrxml', '/path/to/saveOutput.pdf',successCallback(response){}, errorCallcack(response){})
```
