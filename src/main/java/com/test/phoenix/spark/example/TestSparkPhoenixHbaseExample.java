package com.test.phoenix.spark.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import com.google.common.collect.ImmutableMap;




public class TestSparkPhoenixHbaseExample {
	
	public static void main(String[] args){
		 SparkSession spark = SparkSession
			      .builder().master("local")
			      .appName("Java Spark SQL data sources example")
			      .config("spark.some.config.option", "some-value")
			      .getOrCreate();
		 
		 SQLContext sql = spark.sqlContext();
		Map<String,String> map = new HashMap<String,String>();
		map.put("driver","org.apache.phoenix.jdbc.PhoenixDriver");
		map.put("url","jdbc:phoenix:localhost:2181:/hbase");
		map.put("dbtable","EMPLOYEE");
		Dataset<Row> employeeDs = sql.read().format("jdbc")
	                .options(map)
	                .load();
		employeeDs.show();
		employeeDs.printSchema();
		
		Employee emp1 = createEmployee(40010L, "John", "Doe", "CA", "Pleasanton", "94588", "USA");
		Employee emp2 = createEmployee(40011L, "Tom", "Hanks", "NY", "Rochester", "14602", "USA");
		Employee emp3 = createEmployee(40012L, "Jim", "Carrey", "NC", "Charlotte", "28105", "USA");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		
		JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
		JavaRDD<Employee> employeeRDD = jsc.parallelize(employees);
		Dataset<Row> employeeDF = sql.createDataFrame(employeeRDD, Employee.class);
		employeeDF.write().format("org.apache.phoenix.spark").mode(SaveMode.Overwrite)
        .options(ImmutableMap.of("driver", "org.apache.phoenix.jdbc.PhoenixDriver","zkUrl",
                "jdbc:phoenix:localhost:2181:/hbase","table","EMPLOYEE")).save();
		jsc.close();
		spark.close();
		
		
		
	}
	
	public static Employee createEmployee(Long id, String firstName, String lastName, String state, String city,String zipCode, String country){
		Employee emp = new Employee();
		emp.setId(id);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setState(state);
		emp.setCity(city);
		emp.setZipCode(zipCode);
		emp.setCountry(country);
		emp.setCreated_date(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		emp.setLast_updated(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		return emp;
		
	}

}
