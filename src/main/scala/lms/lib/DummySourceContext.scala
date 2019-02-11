package lms.lib

import scala.reflect.SourceContext

object DummySourceContext {

  implicit val dummySourceContext: SourceContext = new SourceContext {
    override def update(context: SourceContext): SourceContext = context

    override def bindings: List[(String, Int)] = List()

    override def methodName: String = ""

    override def receiver: Option[String] = None

    override def allContexts: List[List[(String, Int)]] = List()

    override def line: Int = 0
  }
}
