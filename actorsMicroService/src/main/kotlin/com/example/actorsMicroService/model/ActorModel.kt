package com.example.actorsMicroService.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
class ActorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var actorId: Long? = null
        set(actorId) {
            field = this.actorId
        }

    var actorName: String? = null
        set(actorName) {
            field = this.actorName
        }
    var actorEmail: String? = null
        set(actorEmail) {
            field = this.actorEmail
        }
    var actorPhone: String? = null
        set(actorPhone) {
            field = this.actorPhone
        }
}
