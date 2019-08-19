package com.example.showsMicroService.model

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
class ShowModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var moviewId: Long? = null
        set(moviewId) {
            field = this.moviewId
        }

    var moviewName: String? = null
        set(moviewName) {
            field = this.moviewName
        }
    var moviewYear: String? = null
        set(moviewYear) {
            field = this.moviewYear
        }
}
