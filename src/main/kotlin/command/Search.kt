package net.moeyuki.mirai.nbnhhsh.command

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.CompositeCommand
import net.moeyuki.mirai.nbnhhsh.MiraiConsoleNbnhhsh

object Search : CompositeCommand(
    owner = MiraiConsoleNbnhhsh,
    primaryName = "hhsh",
    description = "查询拼音缩写对应的全称",
) {
    @SubCommand("search", "查询", "查询缩写", "缩写查询")
    suspend fun CommandSender.search(text: String) {
        val client = HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json()
            }
        }

        @Serializable
        data class Text(val text: String)

        @Serializable
        data class ResponseText(val name: String, val trans: List<String>)

        try {
            val response = client.post {
                url("https://lab.magiconch.com/api/nbnhhsh/guess")
                contentType(ContentType.Application.Json)
                setBody(Text(text))
            }

            if(response.status.value != 200){
                sendMessage("api连接失败，请检查网络或api状态")
                return
            }

            val json = Json { ignoreUnknownKeys = true }
            val trans = json.decodeFromString<List<ResponseText>>(response.body())[0].trans.toString()

            val result = trans.substring(1, trans.length - 1).replace(",", "\n").replace(" ", "")
            sendMessage("\"${text}\"可能对应的意思如下：\n" + result)
        }catch (e:java.io.IOException){
            sendMessage("api连接失败，请检查网络或api状态")
        }catch (e:Exception){
            sendMessage("查询失败，未查询到缩写对应的数据")
        }
        finally {
            client.close()
        }
    }
}