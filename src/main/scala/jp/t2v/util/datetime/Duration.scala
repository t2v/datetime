package jp.t2v.util.datetime

import javax.time.{Period, Duration}


class DurationOps(underlying: Duration) extends Ordered[Duration] {
  
  def +(p: Period): Period = p + underlying
  def +(d: Duration): Duration = underlying.plus(d)

  def -(p: Period): Period = p - underlying
  def -(d: Duration): Duration = underlying.minus(d)

  def *(scalar: Long): Duration = underlying.multipliedBy(scalar)

  def compare(that: Duration): Int = underlying.compareTo(that)

}
trait ToDurationOps {

  implicit def durationToDurationOps(d: Duration) = new DurationOps(d)

}
trait DurationInstances {

  implicit val orderingDuration: Ordering[Duration] = Ordering.ordered(identity)
  
}
object duration extends DurationInstances with ToDurationOps
