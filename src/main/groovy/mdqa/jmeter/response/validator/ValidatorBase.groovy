package mdqa.jmeter.response.validator

abstract class ValidatorBase implements Validator {

    protected String validationMessage = ""

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