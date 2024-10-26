package dev.mbo.springkotlinweb.api

import dev.mbo.logging.logger
import org.springframework.data.domain.Sort

object SortParser {

    private val log = logger()

    /**
     * This method allows to have a list of parameters we want to sort in a db query. The required format is
     * field_name(:(asc|desc))?. If the direction is skipped it defaults to ASC. If there are more : than one and or
     * the second part can't be parsed to ASC or DESC the entry is skipped.
     */
    fun parse(sort: List<String?>?): Sort {
        if (sort.isNullOrEmpty()) {
            return Sort.unsorted()
        }
        val orders: MutableList<Sort.Order> = ArrayList(sort.size)

        for (entry in sort) {
            if (null == entry) continue
            val split = entry.split(":").toTypedArray().filterNot { it.isBlank() }
            var direction: Sort.Direction
            var property: String
            when (split.size) {
                1 -> {
                    direction = Sort.Direction.ASC
                    property = split[0]
                    orders.add(Sort.Order(direction, property))
                }

                2 -> {
                    direction = try {
                        Sort.Direction.fromString(split[1])
                    } catch (exc: IllegalArgumentException) {
                        log.warn("received bad sort direction: {}", exc.message)
                        continue
                    }
                    property = split[0]
                    orders.add(Sort.Order(direction, property))
                }

                else -> log.warn("ignored sort param '{}'", entry)
            }
        }
        return Sort.by(orders)
    }
}
