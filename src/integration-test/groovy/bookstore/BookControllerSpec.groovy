package bookstore

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.test.mixin.integration.Integration
import spock.lang.Specification

@Integration
class BookControllerSpec extends Specification {
    void "test contentType via render(view:'book' ...)"() {
        given:
        RestBuilder restBuilder = new RestBuilder()

        when:
        RestResponse resp = restBuilder.get("http://localhost:$serverPort/book")

        then:
        resp.text == '{"book":{"title":"hobbit","author":"J.R.R Tolkein"}}'
        resp.headers.getContentType().toString().startsWith("application/json")
    }
}
