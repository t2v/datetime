# t2v-datetime

A Scala Wrapper for JSR310

 **This project is suspended until ThreeTen is unstable.**
 **Please examine using [nscala-time](https://github.com/nscala-time/nscala-time) instead of t2v-datatime.**

# dependencies

- Scala 2.10.0-RC5
- [ThreeTen](https://github.com/ThreeTen/threeten)

# install

1. Add `ProjectRef` into your `project/Build.scala`. 
    
    ```scala
    import sbt._
    import Keys._
    
    object ApplicationBuild extends Build {
      
      lazy val main = Project(id = "main", base = file(".")).dependsOn(datetime)
      
      lazy val datetime = uri("https://github.com/t2v/datetime.git")
      
    }
    ```

**Keep in mind that t2v-datetime is depends on unstable libraries.**

# usage

## Instant

```scala
import javax.time._
import jp.t2v.util.datetime._

scala> now
res0: javax.time.Instant = 2012-12-09T18:12:35.490Z

scala> now > res0
res1: Boolean = true

scala> res0 + 10.days + 3.minutes
res2: javax.time.Instant = 2012-12-19T18:15:35.490Z
```

## Period and Duration

```scala
import javax.time._
import jp.t2v.util.datetime._

scala> 10.years
res0: javax.time.Period = P10Y

scala> 10.months
res1: javax.time.Period = P10M

scala> 10.weeks
res2: javax.time.Period = P70D

scala> 10.days
res3: javax.time.Period = P10D

scala> 10.hours
res4: javax.time.Duration = PT36000S

scala> 10.minutes
res5: javax.time.Duration = PT600S

scala> 10.seconds
res6: javax.time.Duration = PT10S

scala> 10.milliseconds
res7: javax.time.Duration = PT0.01S
```

```scala
// Duration + Duration = Duration
scala> 10.minutes + 3.seconds
res8: javax.time.Duration = PT603S

// Duration + Period = Period
scala> 10.hours + 10.days
res9: javax.time.Period = P10DT10H

// Period + Duration = Period
scala> 3.months + 10.seconds
res10: javax.time.Period = P3MT-10.S

// Period + Period = Period
scala> 3.months + 10.days
res11: javax.time.Period = P3M10D
```
