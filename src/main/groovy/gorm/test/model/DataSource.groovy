package gorm.test.model

import org.grails.orm.hibernate.HibernateDatastore

class DataSource {
    def initializeDataSource() {


        Map configuration = [
                'hibernate.hbm2ddl.auto'    : 'update',
                'dataSource.driverClassName': 'org.postgresql.Driver',
                'dataSource.url'            : 'jdbc:postgresql://localhost:5432/gormTest',
                'dataSource.username'       : 'gormTest',
                'dataSource.password'       : 'gormTest',
        ]

        HibernateDatastore datastore = new HibernateDatastore(configuration, Product)
    }
}
