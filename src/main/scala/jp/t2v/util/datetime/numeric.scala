package jp.t2v.util.datetime

import javax.time.{Duration, Period}


class IntOps(val underlying: Int) extends AnyVal {

  def year = years
  def years: Period = Period.ZERO.withYears(underlying)

  def month = months
  def months: Period = Period.ZERO.withMonths(underlying)

  def week = weeks
  def weeks: Period = Period.ZERO.withDays(underlying * 7)

  def day = days
  def days: Period = Period.ZERO.withDays(underlying)
  
  def hour = hours
  def hours: Duration = Duration.ofHours(underlying)

  def minute = minutes
  def minutes: Duration = Duration.ofMinutes(underlying)

  def second = seconds
  def seconds: Duration = Duration.ofSeconds(underlying)

  def millisecond = milliseconds
  def milliseconds: Duration = Duration.ofMillis(underlying)
}
trait ToIntOps {
  implicit def intToIntOps(i: Int) = new IntOps(i)
}

object int extends ToIntOps

trait NumericToOps extends ToIntOps

object numeric extends NumericToOps