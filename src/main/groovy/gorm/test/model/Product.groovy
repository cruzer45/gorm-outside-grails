package gorm.test.model

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class Product implements GormEntity<Product> {
    String name
    String qbReferenceNumber

    String uuid
    Date createdDate
    Date editedDate

    static constraints = {
        uuid display: false
        createdDate display: false
        editedDate display: false
    }

    String toString() {
        name
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'seq_Product']
        sort "name"
        order "asc"
    }

    def beforeValidate() {
        if (!createdDate) {
            createdDate = GregorianCalendar.instance.time
        }
        if (!editedDate || isDirty()) {
            editedDate = GregorianCalendar.instance.time
        }
        if (!uuid) {
            uuid = UUID.randomUUID().toString()
        }
    }
}
