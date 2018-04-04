package com.test

import org.scalatest._

class NestedSpecs extends Suites (
    new TestSpec
)

@DoNotDiscover
class TestSpec extends Spec {

	def `TestSpec-test-1 `: Unit = {}

	def `TestSpec-test-2 `: Unit = {}
	
	def `TestSpec-test-3 `: Unit = {}
}