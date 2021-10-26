package mdqa.jmeter.response.validator

import mdqa.jmeter.response.validator.models.TestContext

class ResponseValidator extends ValidatorBase {

    protected String validationMessage = ""

    protected ResponseValidator(TestContext ctx) {
        super(ctx)
    }

    ResponseValidator shouldHaveCode(String expectedCode) {
        String actualCode = this.testContext.response.code

        if (expectedCode != actualCode) {
            this.validationMessage += "ERROR code: Expected <" + expectedCode + "> but we got instead  " + actualCode + "."
        }

        return this
    }

    ResponseValidator shouldContainText(String expectedText) {
        if (!this.testContext.response.body.contains(expectedText)) {
            this.validationMessage += "ERROR in body: There is no text <" + expectedText + "> in response."
        }

        return this
    }

    ResponseValidator shouldContainValuesWithOrLogic(String expectedV1, String expectedV2) {
        if (!this.testContext.response.body.contains(expectedV1) || !this.testContext.response.body.contains(expectedV2)) {
            this.validationMessage += "ERROR in body: There is no text <" + expectedV1 + "> OR <" + expectedV2 + ">  in response."
        }

        return this
    }

    ResponseValidator shouldContainValuesWithOrLogic(String expectedV1, String expectedV2, String expectedV3) {
        if (!this.testContext.response.body.contains(expectedV1) || !this.testContext.response.body.contains(expectedV2) || !this.testContext.response.body.contains(expectedV3)) {
            this.validationMessage += "ERROR in body: There is no text <" + expectedV1 + "> OR <" + expectedV2 + "> OR <" + expectedV3 + "> in response."
        }

        return this
    }
}
