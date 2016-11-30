package bookstore

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.test.mixin.integration.Integration
import spock.lang.Specification
import spock.lang.Unroll

@Integration
class BookControllerSpec extends Specification {
    @Unroll("/book/#action => contentType == #expectedContentType")
    void "test contentType via render(view:'book' ...)"() {
        given:
            RestBuilder restBuilder = new RestBuilder()

        when:
            RestResponse resp = restBuilder.get("http://localhost:$serverPort/book/$action")

        then:
            resp.status == 200
            resp.text == '{"book":{"title":"hobbit","author":"J.R.R Tolkein"}}'
            resp.headers.getContentType().toString().startsWith(expectedContentType)

        where:
            action         | expectedContentType
            'byConvention' | 'application/json'
            'renderBook'   | 'application/json'
    }
}
