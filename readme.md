This project has spark java code to load existing table EMPLOYEE in phoenix (HBase) as dataset and also to update the table with dataset.
1. To set up hbase locally download the latest version of hbase from https://hbase.apache.org
2. Refer https://hbase.apache.org/book.html#quickstart for standalone set up
3. Once you have the hbase up and running in local machine then you can run the java classes present in this project.
To run phoenix related programs:
* Download and expand the latest phoenix-[version]-bin.tar.
* Add the phoenix-[version]-server.jar to the classpath of all HBase region server and master and remove any previous version. An easy way to do this is to copy it into the HBase lib directory (use phoenix-core-[version].jar for Phoenix 3.x)
* Restart HBase.
* Add the phoenix-[version]-client.jar to the classpath of any Phoenix client.

To start Hbase: cd /Applications/HBase/bin
./start-hbase.sh
After that run following command: hbase shell
run following command: list
This should list all the tables in hbase
To start phoenix sqlline: /Applications/apache-phoenix-4.13.1-HBase-1.2-bin/bin
./sqlline.py
After this run following command: !tables
This should list all the tables in phoenix
To create table in phoenix from a sql script:
./psql.py localhost:2181 employeeTableCreate.sql
To load table EMPLOYEE from csv:
./psql.py -t EMPLOYEE localhost:2181 employeePopulate.csv
