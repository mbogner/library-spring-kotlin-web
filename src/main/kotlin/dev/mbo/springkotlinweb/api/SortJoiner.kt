package dev.mbo.springkotlinweb.api

import org.springframework.data.domain.Sort

object SortJoiner {
    fun map(sort: Sort): List<String> {
        return sort.map { it.property + ":" + it.direction }.toList()
    }
}
