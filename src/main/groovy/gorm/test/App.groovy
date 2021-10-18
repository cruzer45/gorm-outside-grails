/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package gorm.test


import gorm.test.model.Product
import gorm.test.model.Receipt
import gorm.test.model.ReceiptDetail
import groovy.util.logging.Slf4j

@Slf4j
class App {
    String getGreeting() {
        return 'Hello world.'
    }

    static void main(String[] args) {

        DataSource dataSource = new DataSource()
        dataSource.initializeDataSource()

        1000.times {

            Product.withNewTransaction {

                Product product = new Product()
                product.name = "Sample Product ${GregorianCalendar.instance.time.time}"
                product.qbReferenceNumber = UUID.randomUUID().toString()
                product.save(flush: true, failOnError: true)

                Receipt receipt = new Receipt()
                receipt.qbReference = UUID.randomUUID().toString()
                receipt.date = GregorianCalendar.instance.time
                receipt.save(flush: true, failOnError: true)

                ReceiptDetail receiptDetail = new ReceiptDetail()
                receiptDetail.qbReference = UUID.randomUUID().toString()
                receiptDetail.product = product
                receiptDetail.quantity = 5
                receiptDetail.save(flush: true, failOnError: true)


            }

        }

        Product.withNewSession {
            log.info("Product count is now ${Product.count}")
        }

        dataSource.closeDataSource()

        log.info("Program execution Finished")

//        println new App().greeting
    }
}
