Spring boot project for <b>Automation</b> testing using <b>Selenium, Cucumber, JUnit5 and AOP</b>.

To run the <b>cucumber tests</b>, use the command below:

mvn clean -Dtest="com.selenium.cucumber.RunCucumberTest" test

<b>Cucumber Features</b> can be executed in parallel using the <b>JUnit Platform</b> by setting the property below.

@ConfigurationParameter(key = Constants.PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true")
