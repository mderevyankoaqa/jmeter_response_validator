package mdqa.jmeter.response.validator.models

import groovy.transform.ToString
import org.apache.jmeter.threads.JMeterContext

@ToString(includeNames=true, includeFields=true)
class Response extends JmeterObjectBase{

    String headers
    String body
    String code

    Response(JMeterContext ctx) {
        super(ctx)

        this.headers = this.prev.getResponseHeaders()
        this.body = this.prev.getResponseDataAsString()
        this.code = this.prev.getResponseCode()
    }
}
