package jp.t2v.util.datetime

import javax.time.{Duration, Period}

class PeriodOps(underlying: Period) {

  def +(p: Period): Period = underlying.plus(p)
  def +(d: Duration): Period = this + Period.of(d)
  
  def -(p: Period): Period = underlying.minus(p)
  def -(d: Duration): Period = this - Period.of(d)

  def *(scalar: Int): Period = underlying.multipliedBy(scalar)

}
trait ToPeriodOps {
  implicit def periodToPeriodOps(p: Period) = new PeriodOps(p)
}
trait PeriodInstances {

}
object period extends PeriodInstances with ToPeriodOps