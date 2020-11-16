# mpp-serialization
Playing around with mpp serialization

This project has been created by using Intellij IDEA's template for fullstack applications then adding serialization
dependencies myself.

To give it a run "gradle run" and go to locahost:8080, it display the standard "hello" texts the templates offers,
but in the console it should also print Foo(bar=Baz). This is a serializable instance of Foo that has been successfully
serialized from the endpoint "/foo" in the ktor server to JSON and then deserialized by the ktor client. 