# JMeter response validator

## Description
It's possible to validate the response code and body. The details of the failed request:
    * Sampler name
    * URL
    * Request data 
    * Response code with headers and body
    * Error details
Can be saved to external system or to the file on the disc. The idea is to have the output which can be addressed to DEV team for the analysis. 

## Compatibility
The supported versions:
* Java 8
* JMeter 5.4.1 and upper 

## Example of the usage
Add JSR223 Assertion with the following code:
~~~~
import mdqa.jmeter.response.validator.*
import mdqa.jmeter.response.validator.models.*
import mdqa.jmeter.response.validator.helpers.*

TestContext testContext = new TestContext(ctx)

ResponseValidator responseValidator = new ResponseValidator()
.thisResponse(testContext.getResponse())
.shouldHaveCode("200")
.shouldContainText("Test")
.shouldContainValuesWithOrLogic("Test11","Boolean")

if (responseValidator.isValid() == false)
{		     
AssertionResult.setFailure(true)
AssertionResult.setFailureMessage(responseValidator.getValidationMessage())

      String csvRow = new CSVRowBuilder(testContext)
					.useDefaultSeparator()
					.putRequest()
					.putResponse()
					.putErrorMessage(responseValidator.getValidationMessage())
					.getRow()
			
	Logger logger = new CsvLogger()
	        // checks whether the validation is enabled using JMeter variable
			logger.isEnabled(vars.get("LogIsEnabled").toBoolean())
			// gets file path from variable
			logger.setFilePath(vars.get("LogPath").toString())
			// replaces the chars to have single line
			logger.saveMessage(csvRow.replace("\n", "").replace("\r", ""))	 

}
~~~~