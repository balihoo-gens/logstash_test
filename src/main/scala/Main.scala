package com.balihoo.logstash.test

import org.slf4j.LoggerFactory
import org.slf4s.Logger
import net.logstash.logback.marker.Markers._
import scala.collection.JavaConversions._
import play.api.libs.json._

class Splogger(clazz: Class[_]) extends Logger(LoggerFactory.getLogger(clazz)) {

  def trace(msg: => String, fld: => JsObject): Unit = { underlying.trace(appendFields(fld), msg) }
  def debug(msg: => String, fld: => JsObject): Unit = { underlying.debug(appendFields(fld), msg) }
  def info (msg: => String, fld: => JsObject): Unit = { underlying.info (appendFields(fld), msg) }
  def warn (msg: => String, fld: => JsObject): Unit = { underlying.warn (appendFields(fld), msg) }
  def error(msg: => String, fld: => JsObject): Unit = { underlying.error(appendFields(fld), msg) }

  def trace(msg: => String, fld: => JsObject, e: => Throwable): Unit = { underlying.trace(appendFields(fld), msg, e) }
  def debug(msg: => String, fld: => JsObject, e: => Throwable): Unit = { underlying.debug(appendFields(fld), msg, e) }
  def info (msg: => String, fld: => JsObject, e: => Throwable): Unit = { underlying.info (appendFields(fld), msg, e) }
  def warn (msg: => String, fld: => JsObject, e: => Throwable): Unit = { underlying.warn (appendFields(fld), msg, e) }
  def error(msg: => String, fld: => JsObject, e: => Throwable): Unit = { underlying.error(appendFields(fld), msg, e) }

}

object logstash_test extends App {
  val splog = new Splogger(getClass)
  splog.info("regular message")
  splog.info("message", Json.obj("abc" -> "test"))
  try {
    throw new Exception("badness")
  } catch {
    case e:Exception =>
      splog.error("really exception happened", e)
      splog.error("really bad", Json.obj("exception" -> "happened"), e)
  }
}

