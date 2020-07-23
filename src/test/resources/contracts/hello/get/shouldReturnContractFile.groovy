package hello.get

import org.springframework.cloud.contract.spec.Contract;

Contract.make {
    description "should return contract file when request"
    request{
        method GET()
        url("/result") {
            queryParameters {
                parameter("text", "something")
            }
        }
    }

    response {
        body("this should be a mock value")
        status 200
    }
}