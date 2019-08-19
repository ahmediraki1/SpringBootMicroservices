package com.example.actorsMicroService.controller

import com.example.actorsMicroService.exceptions.ResourceNotFoundException
import com.example.actorsMicroService.model.ActorModel
import com.example.actorsMicroService.repository.ActorsRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/actors")
class ActorRestController internal constructor(private val repository: ActorsRepository) {

    @GetMapping
    fun findAll(): List<ActorModel> {
        return repository.findAll()
    }

    @GetMapping(path = ["/{id}"])
    @Throws(ResourceNotFoundException::class)
    fun findById(@PathVariable id: Long): ResponseEntity<ActorModel> {
        return repository.findById(id)
                .map { record -> ResponseEntity.ok().body(record) }
                .orElseThrow { ResourceNotFoundException("Id doesn't exist : $id") }
    }

    @PostMapping
    fun createActor(@RequestBody actorModel: ActorModel): ActorModel {
        return repository.save(actorModel)
    }

    @PutMapping(value = "/{id}")
    @Throws(ResourceNotFoundException::class)
    fun updateActor(@PathVariable("id") id: Long,
                    @RequestBody actorModel: ActorModel): ResponseEntity<ActorModel> {
        return repository.findById(id)
                .map { record ->
                    record.actorName = actorModel.actorName
                    record.actorEmail = actorModel.actorEmail
                    record.actorPhone = actorModel.actorPhone
                    val updated = repository.save(record)
                    ResponseEntity.ok().body(updated)
                }.orElseThrow { ResourceNotFoundException("Id doesn't exist : $id") }
    }

    @DeleteMapping(path = ["/{id}"])
    @Throws(ResourceNotFoundException::class)
    fun deleteActor(@PathVariable("id") id: Long): ResponseEntity<*> {
        return repository.findById(id)
                .map { record ->
                    repository.deleteById(id)
                    ResponseEntity.ok().build<Any>()
                }.orElseThrow { ResourceNotFoundException("Id doesn't exist : $id") }
    }
}
