var exec = require('cordova/exec');
function JasperReports() {
    console.log("JasperReports: is created");
}
JasperReports.prototype.xml2pdf = function (xml, a, b) {
    console.log("GPSSettings.js: goToGPSsettings, xml, a, b", xml, a, b);
    exec(function (result) {
        /*alert("OK" + reply);*/
    },
            function (result) {
                /*alert("Error" + reply);*/
            },
            "XML2PDF",
            xml,
            [7, 8, 9]
            );
}
var gpsSettings = new JasperReports();
module.exports = gpsSettings;