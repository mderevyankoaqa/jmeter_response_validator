package mdqa.jmeter.response.validator.models

import org.apache.jmeter.threads.JMeterContext

class TestContext {
    private JMeterContext ctx

    TestContext(JMeterContext ctx)
    {
        this.ctx = ctx
    }

    Request getRequest()
    {
        return new Request(this.ctx)
    }

    Response getResponse()
    {
        return new Response(this.ctx)
    }
}
