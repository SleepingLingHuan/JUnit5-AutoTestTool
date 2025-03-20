package AutoTestTool;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import java.util.List;
public class AutoTest {
    public static void main(String[] args) {
        //创建一个测试发现请求，指定要扫描的包
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectPackage("Test"))
                .build();
        Launcher launcher = LauncherFactory.create();

        //创建监听器来收集测试结果
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        //执行测试
        System.out.println("开始运行所有测试...");
        TestPlan testPlan = launcher.discover(request);
        launcher.execute(request);
        TestExecutionSummary summary = listener.getSummary();

        //输出测试结果
        System.out.println("\n=== 测试结果统计 ===");
        System.out.println("总测试用例数: " + summary.getTestsFoundCount());
        System.out.println("通过的测试用例数: " + summary.getTestsSucceededCount());
        System.out.println("失败的测试用例数: " + summary.getTestsFailedCount());

        if (!summary.getFailures().isEmpty()) {
            System.out.println("\n=== 失败的测试用例详情 ===");
            List<TestExecutionSummary.Failure> failures = summary.getFailures();
            for (TestExecutionSummary.Failure failure : failures) {
                System.out.println("测试方法: " + failure.getTestIdentifier().getDisplayName());
                System.out.println("失败原因: " + failure.getException());
                System.out.println("-------------------");
            }
        } else {
            System.out.println("\n所有测试用例均通过！");
        }
    }
}