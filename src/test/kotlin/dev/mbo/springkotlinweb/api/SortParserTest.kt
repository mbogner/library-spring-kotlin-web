package dev.mbo.springkotlinweb.api

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.data.domain.Sort
import java.util.stream.Stream

class SortParserTest {

    @ParameterizedTest
    @MethodSource("productConfigProvider")
    fun parse(entries: List<String>?, expected: Sort) {
        val actual = SortParser.parse(entries)
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun productConfigProvider(): Stream<Arguments> {
            val nullString: String? = null
            return Stream.of(
                Arguments.of(
                    listOf("name:asc", "date:desc"),
                    Sort.by(Sort.Order.asc("name"), Sort.Order.desc("date")),
                ),
                Arguments.of(
                    null,
                    Sort.unsorted(),
                ),
                Arguments.of(
                    emptyList<String>(),
                    Sort.unsorted(),
                ),
                Arguments.of(
                    listOf("name:foo", "date:bar"),
                    Sort.unsorted(),
                ),
                Arguments.of(
                    listOf("name", "date"),
                    Sort.by(Sort.Order.asc("name"), Sort.Order.asc("date")),
                ),
                Arguments.of(
                    listOf("name:desc", "date:asc"),
                    Sort.by(Sort.Order.desc("name"), Sort.Order.asc("date")),
                ),
                Arguments.of(
                    listOf(null, "date"),
                    Sort.by(Sort.Order.asc("date")),
                ),
                Arguments.of(
                    listOf(nullString),
                    Sort.unsorted(),
                ),
            )
        }
    }
}