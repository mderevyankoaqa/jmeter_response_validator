package mdqa.jmeter.response.validator.models

import org.apache.jmeter.threads.JMeterContext

class TestContext {
    private JMeterContext ctx
    private Request request
    private Response response

    TestContext(JMeterContext ctx)
    {
        this.ctx = ctx
        this.request = new Request(this.ctx)
        this.response = new Response(this.ctx)
    }

    Request getRequest()
    {
        return this.request
    }

    Response getResponse()
    {
        return this.response
    }
}
