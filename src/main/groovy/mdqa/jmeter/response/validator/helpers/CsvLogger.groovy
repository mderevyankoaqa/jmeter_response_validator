package mdqa.jmeter.response.validator.helpers

import mdqa.jmeter.response.validator.models.Request
import mdqa.jmeter.response.validator.models.Response
import org.apache.jmeter.services.FileServer
import org.apache.jmeter.threads.JMeterContext

class CsvLogger implements Logger {

    private Request request
    private Response response
    private String path

    private String csvRow = ""
    private String separator

    boolean isEnabled

    CsvLogger(JMeterContext ctx)
    {
        this.request = new Request(ctx)
        this.response = new Response(ctx)
    }

    CsvLogger setSeparator(String separator)
    {
        this.separator = separator

        return this
    }

    CsvLogger useDefaultSeparator()
    {
        this.separator = "|"

        return this
    }

    void setFilePath(String path)
    {
        if (path?.trim()) {
            this.path = path
        }
        else
        {
            this.path = FileServer.getFileServer().getBaseDir()+"/ErrorLogs.csv"
        }
    }

    private void putRequest(Request request)
    {

        String requestString = request.name.trim() + this.separator + request.url.trim() + this.separator + request.headers.trim() + this.separator + request.body + this.separator

        this.csvRow += requestString
    }

    private void putResponse(Response response)
    {
        String responseString = response.code.trim() + this.separator + response.headers.trim() + this.separator + response.body + this.separator

        this.csvRow += responseString
    }

    @Override
    void isEnabled(boolean flag) {
        this.isEnabled = flag
    }

    @Override
    void saveErrorMessage(String error) {

        if (error?.trim()) {

            this.csvRow += error

            if (this.isEnabled == true) {
                FileServer.getFileServer().write(this.path, this.csvRow)
            }
        }
    }
}
