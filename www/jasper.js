var exec = require('cordova/exec');
var JasperReports = function () {
};

JasperReports.xml2pdf = function (xmlFilePath, jrxmlFilePath, pdfOutputPath, succesCallback, errorCallback) {
    console.log("JasperReports.js: xmlString, jrxmlFilePath, pdfOutputPath", xmlFilePath, jrxmlFilePath, pdfOutputPath);
    exec(succesCallback
            , errorCallback
            , "JasperReports",
            'xml2pdf'
            , [xmlFilePath, jrxmlFilePath, pdfOutputPath]
            );
};
module.exports = JasperReports;