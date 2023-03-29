# swagger_spring_mongo
task2

/bean

used to check the body formats of requests during seding and receiving from endpoints .

/controller

The Controller layer is the conductor of operations for a request. It controls the transaction scope and manages the session related information for the request. The controller first dispatches to a command and then calls the appropriate view processing logic to render the response.

/entity

Provided schema to communicate with database(MongoDb) and to handle the data layer.

/respository

Created DAO(Data Access Objects) to perfrom CRUD operations on the data base.

/service

Written logics that are used by controller to perform actions requested by clients to perform CRUD operations.

/serviceApiApllication.java

Main driver class to load application contexts.


here we used swagger(An great tool to automatically generate API documentation and WEB UI to test API and responses) instead of postmen.
Swagger

![image](https://user-images.githubusercontent.com/85479401/228585155-05802a9b-9497-4c12-8740-6e09cba05dcc.png)

![image](https://user-images.githubusercontent.com/85479401/228585187-f2197cec-9f62-4792-9dce-7828587a3613.png)

![image](https://user-images.githubusercontent.com/85479401/228585217-9c2aa2be-bb1a-498f-be32-48dc388a975b.png)

