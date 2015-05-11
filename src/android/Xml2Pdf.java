package com.eiq;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.apache.cordova.CallbackContext;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author eislas
 */
public class Xml2Pdf implements Runnable {

    String xmlFilePath, jrxmlFilePath, pdfOutputPath;
    CallbackContext callbackContext;

    public Xml2Pdf(String xmlFilePath, String jrxmlFilePath, String pdfOutputPath, CallbackContext callbackContext) {
        this.xmlFilePath = xmlFilePath;
        this.jrxmlFilePath = jrxmlFilePath;
        this.pdfOutputPath = pdfOutputPath;
        this.callbackContext = callbackContext;
    }

    @Override
    public void run() {
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFilePath);
            JRXmlDataSource xmlDataSource = new JRXmlDataSource(xmlFilePath, "XPath Query");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), xmlDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfOutputPath);
            JSONObject r = new JSONObject();
            try {
                r.put("success", true);
            } catch (JSONException ex1) {
                Logger.getLogger(Xml2Pdf.class.getName()).log(Level.SEVERE, null, ex1);
            }
            callbackContext.success(r);
        } catch (JRException ex) {
            Logger.getLogger(Xml2Pdf.class.getName()).log(Level.SEVERE, null, ex);

            JSONObject r = new JSONObject();
            try {
                r.put("success", false);
                r.put("error", ex);
            } catch (JSONException ex1) {
                Logger.getLogger(Xml2Pdf.class.getName()).log(Level.SEVERE, null, ex1);
            }
            callbackContext.error(r);
        }
    }
}
