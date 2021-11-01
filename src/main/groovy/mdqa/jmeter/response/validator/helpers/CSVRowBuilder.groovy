package mdqa.jmeter.response.validator.helpers

import mdqa.jmeter.response.validator.models.TestContext

class CSVRowBuilder {

    private String csvRow = ""
    private String separator
    private TestContext testContext

    CSVRowBuilder(TestContext ctx)
    {
        this.testContext = ctx
    }

    String getRow()
    {
        return this.csvRow;
    }

    CSVRowBuilder setSeparator(String separator)
    {
        this.separator = separator

        return this
    }

    CSVRowBuilder useDefaultSeparator()
    {
        this.separator = ";"

        return this
    }

    CSVRowBuilder putRequest()
    {

        String requestString = this.testContext.request.name.trim() + this.separator + this.testContext.request.url.trim() + this.separator + this.testContext.request.headers.trim() + this.separator + this.testContext.request.body + this.separator

        this.csvRow += requestString

        return this
    }

    CSVRowBuilder putResponse()
    {
        String responseString = this.testContext.response.code.trim() + this.separator + this.testContext.response.headers.trim() + this.separator + this.testContext.response.body + this.separator

        this.csvRow += responseString

        return this
    }

    CSVRowBuilder putErrorMessage(String error)
    {
        this.csvRow += error

        return this
    }
}
