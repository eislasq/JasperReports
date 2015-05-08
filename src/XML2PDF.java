
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;
import android.content.Intent;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

/**
 *
 * @author eislas
 */
public class XML2PDF extends CordovaPlugin {

    /**
     * @param args the command line arguments
     */
    public static final String TAG = "Jasper Reports";

    /**
     * Constructor.
     */
    public XML2PDF() {
    }

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.v(TAG, "Init Jasper");
    }

    public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        final int duration = Toast.LENGTH_SHORT;
        // Shows a toast
        Log.v(TAG, "XML2PDF action received:" + action);
        Log.v(TAG, "XML2PDF args received:" + args);
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Toast toast = Toast.makeText(cordova.getActivity().getApplicationContext(), action, duration);
                toast.show();

//                JasperReport jasperReport = JasperCompileManager.compileReport("<Path of jrxml file>");
//                JRXmlDataSource xmlDataSource = new JRXmlDataSource("<Path of xml file>", "XPath Query");
//                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), xmlDataSource);
//                JasperExportManager.exportReportToPdfFile(jasperPrint, "<Path of file PDF output file>");
            }
        });
        return true;
    }

//    public static void main(String[] args) {
//        try {
//
//            JasperReport jasperReport = JasperCompileManager.compileReport("<Path of jrxml file>");
//            JRXmlDataSource xmlDataSource = new JRXmlDataSource("<Path of xml file>", "XPath Query");
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), xmlDataSource);
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "<Path of file PDF output file>");
////
////            String reportName = "myreport";
////            Map<String, Object> parameters = new HashMap<String, Object>();
////
////            // compiles jrxml
////            JasperCompileManager.compileReportToFile(reportName + ".jrxml");
////            // fills compiled report with parameters and a connection
////            JasperPrint print = JasperFillManager.fillReport(reportName + ".jasper", parameters);
////            // exports report to pdf
////            JRExporter exporter = new JRPdfExporter();
////            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
////            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(reportName + ".pdf")); // your output goes here
////
////            exporter.exportReport();
//
//        } catch (Exception e) {
//            throw new RuntimeException("It's not possible to generate the pdf report.", e);
//        }
//    }
}
