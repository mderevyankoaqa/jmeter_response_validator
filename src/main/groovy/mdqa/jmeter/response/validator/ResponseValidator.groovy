package mdqa.jmeter.response.validator

import mdqa.jmeter.response.validator.models.Response
import org.apache.jmeter.threads.JMeterContext

class ResponseValidator extends ValidatorBase {

    private Response response

    protected ResponseValidator(JMeterContext ctx) {
        super(ctx)
    }

    ResponseValidator thisResponse(Response response) {
        this.response = response
        return this
    }

    ResponseValidator shouldHasCode(String expectedCode) {
        String actualCode = response.code

        if (expectedCode != actualCode) {
            this.validationMessage += "ERROR code: Expected <" + expectedCode + "> but we got instead  " + actualCode + ";"

        }

        return this
    }

    ResponseValidator shouldContainsText(String expectedText) {
        if (!this.response.body.contains(expectedText)) {
            this.validationMessage += "ERROR in body: There is no text <" + expectedText + "> in response;"
        }

        return this
    }

    ResponseValidator shouldNotContainsText(String unexpected) {
        if (this.response.body.contains(unexpected)) {
            this.validationMessage += "ERROR in body: There is unexpected text <" + unexpected + "> in response;"
        }

        return this
    }
}