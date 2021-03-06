package org.kluge

import grails.test.mixin.*
import org.junit.*

@TestFor(DocumentController)
class DocumentControllerCreateTests {

    @Before
    void setUp() {
        views['/document/_form.gsp'] = getTemplate()
    }

    void testOk() {

        request.method = 'GET'
        def model = controller.create()
        def expected = 'OK'
        assertEquals "'text' should be '${expected}'",
                expected, response.text
        assertEquals "'status' should be 200", 200, response.status

    }

    @Ignore('See http://jira.grails.org/browse/GRAILS-8426')
    void testRequestMethodInvalid() {

        request.method = 'POST'
        controller.create()
        assertEquals "'status' should be 405", 405, response.status

    }

    private String getTemplate() {
        '<g:if test="${documentInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

}