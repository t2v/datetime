package jp.t2v.util.datetime

import javax.time.Instant
import javax.time.calendrical.DateTime.{MinusAdjuster, PlusAdjuster}

class InstantOps(underlying: Instant) {
  def +(adjuster: PlusAdjuster): Instant = underlying.plus(adjuster)
  def -(adjuster: MinusAdjuster): Instant = underlying.minus(adjuster)
}
trait ToInstantOps {

  implicit def instantToRichInstant(instant: Instant): InstantOps = new InstantOps(instant)

}

trait InstantInstances {
  
  implicit val orderingInstant: Ordering[Instant] = Ordering.ordered(identity)

}
object instant extends ToInstantOps with InstantInstances