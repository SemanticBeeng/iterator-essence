package org.specs2.blog.iteratoressence.specs

import org.specs2.blog.iteratoressence.scalaz.Functor
import org.specs2.mutable

/**
  *
  */
class FunctorSpec extends mutable.Specification {

  "A tuple is a functor" >> {

    val f = (i : Int) => i.toString
    Functor.Tuple2IsFunctor[Int].fmap(f).apply((2, 3)) must_== (2, "3")
  }
}