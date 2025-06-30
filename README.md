SauceDemo-Selenium Automation Framework

1.Purpose&Description:

This project automates SauceDemo web application and perform login , product count, Add to cart and checkout and Logout functionality using Selenium webdriver, Java, TestNG and Extent Reports for reporting. 


2.Tools & TechStack:

| Component | Purpose | | -------------- | ------------------------------------------------ | | Java | Programming language | | Selenium Webdriver|Tool | | TestNG | Test framework for execution and assertions | | Extent Reports | Advanced test reporting and logging | | Maven | Dependency and build management | | Jenkins | Continuous Integration and Deployment (optional) | | Git | Version control |

3.Features:

    1.	Complete functionality of SauceDemo 
    2.	Login, Product Count, AddtoCart, Checkout and Logout process
    3.	Environment-specific configuration via config.properties
    4.  User details and check out details in data.csv file
    5.	TestNG as the test execution engine for flexible test management
    6.	Advanced, detailed HTML reports powered by Extent Reports
    7.	CI/CD pipeline setup via Jenkins (or GitHub Actions, easily extendable)


4.Configuration:

    1.	Java installed and configured
    2.	Maven installed (mvn command available)
    3.	IDE of choice (IntelliJ, Eclipse, VSCode)
    4.	Jenkins (optional) for CI/CD
    5.	Clone the Repository: 
    `bash git clone https://your-repo-url.git cd your-project `
    6.	Install Dependencies: 
    `bash mvn clean install `


5.How to Execute Tests:

    1. Run all tests via Maven: 
        `bash mvn test `
    2. Run tests using TestNG suite: 
        `bash mvn test -DsuiteXmlFile=testng.xml `


6.Reporting Structure:

•	Extent Reports: After test execution, detailed HTML reports will be generated in the target/ExtentReport folder. Open extent-report.html in your browser to view a rich, interactive report includes,

    •	Passed/Failed/Skipped tests
    •	Detailed logs and screenshots (if any)
    •	Test execution time and environment info


7.Future Enhancement:

    •	Add Cucumber BDD framework to enhance all stakeholder to collaborate
    •	Implement parallel test execution and distributed testing
