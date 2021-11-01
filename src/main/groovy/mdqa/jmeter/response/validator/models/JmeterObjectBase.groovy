package mdqa.jmeter.response.validator.models

import org.apache.jmeter.samplers.SampleResult
import org.apache.jmeter.threads.JMeterContext

abstract class JmeterObjectBase {

    protected JMeterContext ctx
    protected SampleResult prev

    protected JmeterObjectBase(JMeterContext ctx)
    {
        this.ctx = ctx
        this.prev = this.ctx.getPreviousResult()
    }
}
