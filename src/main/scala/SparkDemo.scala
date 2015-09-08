package SparkDemo

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by mark on 9/8/15.
 */
object SparkDemo extends App{

  //Create SparkContext

  val conf=new SparkConf().setAppName("HadoopCon").setMaster("local")
  val sc=new SparkContext(conf)
  //Create RDD
  val rddInts=sc.parallelize(1 to 100)
  //map, filter
  rddInts.map(_+10)
  rddInts.filter(_%2==0)
  //union
  val that=sc.parallelize(100 to 200)
  rddInts union that count() //201

  // groupByKey, reduceByKey
  val rddKV: RDD[(String, Int)] =sc.parallelize(List("a"->1,"b"->1,"b"->1,"c"->1,"c"->1,"c"->1))

  rddKV.groupByKey //RDD[(String, Iterable[Int])]=ShuffledRDD
  rddKV.groupBy(_._1)
    //RDD[(String, Iterable[(String,Int)])]=ShuffledRDD
    .mapValues(_.map(_._2))
  rddKV.reduceByKey(_+_) //RDD[(String, Int)]=ShuffledRDD
  rddKV.groupByKey
    .mapValues(_.sum)

  //word count
  val txt=sc.textFile("$SPAKR_HOME/READMD.md")
  val wordCount=txt.flatMap(i=>i.split("/"))
    .map(i=>i->1)
    .reduceByKey(_+_)
  wordCount.collect





}
