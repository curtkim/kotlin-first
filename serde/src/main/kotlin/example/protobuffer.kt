package example

import kotlinx.serialization.*
import kotlinx.serialization.protobuf.ProtoBuf

@Serializable
data class Project(val name: String, val language: String)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = Project("kotlinx.serialization", "Kotlin")
    val bytes = ProtoBuf.encodeToByteArray(data)
    println(bytes.toAsciiHexString())
    val obj = ProtoBuf.decodeFromByteArray<Project>(bytes)
    println(obj)
}

private fun ByteArray.toAsciiHexString(): String = joinToString(separator = "") { eachByte -> "%02x".format(eachByte) }

