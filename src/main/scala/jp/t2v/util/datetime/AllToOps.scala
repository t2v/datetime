package jp.t2v.util.datetime

trait AllToOps extends ToInstantOps with NumericToOps with ToPeriodOps with ToDurationOps

object AllToOps extends AllToOps
