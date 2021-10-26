package mdqa.jmeter.response.validator

import mdqa.jmeter.response.validator.models.TestContext

abstract class ValidatorBase implements Validator {

    protected String validationMessage = ""
    TestContext testContext

    protected ValidatorBase(TestContext ctx)
    {
        this.testContext = ctx
    }

    @Override
    String getValidationMessage() {
        return this.validationMessage
    }

    @Override
    boolean isValid() {
        if (this.validationMessage?.trim())
        {
            return false
        }

        return true
    }
}