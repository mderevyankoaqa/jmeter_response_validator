package mdqa.jmeter.response.validator

import mdqa.jmeter.response.validator.models.Response

class ResponseValidator extends ValidatorBase {

    private Response response

    ResponseValidator thisResponse(Response response)
    {
        this.response = response
        return this
    }

    ResponseValidator shouldHaveCode(String expectedCode) {
        String actualCode = this.response.code

        if (expectedCode != actualCode) {
            this.validationMessage += "ERROR code: Expected <" + expectedCode + "> but we got instead  " + actualCode + "."
        }

        return this
    }

    ResponseValidator shouldContainText(String expectedText) {
        if (!this.response.body.contains(expectedText)) {
            this.validationMessage += "ERROR in body: There is no text <" + expectedText + "> in response."
        }

        return this
    }

    ResponseValidator shouldContainValuesWithOrLogic(String expectedV1, String expectedV2) {
        if (!this.response.body.contains(expectedV1) || !this.response.body.contains(expectedV2)) {
            this.validationMessage += "ERROR in body: There is no text <" + expectedV1 + "> OR <" + expectedV2 + ">  in response."
        }

        return this
    }

    ResponseValidator shouldContainValuesWithOrLogic(String expectedV1, String expectedV2, String expectedV3) {
        if (!this.response.body.contains(expectedV1) || !this.response.body.contains(expectedV2) || !this.response.body.contains(expectedV3)) {
            this.validationMessage += "ERROR in body: There is no text <" + expectedV1 + "> OR <" + expectedV2 + "> OR <" + expectedV3 + "> in response."
        }

        return this
    }
}
