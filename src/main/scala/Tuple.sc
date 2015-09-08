val tuple1=1->"Java" //tuple1:(Int,String)
val tuple2=(2.0,true) //tuple2:(Double, Boolean)
val tuple3=3->2.0->"Scala" //tuple3:((Int,Double), Boolean)
val tuple4=(3,2.0,"Scala") //tuple4:(Int,Double, Boolean)

tuple4._1//3; tuple4._2//2.0; tuple4._3//Scala
tuple3._1._2

//groupByKey
val list=
  List("Andy","Adam","Asa","Ben","Bill","Carl")
list.groupBy(v=>v.charAt(0))

//reduce
val iList=List(1,2,3,4,5)
//list:List[Int]=List(1,2,3,4,5)
iList.reduce((acc,x)=>acc+x) //res:Int=15
//or iList.reduce(_+_)

//foldLeft
List(1,2,3).foldLeft(0)(_+_) //5
//advance
List(1,2,3).foldLeft(List(0))((acc,x)=>acc:+(acc.last+x)) //List(0,1,3,6)


