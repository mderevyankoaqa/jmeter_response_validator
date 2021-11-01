package mdqa.jmeter.response.validator.models

import groovy.transform.ToString
import org.apache.jmeter.samplers.Sampler
import org.apache.jmeter.threads.JMeterContext

@ToString(includeNames=true, includeFields=true)
class Request extends JmeterObjectBase {
        String name
        String url
        String headers
        String body

        Request(JMeterContext ctx) {
                super(ctx)

                this.name = this.prev.getSampleLabel()
                this.url = this.prev.getUrlAsString()
                this.headers = this.prev.getRequestHeaders()
                this.body = this.getRequestBody()

        }

        private String getRequestBody() {

                String rBody = ""

                Sampler sampler = this.ctx.getCurrentSampler()
                sampler.getArguments().each { arg ->
                        rBody += arg.getStringValue()
                }

                return rBody;
        }
}
