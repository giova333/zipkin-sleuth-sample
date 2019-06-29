package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return all students"

    request {
        url "/students"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body('''
                 [
                        {
                            "name" : "Dean"
                        },
                        {
                            "name" : "Sam"
                        }
                ]
            
            '''
        )

    }
}