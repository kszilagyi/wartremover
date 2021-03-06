package org.wartremover
package test

import org.scalatest.FunSuite

import org.wartremover.warts.Nothing

class NothingTest extends FunSuite with ResultAssertions {
  test("Nothing can't be inferred") {
    val result = WartTestTraverser(Nothing) {
      val x = ???
      x
    }
    assertError(result)("Inferred type containing Nothing")
  }
  test("Nothing wart obeys SuppressWarnings") {
    val result = WartTestTraverser(Nothing) {
      @SuppressWarnings(Array("org.wartremover.warts.Nothing"))
      val x = ???
      x
    }
    assertEmpty(result)
  }
}
