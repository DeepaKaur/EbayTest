//package rba.steps;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import org.junit.rules.TestWatcher;
//
//
//public class ExtentReportWatcher extends TestWatcher {
//    private static ExtentReports reports;
//    private ExtentTest test;
//
//    public ExtentReportWatcher()  {
//        if (reports == null)
//            reports = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
//    }
//
//    public void testSuccessful(ExtensionContext context) {
//        test.log(LogStatus.PASS, context.getDisplayName() + "passed");
//    }
//
//    public void testFailed(ExtensionContext context, Throwable cause) {
//        test.log(LogStatus.FAIL, context.getDisplayName() + "failed");
//    }
//
//
//    @Override
//    public void afterAll(ExtensionContext context) throws Exception {
//        reports.endTest(test);
//        reports.flush();
//    }
//
//    @Override
//    public void beforeAll(ExtensionContext context) throws Exception {
//        test = reports.startTest(context.getDisplayName(), "Test methods for " + context.getDisplayName());
//    }
//}
