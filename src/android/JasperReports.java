package com.eiq;

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
public class JasperReports extends CordovaPlugin {

    /**
     * @param args the command line arguments
     */
    public static final String TAG = "Jasper Reports";

    /**
     * Constructor.
     */
    public JasperReports() {
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
        Log.v(TAG, "JasperReports action received:" + action);
        Log.v(TAG, "JasperReports args received:" + args);
        if (action.equals("xml2pdf")) {
            cordova.getActivity().runOnUiThread(new Xml2Pdf(args.getString(0), args.getString(1), args.getString(2), callbackContext));
        }
        return true;
    }
}
