import play.api.libs.json.Json
import play.api.libs.json.JsValue
import java.lang.String
import scala.util.Try

object HelloWorld {
  //def parseDouble(s: String) = try { s.toDouble } catch { case _ => 0.0 }

  def convertStringToDouble(json: JsValue, default: Double): Double = {
    return Try((json).asOpt[String].getOrElse("").toDouble).toOption.getOrElse(default)
  }

  def main(args: Array[String]) {
    println("Hello, world!")

    val line = """
      {
        "user_agent": "curl/7.35.0",
        "path": "/201307/09grZeMhnj4omm9VyqkMUZ4lXSOsBcSXKAcmocUCeJ2Dky3dVmuo8sHpZtS4fa6TuAj6qP8O",
        "timestamp": 1572880652.87415,
        "client_ip": "104.215.29.246",
        "status_code": 200,
        "cache_status": "TCP_HIT",
        "bytes_out": 4170953,
        "write_time": 0.217675,
        "server_ip": "152.195.137.109",
        "method": "GET",
        "host": "cdn-azure-audio.kfs.io",
        "query": "xymon=1&__ec3__=qd9wQ_vlKGNA8p50t5HYYQhUzCcT5CMMVsQVqtvjnn32PlQFh9tqmp4smwn_MLx-B4RZXukus79_u8S15_dAivGKqRODhpAryJeKNqTz4cqpDPBbd7paalFmQ2AJtac7i5B2r4kQoIlRNo5swnWbuJDXlgp86GJEbeAmq3AM6PN7yIERo0Lzai58zyic9Q",
        "referer": "",
        "client_asn": 8075,
        "client_country_code": "JP",
        "time-taken": 0.217675,
        "sc-status": 200,
        "sc-bytes": 4170953,
        "c-ip": "104.215.29.246",
        "received_at": 1572880652,
        "cs-ip_detail": {
            "host": "104.215.29.246",
            "asnum": 8075,
            "country_code": "JP"
        },
        "cs-uri_detail": {
            "scheme": null,
            "host": "cdn-azure-audio.kfs.io",
            "port": null,
            "path": "/201307/09grZeMhnj4omm9VyqkMUZ4lXSOsBcSXKAcmocUCeJ2Dky3dVmuo8sHpZtS4fa6TuAj6qP8O",
            "query": {
                "xymon": "1",
                "__ec3__": "qd9wQ_vlKGNA8p50t5HYYQhUzCcT5CMMVsQVqtvjnn32PlQFh9tqmp4smwn_MLx-B4RZXukus79_u8S15_dAivGKqRODhpAryJeKNqTz4cqpDPBbd7paalFmQ2AJtac7i5B2r4kQoIlRNo5swnWbuJDXlgp86GJEbeAmq3AM6PN7yIERo0Lzai58zyic9Q"
            }
        }
      }
      """
    val json = Json.parse(line)
    println(json)
    println("---")

    // println(convertStringToDouble(json \ "lat", 0.0))

    val value = (json \ "timestamp")
    println(value)
    //val converted = value.asOpt[String].getOrElse((json).asOpt[Double].getOrElse(0.0))
    val converted = (value.asOpt[Double].getOrElse(0.0) * 1000).toLong
    println(converted)
  }
}
