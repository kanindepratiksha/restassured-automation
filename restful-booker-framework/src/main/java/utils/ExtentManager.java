package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReporterObject() {

        String path = System.getProperty("user.dir") + "/reports/extentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("API Automation Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        // 🔹 System Information from Properties file
        extent.setSystemInfo("Tester", "Pratiksha Kaninde");
        extent.setSystemInfo("Environment", ConfigReader.get("env"));
        extent.setSystemInfo("API Base URL", ConfigReader.get("base.url"));

        return extent;
    }
}
