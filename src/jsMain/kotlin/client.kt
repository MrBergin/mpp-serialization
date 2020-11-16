import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.dom.render

fun main() {
    window.onload = {
        val httpClient = HttpClient(Js) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }

        MainScope().launch {
            println(httpClient.get<Foo> {
                url("http://localhost:8080/foo")
            })
        }

        render(document.getElementById("root")) {
            child(Welcome::class) {
                attrs {
                    name = "Kotlin/JS"
                }
            }
        }
    }
}
