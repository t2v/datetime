package jp.t2v.util.datetime

import javax.time.{Clock, Instant}
import javax.time.calendrical.DateTime.{MinusAdjuster, PlusAdjuster}

class InstantOps(underlying: Instant) extends Ordered[Instant] {

  def +(adjuster: PlusAdjuster): Instant = underlying.plus(adjuster)

  def -(adjuster: MinusAdjuster): Instant = underlying.minus(adjuster)

  def compare(that: Instant): Int = underlying.compareTo(that)

}
trait ToInstantOps {

  implicit def instantToRichInstant(instant: Instant): InstantOps = new InstantOps(instant)

}

trait InstantInstances {
  
  implicit val orderingInstant: Ordering[Instant] = Ordering.ordered(identity)

}
trait InstantFunctions {

  def now(implicit clock: Clock = Clock.systemUTC) = Instant.now

}
object instant extends ToInstantOps with InstantInstances with InstantFunctions