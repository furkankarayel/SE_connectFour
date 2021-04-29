import de.htwg.se.ConnectFour.util.{Observable, Observer}

class TestObject extends Observer {
  def update:Unit = println("Check")
}

object ObserverPattern {
  val observable = new Observable
  val observer1 = new TestObject
  val observer2 = new TestObject                  //> observer2  : TestObject = TestObject@26ee7a14
  observable.add(observer1)
  observable.add(observer2)
  observable.notifyObservers
  observable.remove(observer1)
  observable.notifyObservers
  observable.remove(observer2)
  observable.notifyObservers
}