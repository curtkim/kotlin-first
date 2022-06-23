import khttp.responses.Response
import org.json.JSONObject

fun main(args : Array<String>) {
    val r = khttp.get("http://httpbin.org/get")
    println(r.statusCode)

    val r2 = khttp.get(
        url = "http://httpbin.org/get",
        params = mapOf("key1" to "value1", "keyn" to "valuen"))
    println(r2.text)

    val r3 = khttp.post(
        url = "http://httpbin.org/post",
        json = mapOf("key1" to "value1", "keyn" to "valuen"))
    println(r3.text)

    val response : Response = khttp.get("http://httpbin.org/get")
    val obj : JSONObject = response.jsonObject
    print(obj)
}
