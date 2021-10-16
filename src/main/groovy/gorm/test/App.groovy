/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package gorm.test

import gorm.test.model.DataSource
import gorm.test.model.Product
import groovy.util.logging.Slf4j

@Slf4j
class App {
    String getGreeting() {
        return 'Hello world.'
    }

    static void main(String[] args) {

        DataSource dataSource = new DataSource()
        dataSource.initializeDataSource()


        Product.withNewTransaction {

            50.times {
                Product product = new Product()
                product.name = "Sample Product ${GregorianCalendar.instance.time.time}"
                product.qbReferenceNumber = UUID.randomUUID().toString()
                product.save(flush: true, failOnError: true)
            }


        }


        Product.withNewSession {
            log.info("Product count is now ${Product.count}")
        }

        log.info("Program execution Finished")

//        println new App().greeting
    }
}
