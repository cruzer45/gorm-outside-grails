package gorm.test.model

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class Receipt implements GormEntity<Receipt> {

    String qbReference
    Date date
    String uuid
    Date createdDate
    Date editedDate


    static constraints = {
        qbReference blank: false
        date  nullable: false
        uuid display: false
        createdDate display: false
        editedDate display: false
    }

    String toString() {
        uuid
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'seq_Receipt']
        sort "id"
        order "asc"
        //longTextField sqlType: 'text'
        //uuid index
        //reallyLongString type: 'text'
        // uuid  index: 'Name_Idx'
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
