java -jar zipkin-server-2.14.1-exec.jar --STORAGE_TYPE=mysql --MYSQL_DB=zipkin --MYSQL_USER=root --MYSQL_PASS=root@123 --MYSQL_HOST=10.148.224.4 --MYSQL_TCP_PORT=3306

java -jar zipkin-server-2.14.1-exec.jar --STORAGE_TYPE=elasticsearch --ES_HOSTS=http://10.148.224.3:9200