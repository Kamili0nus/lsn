# Build description
Code is a base core java application. Therefore, no additional build libraries are required. To create a .jar file please build a project artifact.  (`top menu bar -> build -> create artifact` if it will be build in intellij) One file is needed for all the tasks and all of them are being lunched from command line.

## Run Task1
Assuming that java bin folder is added for PATH environment task is running using this schema: 
```
java -jar <directory_of_jar_file>\lsn.jar <task_name> <input list>
```
example for running command line form directory where .jar file is located:
```
java -jar lsn.jar task1 1 10 20 20 2 5
```
<task_name> is case sensitive
## Run Task2
to run this task use description form previous task, example:
```
java -jar lsn.jar task2 1 2 10 7 5 3 6 6 13 0
```
<task_name> is case sensitive
## Run Task3
Last task is being run like previous one, yet in this case additional parameter is being passed in command line: 
```
java -jar <directory_of_jar_file>\lsn.jar <task_name> <number_of_lines_to_read>
<graph_vertices> <graph_vertices>
<graph_vertices> <graph_vertices>
<graph_vertices> <graph_vertices>
```
example:
```
java -jar lsn.jar task3 5
2 3
1 2
5 6
8 2
7 4
```