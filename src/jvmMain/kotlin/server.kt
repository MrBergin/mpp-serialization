import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.util.*
import kotlinx.html.*

fun HTML.index() {
    head {
        title("Hello from Ktor!")
    }
    body {
        div {
            +"Hello from Ktor"
        }
        div {
            id = "root"
        }
        script(src = "/static/output.js") {}
    }
}

@KtorExperimentalAPI
fun main() {
    embeddedServer(CIO, port = 8080, host = "127.0.0.1") {
        install(ContentNegotiation) {
            json()
        }
        install(CORS) {

        }
        routing {
            get("/") {
                call.respondHtml(HttpStatusCode.OK, HTML::index)
            }
            get("/foo") {
                call.respond(Foo("baz"))
            }
            static("/static") {
                resources()
            }
        }
    }.start(wait = true)
}