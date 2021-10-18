package gorm.test.model

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class ReceiptDetail implements GormEntity {

    String qbReference
    Product product
    Integer quantity

    String uuid
    Date createdDate
    Date editedDate


    static constraints = {

        qbReference blank: false
        product nullable: false
        quantity nullable: false


        uuid display: false
        createdDate display: false
        editedDate display: false
    }

    String toString() {
        uuid
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'seq_ReceiptDetail']
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
