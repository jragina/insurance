# insurance
the following request can be used for caluclations using RESTFUL API:
curl --location --request POST 'http://localhost:8080/calculate-premium' \
--header 'Content-Type: application/json' \
--data-raw '{
    "PolicyModel":{
        "number":"2169420",
        "status":"APPROVED",
        "policies":[
            {
                "name":"Potato policy",
                "subObjects":[
                    {
                        "subObjectName":"socks - 100 eur",
                        "riskType":"FIRE",
                        "sumInsured": 100
                    }
                ]
            }
            
        ]
    }
}'
