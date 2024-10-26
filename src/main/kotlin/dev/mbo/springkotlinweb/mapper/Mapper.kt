package dev.mbo.springkotlinweb.mapper

interface Mapper<ENTITY, DTO, NEW, UPDATE> {

    fun mapEntityToDto(entity: ENTITY): DTO
    fun mapEntitiesToDtos(entities: List<ENTITY>): List<DTO> {
        return entities.map { mapEntityToDto(it) }
    }

    fun createEntity(dto: NEW): ENTITY
    fun updateEntity(entity: ENTITY, dto: UPDATE)

}