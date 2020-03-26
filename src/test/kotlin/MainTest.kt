import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class MainTest : StringSpec({

    "canary test" {
        val sut = Main()
        val result = sut.foo()
        result shouldBe "Foo"
    }
})
