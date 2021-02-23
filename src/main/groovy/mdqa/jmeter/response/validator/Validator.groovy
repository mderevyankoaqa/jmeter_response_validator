package mdqa.jmeter.response.validator


interface Validator {
    String getValidationMessage()

    boolean isValid()
}