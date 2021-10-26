package mdqa.jmeter.response.validator.helpers

import mdqa.jmeter.response.validator.models.Request
import mdqa.jmeter.response.validator.models.Response
import org.apache.jmeter.services.FileServer
import org.apache.jmeter.threads.JMeterContext

class CsvLogger implements Logger {

    private Request request
    private Response response
    private String path

    boolean isEnabled

    void setFilePath(String path) {
        this.path = path
    }

    void useDefaultPath() {
        this.path = FileServer.getFileServer().getBaseDir() + "/ErrorLogs.csv"
    }

    @Override
    void isEnabled(boolean flag) {
        this.isEnabled = flag
    }

    @Override
    void saveMessage(String message) {

        if (this.isEnabled == true) {
            FileServer.getFileServer().write(this.path, message)
        }
    }
}
