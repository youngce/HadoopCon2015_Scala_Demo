//A=>B
val f:Double=>Double= x=>Math.pow(x,2) //f(x)=x^2
f(2) //4.0
val g:Int=>String= x=>x.toString
g(3) //g(3):String=3

//(A,B)=>C
//f(x,y)=x^2+y^2
val f_1:(Double,Double)=>Double= {
  (x,y)=>Math.pow(x,2)+Math.pow(y,2)
}
f_1(2,3) //13.0

//summationdef
def summation(a:Int,b:Int,func:Int=>Int):Int={
if (a>b) 0
else  summation(a+1,b,func)+func(a)
}
val f1:Int=>Int=x=>x //f1:Int=>Int
summation(1,3,f1) //6
val f2:Int=>Int=x=>Math.pow(x,2).toInt
//f2:Int=>Int summation(1,3,f2.toInt) //14

//map
val sList=List("1", "2", "3")
val ints=sList.map(s=>s.toInt)
//or val ints=sList.map(_.toInt)

ints//List(1,2,3):List[Int]

//filter
// val ints=List(1, 2, 3)
val even=ints.filter(_ % 2==0)

even//List(2)

//flatMap
val iList= List(List(1), List(2,2), List(3,3,3))
val flat=iList.flatMap(_)
flat//List(1,2,2,3,3,3)



