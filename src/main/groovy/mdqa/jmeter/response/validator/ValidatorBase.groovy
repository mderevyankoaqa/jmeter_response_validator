package mdqa.jmeter.response.validator

import org.apache.jmeter.threads.JMeterContext

abstract class ValidatorBase implements Validator {

    protected String validationMessage = ""
    JMeterContext jmeterContext

    protected ValidatorBase(JMeterContext ctx)
    {
        this.jmeterContext = ctx
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