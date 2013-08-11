/* Variables / Values */

var x = 3.0
x = 4.0

val y = "abc"
// y = "def" // cannot reassign val


/* Strings */
"1" * 5                    // String = 11111
"12345".length             // [Int] = 5
"abcdefghi".slice(1,3)     // String = bc
List(1,2,3).mkString("|")  // String = 1|2|3
List(1,2,3).mkString("{{", "|", "}}")  // String = {{1|2|3}}


/* List */

val fruits = List( "apple", "orange", "raisin", "kiwi" )   // List[String] = List(apple, orange, raisin, kiwi)
val grades = List(60,70,80)                                // List[Int] = List(60, 70, 80)
val mixed = List(1,"a",List(1))                            // List[Any] = List(1, a, List(1))
val nums:List[Double] = List(6,7,8)                        // List[Double] = List(6.0, 7.0, 8.0)

fruits.length    // 4
val somefruits = fruits.filter(x => x.length == 6)         // List[String] = List(orange, raisin)
val somefruit2 = fruits.filter(_.length == 6)              // List[String] = List(orange, raisin)
List("Paris", "London").map(_.length)                      // List[Int] = List(5, 6)
List(1,2,3,4,5).reduceLeft[Int](_*_)                       // Int = 120
List(1,2,3,4,5).sum                                        // Int = 15
List('a','b','c').zipWithIndex foreach { case(value,index) => print(value,index) }   // (a,0)(b,1)(c,2)

List(1,2,3) :: List(4,5,6)                                 // List(List(1, 2, 3), 4, 5, 6)       Adds an element at the beginning of this list.
List(1,2,3) ::: List(4,5,6)                                // List(1, 2, 3, 4, 5, 6)             Adds the elements of a given list in front of this list.
List(1,2,3) ++ List(4,5,6)                                 // List(1, 2, 3, 4, 5, 6)
List(1,2,3).reverse                                        // List[Int] = List(3, 2, 1)
List(5,3,8,6,1,9,0,7,2,4).sorted                           // List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

(0 /: List(1,2,3,4,5,6,7,8,9,10))(_ + _)                   // Int = 55
(List(1,2,3,4,5,6,7,8,9,10) :\ 0)(_ + _)                   // Int = 55

/* Tuples */
def minmax(a: Int, b: Int): (Int, Int) = if (a < b) (a, b) else (b, a)
val (x, y) = minmax(10, 3)               // (Int, Int) = (3,10)
(10,20).swap                             // (Int, Int) = (20,10)
(2, "ab") == (2, "ab")                   // Boolean = true
(2,"c",4).productArity                   // Int = 3
(2,"c",4)._2                             // String = c
(2,"c",4).productIterator.foreach(println)
1->2                                     // (Int, Int) = (1,2)


val tuple = ("Mike", 40, "New York")
x = 3, y = 10

val tuple = ("Mike", 40, "New York")
tuple match  {
  case (name, age, city) => {
    println("Name: " + name)
    println("Age: " + age)
    println("City: " + city)
  }
}

val words = List((3, "cha"),(2, "bora")).map{ case(i,s) => s * i }    // List[String] = List(chachacha, borabora)

val x = for(i<-(1 to 3); j<-(10 to 12)) yield (i,j)                   // Vector((1,10), (1,11), (1,12), (2,10), (2,11), (2,12), (3,10), (3,11), (3,12))
for { a <- List(1,2,3); b <- List("a","b"); c <- List(4,5,6) } yield (a,b,c)
// List[(Int, String, Int)] = List((1,a,4), (1,a,5), (1,a,6), (1,b,4), (1,b,5), (1,b,6), (2,a,4), (2,a,5), (2,a,6), (2,b,4), (2,b,5), (2,b,6), (3,a,4), (3,a,5), (3,a,6), (3,b,4), (3,b,5), (3,b,6))

/* Maps */
val m = Map(1->2, 3->4)
Map("key1" -> "val1", "key2" -> "val2") foreach { case (k, v) => print(k,v) }   // (key1,val1)(key2,val2)
for ((k,v) <- Map("key11" -> "val1", "key2" -> "val2")) print(k,v)              // (key1,val1)(key2,val2)

/* Functions */
def myadd(x: Int, y: Int) = { x + y }              // Return type inferred
myadd(4,5)    // Int = 9

def myadd2(x: Int, y: Int) : Double = { x + y }    // Return type explicit
myadd2(4,5)   // Double = 9.0

val addme = (x: Int, y: Int) => x + y              // Anonymous Functions
addme(10,20)  // Int = 30

val addmePartially = addme(5, _: Int)              // Need to specify type
addmePartially(6)  // Int = 11

val myadder = addme
myadder(10,11)     // Int = 21

val myadder = myadd _
myadder(10,11)     // Int = 21

def sum( args:Int* ) : Int = args.reduceLeft[Int](_+_)  // Variable args
sum(1,2,3,4,5)     // Int = 15

val L = List       // Reassign function
L(1,2,3)           // List[Int] = List(1, 2, 3)

def concat(s1:String, s2:String) = { s1 + s2 }
concat( s2 = "World", s1 = "Hello " )      // Named parameters. String = Hello World


/* Closure */
def adder(i: Int) = (n: Int) => n + i
val adder1 = adder(1)
val adder11 = adder(11)
adder1(22)     // 23
adder11(33)    // 44

// the currying process transforms a function of two parameters into a function of one parameter which returns a function of one parameter which itself returns the result.
val addcurry = (x: Int) => (y: Int) => x + y
addcurry(3)(5) // Int = 8
addcurry(9)

def add(x:Int)(y:Int) = x + y
add(4)(6)      // Int = 10

def add(x:Int, y:Int, z:Int, n:Int, m:Int) = x + y + z + n + m
add(1,2,3,4,5) // Int = 15


/* Classes */

class Useless
val u = new Useless
u.hashCode             // Int = 26848924
u.toString             // String = Useless@199ae9c
u equals new Useless   // Boolean = false
u.isInstanceOf[Int]    // Boolean = false

class Point(x:Int, y:Int)
val a = new Point(4,6)

class Point(val x:Int, val y:Int)
val a = new Point(4,6)
a.x     // Int = 4
a.y     // Int = 6

class Point(val x:Int, val y:Int) {
  override def toString = "{x=%s,y=%s}".format(x,y)
}


/* XML */

val x = <a><b>1</b><b>2</b><b>3</b></a>       // scala.xml.Elem = <a><b>1</b><b>2</b><b>3</b></a>
x.child(1)                                    // scala.xml.Node = <b>2</b>
x.child(0) == <b>1</b>                        // Boolean = true
x.child(0).text == "1"                        // Boolean = true
x.child contains <b>2</b>                     // Boolean = true
x.child.filter(_.text > "1")                  // Seq[scala.xml.Node] = ArrayBuffer(<b>2</b>, <b>3</b>)
x.mkString                                    // String = <a><b>1</b><b>2</b><b>3</b></a>

val x = <a><b>1</b><c>6</c><b>2</b><c>5</c><b>3</b><c>4</c></a>
x \ "b"                                       // scala.xml.NodeSeq = NodeSeq(<b>1</b>, <b>2</b>, <b>3</b>)
x \ "c"                                       // scala.xml.NodeSeq = NodeSeq(<c>6</c>, <c>5</c>, <c>4</c>)
(x \ "c").map(_.text).mkString(",")           // String = 6,5,4
(<a><b type="1">abc</b><b type="2">def</b></a>).child.map(e => (e \ "@type", e.text)).mkString      // String = (1,abc)(2,def)
val fooElemFromString = scala.xml.XML.loadString("<myroot><b>1</b><b>2</b><b>3</b></myroot>")


/* Stream */
(1 to 1000000000).toStream.foldLeft(0L)(_+_)  // Long = 500000000500000000
(1 to 1000000000).toStream.reduceLeft(_+_)    // Int
(1 to 9).toStream.foldLeft("")(_+_)           // String = 123456789
(1 to 10000000).toStream.filter(x => x > 9999995 && x % 2 == 0).toList  // List[Int] = List(9999996, 9999998, 10000000)


val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
fibs take 100 foreach println

/* Misc */
def isPrime(n:Int) : Boolean = n match { case 0|1 => false; case 2 => true; case _ => (2 to (n/2+1)).exists(n % _ == 0) == false; }
def isPrime(n:Int) : Boolean = n match { case 0|1 => false; case 2 => true; case _ => (2 to (Math.sqrt(n).toInt+1)).exists(n % _ == 0) == false; }
def isPrime(n:Int) : Boolean = Math.max(0,n) match { case 0|1 => false; case 2 => true; case _ => (2 to (Math.sqrt(n).toInt+1)).exists(n % _ == 0) == false; }
(1 to 100).filter(isPrime)                    // Vector(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)

def prime_stream(n:Int) : Stream[Int] = { if(isPrime(n)) { n #:: prime_stream(n+n%2+1) } else { prime_stream(n+n%2+1) } }
prime_stream(3) take 100 foreach { println }


def alpha_stream(n:Int) : Stream[Char] = { ('a' + n%26).toChar #:: alpha_stream(n+1) }
alpha_stream(0) take 60 foreach print          // abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh
(alpha_stream(0) take 30).toList               // List[Char] = List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, a, b, c, d)


/* Parsers */
import scala.util.parsing.combinator._
object MyParsers extends RegexParsers { val integer: Parser[String] = """[0-9]*""".r; val expr: Parser[Any] = integer~integer }
MyParsers.parseAll(MyParsers.expr, "123 456")

object MyParsers extends RegexParsers { val integer: Parser[String] = """[0-9]*""".r; val expr: Parser[Any] = integer~integer ^^ { case l ~ r => (l.toInt-r.toInt) } }
MyParsers.parseAll(MyParsers.expr, "123 456")
res2: MyParsers.ParseResult[Any] = [1.8] parsed: -333

Iterator.continually(Console.readLine).takeWhile(_ != "").foreach(line => println("read " + line))
