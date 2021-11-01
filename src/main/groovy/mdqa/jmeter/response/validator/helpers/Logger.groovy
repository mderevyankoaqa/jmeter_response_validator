package mdqa.jmeter.response.validator.helpers

interface Logger {

    void isEnabled(boolean flag)
    void saveMessage(String validationError)
}