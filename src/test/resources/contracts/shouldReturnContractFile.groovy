package contracts

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
        body("something")
        status 200
    }
}