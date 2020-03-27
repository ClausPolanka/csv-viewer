import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream

class AppTest : StringSpec({

    val programOutput = ByteArrayOutputStream()
    System.setOut(PrintStream(programOutput))

    "display first of three pages of a csv file past as argument" {
        val csvFile = createCsvFile("""
                    Name;Age;City
                    Peter;42;NewYork
                    Paul;57;London
                    Mary;35;Munich
                    Jaques;66;Paris
                    Yuri;23;Moscow
                    Stephanie;47;Stockholm
                    Nadia;29;Madrid
                """)

        main(csvFile.absolutePath)

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

private fun createCsvFile(content: String): File {
    val file = createTempFile(suffix = ".csv")
    file.writeText(content.trimIndent())
    return file
}
