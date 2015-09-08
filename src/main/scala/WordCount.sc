

import scala.io._
val path="/Users/mark/Git/Github/coursera_2014_FP_in_scala/HadoopCon2015_Scala_Demo"

val lines= Source.fromFile(s"$path/README.md")
  .getLines
//sol 1
import scala.io._
val words=lines.flatMap(_.split(" "))
words.toList.groupBy(w=>w)
  .map(v=>v._1->v._2.size)
words.toList.groupBy(w=>w)
  .mapValues(_.size)

//sol 2
words.foldLeft(Map.empty[String, Int])(
  (map, word) => {
    map + (word ->(map.getOrElse(word, 0) + 1))
  }
)


