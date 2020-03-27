import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class AppTest : StringSpec({

    val programOutput = ByteArrayOutputStream()
    System.setOut(PrintStream(programOutput))

    "display first of three pages of a csv file past as argument" {
        main("test.csv")
        programOutput.toString() shouldBe """
             Name|Age|City   |
            -----+---+-------+
            Peter|42 |NewYork|
            Paul |57 |London |
            Mary |35 |Munich |
            N(ext page, P(revious page, F(irst page, L(ast page, eX(it
        """.trimIndent()
    }
})
