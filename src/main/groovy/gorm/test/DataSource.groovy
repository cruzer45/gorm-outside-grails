package gorm.test

import gorm.test.model.Product
import org.grails.orm.hibernate.HibernateDatastore

class DataSource {

    HibernateDatastore datastore

    def initializeDataSource() {

        /* PostgreSQL */
//        Map configuration = [
//                'hibernate.hbm2ddl.auto'    : 'create-drop',
//                'dataSource.driverClassName': 'org.postgresql.Driver',
//                'dataSource.url'            : 'jdbc:postgresql://localhost:5432/gormTest',
//                'dataSource.username'       : 'gormTest',
//                'dataSource.password'       : 'gormTest',
//        ]


        /* H2 DB */
//        Map configuration = [
//                'hibernate.hbm2ddl.auto'    : 'update',
//                'dataSource.url'            : 'jdbc:h2:./data/data.h2;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE'
//        ]


        /* SQLite */
        Map configuration = [
                'hibernate.hbm2ddl.auto': 'update',
                'hibernate.dialect'     : 'org.sqlite.hibernate.dialect.SQLiteDialect',
                'dataSource.url'        : 'jdbc:sqlite:./data/data.sqlite.db'
        ]

          datastore = new HibernateDatastore(configuration, Product.package)
    }

    def closeDataSource(){
        datastore.close()
    }
}
