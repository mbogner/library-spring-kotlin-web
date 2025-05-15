package dev.mbo.springkotlinweb.api

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.data.domain.Sort

class SortJoinerTest {

    @Test
    fun mapEmpty() {
        assertThat(SortJoiner.map(Sort.unsorted())).isEqualTo(emptyList<String>())
        assertThat(SortParser.parse(emptyList())).isEqualTo(Sort.unsorted())
    }

    @Test
    fun mapElements2() {
        val sort = Sort.by(Sort.Order.asc("name"), Sort.Order.desc("date"))
        val result = listOf("name:ASC", "date:DESC")
        assertThat(SortJoiner.map(sort)).isEqualTo(result)
        assertThat(SortParser.parse(result)).isEqualTo(sort)
    }

    @Test
    fun mapElements3Order1() {
        val sort = Sort.by(Sort.Order.asc("name"), Sort.Order.asc("email"), Sort.Order.desc("date"))
        val result = listOf("name:ASC", "email:ASC", "date:DESC")
        assertThat(SortJoiner.map(sort)).isEqualTo(result)
        assertThat(SortParser.parse(result)).isEqualTo(sort)
    }

    @Test
    fun mapElements3Order2() {
        val sort = Sort.by(Sort.Order.asc("email"), Sort.Order.asc("name"), Sort.Order.desc("date"))
        val result = listOf("email:ASC", "name:ASC", "date:DESC")
        assertThat(SortJoiner.map(sort)).isEqualTo(result)
        assertThat(SortParser.parse(result)).isEqualTo(sort)
    }

}